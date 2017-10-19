package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Departamentos;
import Model.ModeloDepartamentos;


@WebServlet("/ControlDepartamentos")
public class ControlDepartamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
		ModeloDepartamentos Objeto_ModeloDpto;
		
	    public ControlDepartamentos() {
	        super();
	       
	    }
		public void init() {
			//EN el evento init inicializan los constructores con los datos de la conexión sql que están alamacenados en el archivo web.xml, como variable 
			String jdbcURL = getServletContext().getInitParameter("jdbcURL");
			String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
			String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
			try {
				//Constructor de ModeloRol
				Objeto_ModeloDpto = new ModeloDepartamentos(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (Exception e) {
			
			}
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String accion = request.getParameter("action");
			
			//processRequest(request, response);
	        
			try {
				if (accion !="" && accion!= null) {
					//SI la acción es listar se llama el método ListRol
					switch(accion) {
						case "Listar":
							ListDepartamentos(request, response);
						//SI la acción es Guardar se llama el método GuardarRol
							break;
						case "Guardar":
							GuardarDepartamentos(request,response);
							break;
						case "Filtrar":
							//SI la acción es filtrar se llama el método FiltrarRol
							FiltrarDepartamentos(request,response);
							break;
						case "Modificar":
							//SI la acción es filtrar se llama el método FiltrarRol
							ModificarDepartamentos(request,response);
							break;
						case "GuardarCambios":
							//SI la acción es filtrar se llama el método FiltrarRol
							GuardarCambiosDepartamentos(request,response);
							break;
						default:
							ListDepartamentos(request, response);
							break;
					}
				}
				else
					ListDepartamentos(request, response);
	                
				String nombre = request.getParameter("guardado");
				if (nombre!=null && nombre!="")
					request.setAttribute("resultado", "Se ha guardado el departamento " + nombre + " exitosamente");
			} catch (SQLException e) {
				//Se obtiene cualquier excepción SQL que ocurra en el proceso
				e.getStackTrace();
			}

		}

		
		private void GuardarDepartamentos(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			String nombreDpto = request.getParameter("txtNombre");
	        Departamentos NuevoDpto = new Departamentos();
	        NuevoDpto.setNombreDpto(nombreDpto);
	        Objeto_ModeloDpto.crearDpto(NuevoDpto);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ControlDepartamentos?action=Listar&guardado="+nombreDpto);
	        dispatcher.forward(request, response);
		}	
		
		private void ListDepartamentos(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("View/ListDepartamentos.jsp");
			
			List<Departamentos> DptoTabla;
			try {		
			
				DptoTabla =  Objeto_ModeloDpto.listarDpto();
				
				request.setAttribute("lista", DptoTabla);
				
				String nombre = request.getParameter("guardado");
				if (nombre!=null && nombre!="")
					
					request.setAttribute("resultado", "Se ha guardado el rol " + nombre + " exitosamente");
			}
			catch(Exception e){
				
				System.out.println("ERRROR al listar...");
			}
			
				dispatcher.forward(request, response);
		}
		
		
		private void FiltrarDepartamentos(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			
		}
		private void ModificarDepartamentos(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			
		}
		
		private void GuardarCambiosDepartamentos(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			
		}
		
		
}
		


		
