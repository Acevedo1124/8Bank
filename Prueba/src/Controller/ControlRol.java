package Controller;


import java.io.IOException;
import java.sql.SQLException;
import Model.Rol;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import java.util.List;


import Model.ModeloRol;
 

@WebServlet("/ControlRol")
public class ControlRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModeloRol Objeto_ModeloRol;
	String Usr;
	public void init() {
		//EN el evento init inicializan los constructores con los datos de la conexi�n sql que est�n alamacenados en el archivo web.xml, como variable 
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
		//M�todo que se ejecuta al cargar el controlador
		
		//Par�metro Usr el cual sirve para verificar si un nombre existe en la base de datos
		Usr = request.getParameter("Usr");
		//Par�metro acci�n, que sirve para identificar la acci�n que se desea realizar
		//Puede ser Listrar, Guardar, Filtrar
		String accion = request.getParameter("action");
		System.out.println(Usr);
		try {
			//Si la variable no est� vacia, se verifica su contenido,
			
			if (accion !="" && accion!= null) {
				//SI la acci�n es listar se llama el m�todo ListRol
				if (accion.equals("Listar"))
					ListRol(request, response);
				//SI la acci�n es Guardar se llama el m�todo GuardarRol
				if (accion.equals("Guardar"))
					GuardarRol(request,response);
				if (accion.equals("Filtrar"))
					//SI la acci�n es filtrar se llama el m�todo FiltrarRol
					FiltrarRol(request,response);
			}
			if (Usr!="" && Usr!= null)
				//Y si la variable Usr no est� vac�a la acci�n se llama el m�todo Buscar
				Buscar(request, response);
			
			//Nota: bajo navegaci�n normal no es posible que Usr y accion tengan valores al mismo tiempo, pero de ser el caso se cargan primero las acciones.
			
			
		} catch (SQLException e) {
			//Se obtiene cualquier excepci�n SQL que ocurra en el proceso
			e.getStackTrace();
		}
		
		
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Al recibir un post llama la funci�n doGet, la cual carga todo los eventos en la p�gina
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void ListRol(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la p�gina a la cual se despacha al usar este m�todo
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListRol.jsp");
		//Se crea una lista de roles, ya que al listar en la base de datos
		//se necesita una variable que almacene la lista que se desea imprimir en la vista
		List<Rol> RolesTabla;
		try {		
			//Se llama el m�todo ListROl, el cual ejecuta la consuta SQL para listar TODA la tabla
			RolesTabla =  Objeto_ModeloRol.ListRol();
			//Y la tabla que retorna se le lleva al atributo lista
			//el cual es la tabla que est� declarada en la Vista
			request.setAttribute("lista", RolesTabla);
			//En caso de venir de haber guardado en la base de datos
			//el par�metro "guardado" existir�, el cual almacena el nombre
			// que se agreg� a la base de datos.
			String nombre = request.getParameter("guardado");
			if (nombre!=null && nombre!="")
				//se muestra en la vista en el par�metro resultado, el cual est� para este caso, de resto est� vac�o
				request.setAttribute("resultado", "Se ha guardado el rol " + nombre + " exitosamente");
		}
		catch(Exception e){
			//caso de una excepci�n muestra en consola en que m�todo fue el error
			System.out.println("ERRROR al listar...");
		}
		//se despacha al cliente a la p�gina en el dispatcher
			dispatcher.forward(request, response);
	}
	
	private void GuardarRol(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la p�gina a la cual se despacha al usar este m�todo
		RequestDispatcher dispatcher;
		//Al guardar se le pide al usuario el nombre y la descripci�n, las cuales est�n como par�metro.
		String nombre = request.getParameter("txtNombre");
		String descripcion = request.getParameter("txtDescripcion");
		//se crea un objeto rol con el nombre y la descripci�n,
		//se pone 0 en el ID porque el valor del ID no importa ya que 
		//al llamar el procedimiento de guardado este no tiene en cuenta el ID del objeto Rol
		//este solo almacena el nombre y la descripci�n, el ID es auto-incremento
		Rol RolNuevo = new Rol(0,nombre,descripcion);
		try {		
			//Se llama el m�todo guardar rol y se le lleva el objeto Rol que se va a a guardar.
			Objeto_ModeloRol.guardarRol(RolNuevo);
			//en caso de ser exitoso el guardado se despacha a de nuevo a la lista indicando que se guardo el rol, llevando el par�metro "guardado"
			dispatcher = request.getRequestDispatcher("ControlRol?action=Listar&guardado="+nombre);
		}
		catch(Exception e){
			//caso de una excepci�n se queda en la misma p�gina, 
			//y se indica que hubo un error al guardar
			
			dispatcher = request.getRequestDispatcher("AddRol.jsp");
			request.setAttribute("resultado", "Error al guardar el rol " + nombre);
			System.out.println("ERRROR al guardar...");
		}
		//se despacha al cliente a la p�gina en el dispatcher
			dispatcher.forward(request, response);
	}
	
	private void FiltrarRol(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la p�gina a la cual se despacha al usar este m�todo
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListRol.jsp");
		//se crea una lista de roles ya que el filtrado podr
		List<Rol> RolesTabla;
		//Los par�metros a recibir en esta ocaci�n es el ID y el Nombre que el usuario ingres�.
		String Id = request.getParameter("FilterID");
		String Nombre = request.getParameter("FilterNombre");
		//Aqu� hay varias opciones,
		
		//si el usuario no ingresa nada en los filtros mostrar� toda la tabla 
		int Op =0;
		if (Id!="")
			//si el usuario llena s�lo el campo ID se filtrar� solo por ID
			Op=1;
		if (Nombre!="")
			//S� el usuario llena solo el campo nombre se filtrar� solo por nombre
			Op=2;
		if (Id!="" && Nombre !="")
			//si el usuario llena los dos campos se filtrar� por ambos campos
			Op=3;
		try {		
			//se llama el m�todo FiltrarRol el cual tiene como par�metro
			//el Id a filtrar, nombre y la opci�n seleccionada (si solo se filtra id, nombre o ambos)
			RolesTabla =  Objeto_ModeloRol.FiltrarRol(Id,Nombre,Op);
			//el resultado se lleva a la tabla en la lista
			request.setAttribute("lista", RolesTabla);
		}
		catch(Exception e){
			//caso de una excepci�n pone un error y se indica el m�todo
			System.out.println("ERRROR al filtrar...");
		}
		//se despacha al cliente a la p�gina en el dispatcher
			dispatcher.forward(request, response);
	}
	
	
	private void Buscar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la p�gina a la cual se despacha al usar este m�todo
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		//se crea un booleano de verificaci�n, el cual recibir� el resultado de que exista o no el nombre a buscar en la base de datos.
		Boolean Verificacion;
		try {		
			//Se usa el M�todo Buscar y se le lleva el Usr a buscar en la base de datos.
			Verificacion =  Objeto_ModeloRol.Buscar(Usr);
			if(Verificacion)
				//si es positivo el resultado de la busqueda significa que existe, caso contrario no existe
				request.setAttribute("Respuesta", "Existe");
			else
				request.setAttribute("Respuesta", "No Existe");
		}
		catch(Exception e){
			//caso de una excepci�n pone el nombre del m�todo
			System.out.println("ERRROR al buscar...");
		}
		//se despacha al cliente a la p�gina en el dispatcher
			dispatcher.forward(request, response);
	}
}
