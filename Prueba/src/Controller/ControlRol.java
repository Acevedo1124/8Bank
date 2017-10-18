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


import Model.Metodos;
 
/**
 * Servlet implementation class AdminArticulo
 */
@WebServlet("/ControlRol")
public class ControlRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Metodos ObjetoPrueba;
	String Usr;
	public void init() {
		//EN el evento init inicializan los constructores con los datos de la conexión sql que están alamacenados en el archivo web.xml, como variable 
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			//Constructor de objeto prueba :)
			ObjetoPrueba = new Metodos(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
 

	public ControlRol() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Método que se ejecuta al cargar el controlador
		
		Usr = request.getParameter("Usr");
		System.out.println(Usr);
		try {
			if (Usr!="")
				Buscar(request, response);
			else
				//Llamado a la función index
				ListRol(request, response);
				
			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
		
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Al recibir una petición llama la función doGet
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void ListRol(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la página a la cual se despacha al usar este método
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListRol.jsp");
		List<Rol> RolesTabla;
		try {		
			//se intenta el método Test, de no saltar una excepción significa que la conexión a la base de datos es exitosa
			// y se pone en el campo intento dentro de la vista
			RolesTabla =  ObjetoPrueba.ListRol();
			request.setAttribute("lista", RolesTabla);
		}
		catch(Exception e){
			//caso de una excepción pone un NO
			System.out.println("ERRROR al listar...");
		}
		//se despacha al cliente a la página en el dispatcher
			dispatcher.forward(request, response);
	}
	
	private void Buscar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la página a la cual se despacha al usar este método
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		Boolean Verificacion;
		try {		
			//se intenta el método Test, de no saltar una excepción significa que la conexión a la base de datos es exitosa
			// y se pone en el campo intento dentro de la vista
			Verificacion =  ObjetoPrueba.Buscar(Usr);
			if(Verificacion)
				request.setAttribute("Respuesta", "Existe");
			else
				request.setAttribute("Respuesta", "No Existe");
		}
		catch(Exception e){
			//caso de una excepción pone un NO
			System.out.println("ERRROR al buscar..."+e);
		}
		//se despacha al cliente a la página en el dispatcher
			dispatcher.forward(request, response);
	}
}
