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


@WebServlet("/ControlRol")
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
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
			//processRequest(request, response);
			response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	        	System.out.println("1");
	        	String crearDpto = request.getParameter("btnGuardar");
	        	System.out.println(crearDpto);
	        	 if (crearDpto.equals("guardar")){
	                String nombreDpto = request.getParameter("txtNombre");
//	                String estadoDpto = request.getParameter("txtEstado");
	                System.out.println("2");
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
			catch (Exception e) {
				
				 System.out.println("2");
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			//processRequest(request, response);
			response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	        	
	        	String crearDpto = request.getParameter("btnGuardar");
	        	 if (crearDpto.equals("guardar")){
	                String nombreDpto= request.getParameter("txtNombre");
//	                Boolean estadoDpto = request.getParameter("txtEstado");
	                
	                Departamentos p = new Departamentos();
	                p.setNombreDpto(nombreDpto);
	                p.setEstadoDpto(true);
	                
	                String jdbcURL = getServletContext().getInitParameter("jdbcURL");
	        		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
	        		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");


	                ModeloDepartamentos dp = new ModeloDepartamentos(jdbcURL, jdbcUsername, jdbcPassword);
	                dp.crearDpto(p);
	                

	                request.getRequestDispatcher("FormularioPerfil.jsp").include(request, response);
	               
	             }
	        }
		}
		
//		private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//			//se despacha al cliente a la página en el dispatcher
//				dispatcher.forward(request, response);
//		}

	}

