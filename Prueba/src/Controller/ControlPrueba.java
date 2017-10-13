package Controller;

import java.io.IOException;
import java.sql.SQLException;

 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 



import Controller.ControlPrueba;
import Model.Prueba;
 
/**
 * Servlet implementation class AdminArticulo
 */
@WebServlet("/ControlPrueba")
public class ControlPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Prueba ObjetoPrueba;
	public void init() {
		//EN el evento init inicializan los constructores con los datos de la conexión sql que están alamacenados en el archivo web.xml, como variable 
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			//Constructor de objeto prueba :)
			ObjetoPrueba = new Prueba(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlPrueba() {
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
		System.out.println("Hola Servlet..");
		
		
		try {
				//Llamado a la función index
				index(request, response);

			
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
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//se pide la página a la cual se despacha al usar este método
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		try {		
			//se intenta el método Test, de no saltar una excepción significa que la conexión a la base de datos es exitosa
			// y se pone en el campo intento dentro de la vista
			ObjetoPrueba.Test();
			request.setAttribute("intento", "SI");
		}
		catch(SQLException e){
			//caso de una excepción pone un NO
			request.setAttribute("intento", "NO");
		}
		//se despacha al cliente a la página en el dispatcher
			dispatcher.forward(request, response);
	}
}	