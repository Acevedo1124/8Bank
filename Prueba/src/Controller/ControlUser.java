package Controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Ciudades;
import Entity.Rol;
import Entity.Usuario;

import java.util.List;

import Model.ModeloCiudades;
import Model.ModeloRol;
import Model.ModeloUser;
 

@WebServlet("/ControlUser")
public class ControlUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModeloUser Objeto_ModeloUser;
	ModeloRol Objeto_ModeloRol;
	ModeloCiudades Objeto_ModeloCiudades;
	String Usr;
	public void init() {
		 
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
		
			Objeto_ModeloCiudades = new ModeloCiudades(jdbcURL, jdbcUsername, jdbcPassword);
			Objeto_ModeloRol = new ModeloRol(jdbcURL, jdbcUsername, jdbcPassword);

			Objeto_ModeloUser = new ModeloUser(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
		
		}
	}
 

	public ControlUser() {
		super();
	}
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Método que se ejecuta al cargar el controlador
		
		
		Usr = request.getParameter("Usr");
		
		String accion = request.getParameter("accion");
		//System.out.println(Usr);
		try {
			System.out.println(accion);
			if (accion !="" && accion!= null) {
				
				if (accion.equals("Listar"))
					ListUsuario(request, response);
				if (accion.equals("Guardar"))
					Guardar(request, response);
				
				if (accion.equals("guardarUser"))
					GuardarUsuario(request,response);
				
				if (accion.equals("Filtrar"))
					FiltrarUsuario(request,response);
				
				if (accion.equals("Modificar"))
					ModificarUsuario(request, response);
				
				if (accion.equals("login"))
					LoginUsuario(request,response);
			}
			if (Usr!="" && Usr!= null)
				//Y si la variable Usr no está vacía la acción se llama el método Buscar
				BuscarUsuario(request, response);
			
						
		} catch (SQLException e) {
			//Se obtiene cualquier excepción SQL que ocurra en el proceso
			e.getStackTrace();
		}
		
		
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void ListUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la página a la cual se despacha al usar este método
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ListUser.jsp");
		//Se crea una lista de roles, ya que al listar en la base de datos
		//se necesita una variable que almacene la lista que se desea imprimir en la vista
		List<Usuario> UsuarioTabla;
		try {		
			//Se llama el método ListROl, el cual ejecuta la consuta SQL para listar TODA la tabla
			UsuarioTabla =  Objeto_ModeloUser.ListUsuario();
			//Y la tabla que retorna se le lleva al atributo lista
			//el cual es la tabla que está declarada en la Vista
			request.setAttribute("lista", UsuarioTabla);
			//En caso de venir de haber guardado en la base de datos
			//el parámetro "guardado" existirá, el cual almacena el nombre
			// que se agregó a la base de datos.
			String nombre = request.getParameter("guardado");
			if (nombre!=null && nombre!="")
				//se muestra en la vista en el parámetro resultado, el cual está para este caso, de resto está vacío
				request.setAttribute("resultado", "Se ha guardado el usuario " + nombre + " exitosamente");
		}
		catch(Exception e){
			//caso de una excepción muestra en consola en que mètodo fue el error
			System.out.println("ERRROR al listar...");
		}
		//se despacha al cliente a la página en el dispatcher
		System.out.println("esto es req="+request);
			dispatcher.forward(request, response);
	}
	
	private void GuardarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la página a la cual se despacha al usar este método
		RequestDispatcher dispatcher;
		//Al guardar se le pide al usuario el nombre y la descripción, las cuales están como parámetro.
		int Identificacion = Integer.parseInt(request.getParameter("Identificacion")); 
		int Estado = 1;
		int Borrado= 0;
		int idCiudades= Integer.parseInt(request.getParameter("txtIdCiudad"));
		String Nombre = request.getParameter("txtNombre");
		String Primer_apellido = request.getParameter("txtPrimer_apellido");
		String Segundo_apellido= request.getParameter("txtSegundo_apellido");
		String Mail = request.getParameter("txtMail");
		String Telefono = request.getParameter("txtTelefono");
		String Usuario = request.getParameter("txtUsuario");
		String Contraseña = request.getParameter("txtContrasena");
		int Rol = Integer.parseInt(request.getParameter("Rol"));
		Usuario us = new Usuario(Identificacion, Estado, Borrado, idCiudades,Nombre, Primer_apellido, Segundo_apellido, 
									Mail, Telefono, Usuario, Contraseña,Rol);
		
		try {		
			//Se llama el mètodo guardar rol y se le lleva el objeto Rol que se va a a guardar.
			Objeto_ModeloUser.guardarUser(us);
		
			dispatcher = request.getRequestDispatcher("ControlUser?accion=Listar&guardado="+ Nombre);
		}
		catch(Exception e){
			
			dispatcher = request.getRequestDispatcher("View/AddUser.jsp");
			request.setAttribute("resultado", "Error al guardar el usario " + Nombre);
			System.out.println("ERRROR al guardar usuario...");
		}
		//se despacha al cliente a la página en el dispatcher
			dispatcher.forward(request, response);
	}
	
	private void FiltrarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la página a la cual se despacha al usar este método
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ListUser.jsp");
		//se crea una lista de roles ya que el filtrado podr
		List<Usuario> UsuarioTabla;
		
		int Identificacion = Integer.parseInt(request.getParameter("FilterIdentificacion")); 
		String Nombre = request.getParameter("FilterNombre");

		
		int Op =0;
		if (Identificacion!=0)
			//si el usuario llena sòlo el campo ID se filtrará solo por ID
			Op=1;
		if (Nombre!="")
			//Sí el usuario llena solo el campo nombre se filtrará solo por nombre
			Op=2;
		if (Identificacion!=0 && Nombre !="")
			//si el usuario llena los dos campos se filtrará por ambos campos
			Op=3;
		try {		
			//se llama el método FiltrarRol el cual tiene como parámetro
			//el Id a filtrar, nombre y la opción seleccionada (si solo se filtra id, nombre o ambos)
			UsuarioTabla =  Objeto_ModeloUser.FiltrarUser(Identificacion, Nombre, Op);
			//el resultado se lleva a la tabla en la lista
			request.setAttribute("lista", UsuarioTabla);
		}
		catch(Exception e){
			//caso de una excepción pone un error y se indica el método
			System.out.println("ERRROR al filtrar...");
		}
		//se despacha al cliente a la página en el dispatcher
			dispatcher.forward(request, response);
	}
	
	private void BuscarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{

		RequestDispatcher dispatcher = request.getRequestDispatcher("View/index.jsp");

		Boolean Verificacion;
		
		try {		
			//Se usa el Método Buscar y se le lleva el Usr a buscar en la base de datos.
			int id= Integer.parseInt(request.getParameter("id_user"));
			String nombre = request.getParameter("nombre");
			Verificacion =  Objeto_ModeloUser.BuscarId(id);
			Verificacion =  Objeto_ModeloUser.BuscarNombre(nombre);
			if(Verificacion)
				request.setAttribute("Respuesta", "Existe");
			else
				request.setAttribute("Respuesta", "No Existe");
		}
		catch(Exception e){
			
			System.out.println("ERRROR al buscar..."+e);
			
			System.out.println("ERRROR al buscar...");
		}
			dispatcher.forward(request, response);
	}
	
	private void ModificarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int Id = Integer.parseInt(request.getParameter("Identificacion")); 
		try {
		List <Usuario> UsuarioTabla =  Objeto_ModeloUser.FiltrarUser(Id, "", 1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ModifyUser.jsp");
		request.setAttribute("Identificacion", Id);
		request.setAttribute("Nombre", UsuarioTabla.get(0).getNombre());
		dispatcher.forward(request, response);
		}
		catch(Exception e) {
			
			System.out.println("ERRROR al buscar...");
		}
	}
	
	private void LoginUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String link ="";
		Boolean Verificacion;
		
		
		try {
			String us;
		
			String user = request.getParameter("user");
			String pwd = request.getParameter("pwd");
			System.out.println("user "+user+"user "+pwd);
			us  = Objeto_ModeloUser.Buscarlogin(user,pwd);
			
			if(us.equals("nada")) {
				link =  "Index.jsp";
				request.setAttribute("Respuesta", "Usuario o contraseña no valido");
				
			}else {
				link =  "View/UserAdmin.jsp";
				request.setAttribute("nombre", us);
			}
		}
		catch(Exception e){
			
			System.out.println("ERRROR al buscar..."+e);
			
			System.out.println("ERRROR al buscar...");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(link);; 
		
			dispatcher.forward(request, response);
	}
	private void Guardar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/AddUser.jsp");
		List<Rol> ListaRol;
		List<Ciudades> ListaCuidades;
		try {
			
		}
		catch(Exception e){
			
		}
		request.setAttribute("nombre", us);
	}
	
}

