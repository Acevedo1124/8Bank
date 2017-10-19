package Controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Rol;

import java.util.List;


import Model.ModeloRol;
 

@WebServlet("/ControlRol")
public class ControlRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModeloRol Objeto_ModeloRol;
	String Usr;
	public void init() {
		//EN el evento init inicializan los constructores con los datos de la conexión sql que están alamacenados en el archivo web.xml, como variable 
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			//Constructor de ModeloRol
			Objeto_ModeloRol = new ModeloRol(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
		
		}
	}
	public ControlRol() {
		super();
		//Constructor por defecto
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Método que se ejecuta al cargar el controlador
		
		//Parámetro Usr el cual sirve para verificar si un nombre existe en la base de datos
		
		//Parámetro acción, que sirve para identificar la acción que se desea realizar
		//Puede ser Listrar, Guardar, Filtrar
		String accion = request.getParameter("action");
		System.out.println(Usr);
		try {
			//Si la variable no está vacia, se verifica su contenido,
			if (accion !="" && accion!= null) {
				//SI la acción es listar se llama el método ListRol
				switch(accion) {
					case "Listar":
						ListRol(request, response);
					//SI la acción es Guardar se llama el método GuardarRol
						break;
					case "Guardar":
						GuardarRol(request,response);
						break;
					case "Filtrar":
						//SI la acción es filtrar se llama el método FiltrarRol
						FiltrarRol(request,response);
						break;
					case "Modificar":
						//SI la acción es filtrar se llama el método FiltrarRol
						ModificarRol(request,response);
						break;
					case "GuardarCambios":
						//SI la acción es filtrar se llama el método FiltrarRol
						GuardarCambiosRol(request,response);
						break;
					default:
						ListRol(request, response);
						break;
				}
			}
			else
				ListRol(request, response);
			if (Usr!="" && Usr!= null)
				//Y si la variable Usr no está vacía la acción se llama el método Buscar
				Buscar(request, response);
			
			//Nota: bajo navegación normal no es posible que Usr y accion tengan valores al mismo tiempo, pero de ser el caso se cargan primero las acciones.
			
			
		} catch (SQLException e) {
			//Se obtiene cualquier excepción SQL que ocurra en el proceso
			e.getStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Al recibir un post llama la función doGet, la cual carga todo los eventos en la página
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void ListRol(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la página a la cual se despacha al usar este método
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ListRol.jsp");
		//Se crea una lista de roles, ya que al listar en la base de datos
		//se necesita una variable que almacene la lista que se desea imprimir en la vista
		List<Rol> RolesTabla;
		try {		
			//Se llama el método ListROl, el cual ejecuta la consuta SQL para listar TODA la tabla
			RolesTabla =  Objeto_ModeloRol.ListRol();
			//Y la tabla que retorna se le lleva al atributo lista
			//el cual es la tabla que está declarada en la Vista
			request.setAttribute("lista", RolesTabla);
			//En caso de venir de haber guardado en la base de datos
			//el parámetro "guardado" existirá, el cual almacena el nombre
			// que se agregó a la base de datos.
			String nombre = request.getParameter("guardado");
			if (nombre!=null && nombre!="")
				//se muestra en la vista en el parámetro resultado, el cual está para este caso, de resto está vacío
				request.setAttribute("resultado", "Se ha guardado el rol " + nombre + " exitosamente");
		}
		catch(Exception e){
			//caso de una excepción muestra en consola en que mètodo fue el error
			System.out.println("ERRROR al listar...");
		}
		//se despacha al cliente a la página en el dispatcher
		System.out.println("esto es reqrol="+request);
			dispatcher.forward(request, response);
	}
	
	private void GuardarRol(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la página a la cual se despacha al usar este método
		RequestDispatcher dispatcher;
		//Al guardar se le pide al usuario el nombre y la descripción, las cuales están como parámetro.
		String nombre = java.net.URLDecoder.decode(request.getParameter("txtNombre"), "UTF-8");
		String descripcion = java.net.URLDecoder.decode(request.getParameter("txtDescripcion"), "UTF-8");
		//se crea un objeto rol con el nombre y la descripción,
		//se pone 0 en el ID porque el valor del ID no importa ya que 
		//al llamar el procedimiento de guardado este no tiene en cuenta el ID del objeto Rol
		//este solo almacena el nombre y la descripción, el ID es auto-incremento
		Rol RolNuevo = new Rol(0,nombre,descripcion);
		try {		
			//Se llama el mètodo guardar rol y se le lleva el objeto Rol que se va a a guardar.
			Objeto_ModeloRol.guardarRol(RolNuevo);
			//en caso de ser exitoso el guardado se despacha a de nuevo a la lista indicando que se guardo el rol, llevando el parámetro "guardado"
			dispatcher = request.getRequestDispatcher("ControlRol?action=Listar&guardado="+nombre);
		}
		catch(Exception e){
			//caso de una excepción se queda en la misma página, 
			//y se indica que hubo un error al guardar
			
			dispatcher = request.getRequestDispatcher("View/AddRol.jsp");
			request.setAttribute("resultado", "Error al guardar el rol " + nombre);
			System.out.println("ERRROR al guardar...");
		}
		//se despacha al cliente a la página en el dispatcher
			dispatcher.forward(request, response);
	}
	
	private void FiltrarRol(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la página a la cual se despacha al usar este método
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ListRol.jsp");
		//se crea una lista de roles ya que el filtrado podr
		List<Rol> RolesTabla;
		//Los paràmetros a recibir en esta ocación es el ID y el Nombre que el usuario ingresó.
		String Id = request.getParameter("FilterID");
		String Nombre = request.getParameter("FilterNombre");
		//Aquí hay varias opciones,
		
		//si el usuario no ingresa nada en los filtros mostrará toda la tabla 
		int Op =0;
		if (Id!="")
			//si el usuario llena sòlo el campo ID se filtrará solo por ID
			Op=1;
		if (Nombre!="")
			//Sí el usuario llena solo el campo nombre se filtrará solo por nombre
			Op=2;
		if (Id!="" && Nombre !="")
			//si el usuario llena los dos campos se filtrará por ambos campos
			Op=3;
		try {		
			//se llama el método FiltrarRol el cual tiene como parámetro
			//el Id a filtrar, nombre y la opción seleccionada (si solo se filtra id, nombre o ambos)
			RolesTabla =  Objeto_ModeloRol.FiltrarRol(Id,Nombre,Op);
			//el resultado se lleva a la tabla en la lista
			request.setAttribute("lista", RolesTabla);
		}
		catch(Exception e){
			//caso de una excepción pone un error y se indica el método
			System.out.println("ERRROR al filtrar...");
		}
		//se despacha al cliente a la página en el dispatcher
			dispatcher.forward(request, response);
	}
	
	private void Buscar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la página a la cual se despacha al usar este método
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/index.jsp");
		
		//se crea un booleano de verificación, el cual recibirá el resultado de que exista o no el nombre a buscar en la base de datos.
		Boolean Verificacion;
		try {		
			//Se usa el Método Buscar y se le lleva el Usr a buscar en la base de datos.
			Verificacion =  Objeto_ModeloRol.Buscar(Usr);
			if(Verificacion)
				//si es positivo el resultado de la busqueda significa que existe, caso contrario no existe
				request.setAttribute("Respuesta", "Existe");
			else
				request.setAttribute("Respuesta", "No Existe");
		}
		catch(Exception e){
			//caso de una excepción pone un NO
			System.out.println("ERRROR al buscar..."+e);
			//caso de una excepción pone el nombre del método
			System.out.println("ERRROR al buscar...");
		}
		//se despacha al cliente a la página en el dispatcher
			dispatcher.forward(request, response);
	}


	private void ModificarRol(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String Id = request.getParameter("id");
		try {
		List <Rol> RolesTabla =  Objeto_ModeloRol.FiltrarRol(Id,"",1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ModifyRol.jsp");
		request.setAttribute("Id", Id);
		request.setAttribute("Nombre", RolesTabla.get(0).getNombre());
		request.setAttribute("Descripcion", RolesTabla.get(0).getDescripcion());
		dispatcher.forward(request, response);
		}
		catch(Exception e) {
			
			System.out.println("ERRROR al buscar...");
		}
	}
	private void GuardarCambiosRol(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		try {
			int id = Integer.parseInt(java.net.URLDecoder.decode(request.getParameter("id"), "UTF-8"));
			String nombre = java.net.URLDecoder.decode(request.getParameter("txtNombre"), "UTF-8");
			String descripcion = java.net.URLDecoder.decode(request.getParameter("txtDescripcion"), "UTF-8");
			Rol r = new Rol(id,nombre,descripcion);
			Objeto_ModeloRol.modificarRol(r);
			 // asignamos en el objeto el metodo modificarRol
		} 
		catch (Exception e) {
			System.out.println("ERRROR al modificar...");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("ControlRol?action=Listar");
		dispatcher.forward(request, response);
		}
	
}
