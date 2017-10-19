package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
	
		ModeloDepartamentos Objeto_ModeloDpto;
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
			
			    response.setContentType("text/html;charset=UTF-8");
		        try (PrintWriter out = response.getWriter()) {
		        	
		        	String crearDpto = request.getParameter("btnGuardar");
		        	 if (crearDpto.equals("guardar")){
		                String nombreDpto = request.getParameter("txtNombre");
		         
		                
		                Departamentos p = new Departamentos();
		                p.setNombreDpto(nombreDpto);
//		                p.setEstadoDpto(true);
		                
		                String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		        		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		        		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");


		                ModeloDepartamentos dp = new ModeloDepartamentos (jdbcURL, jdbcUsername, jdbcPassword);
		                dp.crearDpto(p);
		                

		                request.getRequestDispatcher("View/Departamentos.jsp").include(request, response);
		             }
		        }
		}
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ControlDepartamentos() {
	        super();
	       
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String accion = request.getParameter("action");
			
			//processRequest(request, response);
	        

				if (accion !="" && accion!= null) {
					//SI la acci�n es listar se llama el m�todo ListRol
					switch(accion) {
						case "Listar":
							ListRol(request, response);
						//SI la acci�n es Guardar se llama el m�todo GuardarRol
							break;
						case "Guardar":
							GuardarRol(request,response);
							break;
						case "Filtrar":
							//SI la acci�n es filtrar se llama el m�todo FiltrarRol
							FiltrarRol(request,response);
							break;
						case "Modificar":
							//SI la acci�n es filtrar se llama el m�todo FiltrarRol
							ModificarRol(request,response);
							break;
						case "GuardarCambios":
							//SI la acci�n es filtrar se llama el m�todo FiltrarRol
							GuardarCambiosRol(request,response);
							break;
						default:
							ListRol(request, response);
							break;
					}
				}
	               
		}
		
		private void GuardarDepartamentos(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			String nombreDpto = request.getParameter("txtNombre");
	        Departamentos p = new Departamentos();
	        p.setNombreDpto(nombreDpto);
	       
	        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
			String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
			String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
	
	
	        ModeloDepartamentos dp = new ModeloDepartamentos(jdbcURL, jdbcUsername, jdbcPassword);
	        dp.crearDpto(p);
	        
	
	        request.getRequestDispatcher("View/Departamentos.jsp").include(request, response);
		}	
}
		

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		
