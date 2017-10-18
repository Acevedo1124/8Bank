package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModeloUser;;


public class ControlUser {
	private static final long serialVersionUID = 1L;
	ModeloUser Objeto_ModeloUser;
	
	public void init() {
		//EN el evento init inicializan los constructores con los datos de la conexión sql que están alamacenados en el archivo web.xml, como variable 
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			//Constructor de ModeloRol
			Objeto_ModeloUser = new ModeloUser(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
		
		}
	}
}
