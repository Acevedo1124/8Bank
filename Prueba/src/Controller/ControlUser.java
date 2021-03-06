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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//M�todo que se ejecuta al cargar el controlador
		
		
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
				if (accion.equals("guardarCambiosUser"))
					GuardarCambiosUsuario(request, response);
				if (accion.equals("Eliminar"))
					EliminarUser(request, response);
				
				if (accion.equals("login"))
					LoginUsuario(request,response);
			}
			if (Usr!="" && Usr!= null)
				//Y si la variable Usr no est� vac�a la acci�n se llama el m�todo Buscar
				BuscarUsuario(request, response);
			
						
		} catch (SQLException e) {
			//Se obtiene cualquier excepci�n SQL que ocurra en el proceso
			e.getStackTrace();
		}
		
		
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void ListUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la p�gina a la cual se despacha al usar este m�todo
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ListUser.jsp");
		//Se crea una lista de roles, ya que al listar en la base de datos
		//se necesita una variable que almacene la lista que se desea imprimir en la vista
		List<Usuario> UsuarioTabla;
		try {		
			//Se llama el m�todo ListROl, el cual ejecuta la consuta SQL para listar TODA la tabla
			UsuarioTabla =  Objeto_ModeloUser.ListUsuario();
			//Y la tabla que retorna se le lleva al atributo lista
			//el cual es la tabla que est� declarada en la Vista
			request.setAttribute("lista", UsuarioTabla);
			//En caso de venir de haber guardado en la base de datos
			//el par�metro "guardado" existir�, el cual almacena el nombre
			// que se agreg� a la base de datos.
			String nombre = request.getParameter("guardado");
			if (nombre!=null && nombre!="")
				//se muestra en la vista en el par�metro resultado, el cual est� para este caso, de resto est� vac�o
				request.setAttribute("resultado", "Se ha guardado el usuario " + nombre + " exitosamente");
		}
		catch(Exception e){
			//caso de una excepci�n muestra en consola en que m�todo fue el error
			System.out.println("ERRROR al listar...");
		}
		//se despacha al cliente a la p�gina en el dispatcher
		System.out.println("esto es req="+request);
			dispatcher.forward(request, response);
	}
	
	private void GuardarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la p�gina a la cual se despacha al usar este m�todo
		RequestDispatcher dispatcher;
		//Al guardar se le pide al usuario el nombre y la descripci�n, las cuales est�n como par�metro.
		int Identificacion = Integer.parseInt(request.getParameter("Identificacion")); 
		int Estado = 1;
		int Borrado= 0;
		String idCiudades= (request.getParameter("txtIdCiudad"));
		String Nombre = request.getParameter("txtNombre");
		String Primer_apellido = request.getParameter("txtPrimer_apellido");
		String Segundo_apellido= request.getParameter("txtSegundo_apellido");
		String Mail = request.getParameter("txtMail");
		String Telefono = request.getParameter("txtTelefono");
		String Usuario = request.getParameter("txtUsuario");
		String Contrase�a = request.getParameter("txtContrasena");
		String Rol = (request.getParameter("Rol"));
		Usuario us = new Usuario(Identificacion, Estado, Borrado, idCiudades,Nombre, Primer_apellido, Segundo_apellido, 
									Mail, Telefono, Usuario, Contrase�a,Rol);
		
		try {		
			//Se llama el m�todo guardar rol y se le lleva el objeto Rol que se va a a guardar.
			Objeto_ModeloUser.guardarUser(us);
		
			dispatcher = request.getRequestDispatcher("ControlUser?accion=Listar&guardado="+ Nombre);
		}
		catch(Exception e){
			
			dispatcher = request.getRequestDispatcher("View/AddUser.jsp");
			request.setAttribute("resultado", "Error al guardar el usario " + Nombre);
			System.out.println("ERRROR al guardar usuario...");
		}
		//se despacha al cliente a la p�gina en el dispatcher
			dispatcher.forward(request, response);
	}
	
	private void FiltrarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la p�gina a la cual se despacha al usar este m�todo
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ListUser.jsp");
		//se crea una lista de roles ya que el filtrado podr
		List<Usuario> UsuarioTabla;
		int Identificacion =0;
		if (request.getParameter("FilterIdentificacion")!="")
			 Identificacion = Integer.parseInt(request.getParameter("FilterIdentificacion"));
		String Nombre = request.getParameter("FilterNombre");
		System.out.println(Nombre);
		
		int Op =0;
		if (Identificacion!=0)
			//si el usuario llena s�lo el campo ID se filtrar� solo por ID
			Op=1;
		if (Nombre!="")
			//S� el usuario llena solo el campo nombre se filtrar� solo por nombre
			Op=2;
		if (Identificacion!=0 && Nombre !="")
			//si el usuario llena los dos campos se filtrar� por ambos campos
			Op=3;
		try {		
			//se llama el m�todo FiltrarRol el cual tiene como par�metro
			//el Id a filtrar, nombre y la opci�n seleccionada (si solo se filtra id, nombre o ambos)
			UsuarioTabla =  Objeto_ModeloUser.FiltrarUser(Identificacion, Nombre, Op);
			//el resultado se lleva a la tabla en la lista
			request.setAttribute("lista", UsuarioTabla);
		}
		catch(Exception e){
			//caso de una excepci�n pone un error y se indica el m�todo
			System.out.println("ERRROR al filtrar...");
		}
		//se despacha al cliente a la p�gina en el dispatcher
			dispatcher.forward(request, response);
	}
	
	
	
	private void BuscarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{

		RequestDispatcher dispatcher = request.getRequestDispatcher("View/index.jsp");

		Boolean Verificacion;
		
		try {		
			//Se usa el M�todo Buscar y se le lleva el Usr a buscar en la base de datos.
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ModifyUser.jsp");
		List<Rol> ListaRol;
		List<Ciudades> ListaCuidades;
		List<Usuario> ListaUsurios;
		try {
			ListaRol=Objeto_ModeloRol.ListRol();
			ListaCuidades=Objeto_ModeloCiudades.listar_ciudades();
			ListaUsurios=Objeto_ModeloUser.ListUsuario();
			
			request.setAttribute("Roles", ListaRol);	
			request.setAttribute("Ciudades", ListaCuidades);
			request.setAttribute("Identif", ListaUsurios);
			request.setAttribute("Usua", ListaUsurios);
			

		}
		catch(Exception e){
			System.out.println("ERRROR al buscar...");
		}
		
		
		int Id = Integer.parseInt(request.getParameter("id")); 
		try {
			List <Usuario> UsuarioTabla =  Objeto_ModeloUser.FiltrarUser(Id, "", 1);
			request.setAttribute("Ident", Id);
			request.setAttribute("Nombr", UsuarioTabla.get(0).getNombre());
			request.setAttribute("PApell", UsuarioTabla.get(0).getPrimer_apellido());
			request.setAttribute("SApell", UsuarioTabla.get(0).getSegundo_apellido());
			request.setAttribute("EMail", UsuarioTabla.get(0).getMail());
			request.setAttribute("Tel", UsuarioTabla.get(0).getTelefono());
			request.setAttribute("UsuarioDB", UsuarioTabla.get(0).getUsuario());
			System.out.println(UsuarioTabla.get(0).getUsuario());

			
			dispatcher.forward(request, response);
		}
		catch(Exception e) {
			
			System.out.println("ERRROR al buscar...");
		}
	}
	
	

	private void GuardarCambiosUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la p�gina a la cual se despacha al usar este m�todo
		RequestDispatcher dispatcher;
		//Al guardar se le pide al usuario el nombre y la descripci�n, las cuales est�n como par�metro.
		int Identificacion = Integer.parseInt(request.getParameter("Identificacion")); 
		int IdOld = Integer.parseInt(request.getParameter("IdOld")); 

		int Estado = 1;
		int Borrado= 0;
		String idCiudades= (request.getParameter("txtIdCiudad"));
		String Nombre = request.getParameter("txtNombre");
		String Primer_apellido = request.getParameter("txtPrimer_apellido");
		String Segundo_apellido= request.getParameter("txtSegundo_apellido");
		String Mail = request.getParameter("txtMail");
		String Telefono = request.getParameter("txtTelefono");
		String Usuario = request.getParameter("txtUsuario");
		String Contrase�a = request.getParameter("txtContrasena");
		String Rol = (request.getParameter("Rol"));
		Usuario us = new Usuario(Identificacion, Estado, Borrado, idCiudades,Nombre, Primer_apellido, Segundo_apellido, 
									Mail, Telefono, Usuario, Contrase�a,Rol);
		
		try {		
			//Se llama el m�todo guardar rol y se le lleva el objeto Rol que se va a a guardar.
			Objeto_ModeloUser.ModUser(us,IdOld);
		
			dispatcher = request.getRequestDispatcher("ControlUser?accion=Listar&guardado="+ Nombre);
		}
		catch(Exception e){
			
			dispatcher = request.getRequestDispatcher("View/AddUser.jsp");
			request.setAttribute("resultado", "Error al guardar el usario " + Nombre);
			System.out.println("ERRROR al guardar usuario...");
		}
		//se despacha al cliente a la p�gina en el dispatcher
			dispatcher.forward(request, response);
	}
	
	
	private void EliminarUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la p�gina a la cual se despacha al usar este m�todo
		RequestDispatcher dispatcher;
		//Al guardar se le pide al usuario el nombre y la descripci�n, las cuales est�n como par�metro.
		int Identificacion = Integer.parseInt(request.getParameter("Id")); 
		int Borrado= 1;
		
		try {		
			//Se llama el m�todo guardar rol y se le lleva el objeto Rol que se va a a guardar.
			Objeto_ModeloUser.BorrarUser(Identificacion,Borrado);
		
			dispatcher = request.getRequestDispatcher("ControlUser?accion=Listar");
		}
		catch(Exception e){
			
			dispatcher = request.getRequestDispatcher("View/AddUser.jsp");
			
			System.out.println("ERRROR al guardar usuario...");
		}
		//se despacha al cliente a la p�gina en el dispatcher
			dispatcher.forward(request, response);
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
				request.setAttribute("Respuesta", "Usuario o contrase�a no valido");
				
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
		List<Usuario> ListaUsurios;
		try {
			ListaRol=Objeto_ModeloRol.ListRol();
			ListaCuidades=Objeto_ModeloCiudades.listar_ciudades();
			ListaUsurios=Objeto_ModeloUser.ListUsuario();
			
			request.setAttribute("Roles", ListaRol);	
			request.setAttribute("Ciudades", ListaCuidades);
			request.setAttribute("Ident", ListaUsurios);
			request.setAttribute("Usua", ListaUsurios);
			
			dispatcher.forward(request, response);
		}
		catch(Exception e){
			System.out.println("ERRROR al buscar...");
		}
		
	}
	
}

