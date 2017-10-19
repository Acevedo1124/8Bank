package Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Departamentos;
import util.Conexion;


public class ModeloDepartamentos extends Conexion{
	
		 private String jdbcURL;
		 private String jdbcUsername;
		 private String jdbcPassword;
		 private Connection jdbcConnection; 
		 Conexion con;
		 
		 
		public ModeloDepartamentos(String jdbcURL, String jdbcUsername, String jdbcPassword) {
			super(jdbcURL, jdbcUsername, jdbcPassword);
			this.jdbcURL = jdbcURL;
			this.jdbcUsername = jdbcUsername;
			this.jdbcPassword = jdbcPassword;
			con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
			// TODO Auto-generated constructor stub
		}

		public Departamentos FiltrarDpto(int idDpto, String nombre, Boolean estado) {
			 

			String sql = "SELECT * FROM tb_departamentos WHERE "
		            +"idtb_departamentos = '"+idDpto+"' OR nombre = '"+nombre+"'";
		Statement st ;
		try {
			con.conectar();
			jdbcConnection = con.getJdbcConnection();
			 st = jdbcConnection.createStatement();
		     ResultSet result = st.executeQuery(sql);
		     System.out.println(sql);
		     Departamentos p = new Departamentos();
		     while(result.next()){
		         int id = result.getInt("idtb_departamentos");
		         String nombreDpto = result.getString("nombre");
		         Boolean estadoDpto = result.getBoolean("estado");
		         p.setIdDpto(id);
		         p.setNombreDpto(nombreDpto);
		         p.setEstadoDpto(true);
		         st.close();
	             con.desconectar();
		         return p;
		     }
		} catch (SQLException ex) {
		    Logger.getLogger(ModeloDepartamentos.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
		}
		
		
		public  List<Departamentos> listarDpto(){
			
			
	        String sql = " SELECT * FROM tb_departamentos";
	        List<Departamentos> list = new ArrayList<Departamentos>();
	        Statement st;
	        try {
	        	con.conectar();
				jdbcConnection = con.getJdbcConnection();
	        	st = jdbcConnection.createStatement();
	            ResultSet result = st.executeQuery(sql);
	            while(result.next()){
		            Departamentos p = new Departamentos();
		           int idDpto = result.getInt("idtb_Departamentos");
		           String nombreDpto = result.getString("nombre");
		           Boolean estadoDpto = result.getBoolean("estado");
		           p.setIdDpto(idDpto);
		           p.setNombreDpto(nombreDpto);
		           p.setEstadoDpto(estadoDpto);
		           list.add(p);
		           
		           
	            }
	            st.close();
	            con.desconectar();
	            return list;
	        } catch (SQLException ex) {
	       Logger.getLogger(ModeloDepartamentos.class.getName()).log(Level.SEVERE, null, ex);
	   }
	   return null;
	}
		
		
		public void crearDpto(Departamentos pf){

	        String nombre = pf.getNombreDpto();
			Boolean estado = pf.getEstadoDpto();
			 Statement st;
		    try {
		    	con.conectar();
				jdbcConnection = con.getJdbcConnection();
		    	st = jdbcConnection.createStatement();
		    st.execute("INSERT INTO tb_departamentos ( nombre, estado) VALUES ('"+ nombre +"',1);");
		    System.out.println("INSERT INTO tb_Departamentos ( nombre, estado) VALUES ('\"+ nombre +\"','1');");
		    st.close();
	        con.desconectar();
		    } catch (SQLException ex) {
		        Logger.getLogger(ModeloDepartamentos.class.getName()).log(Level.SEVERE, null, ex);
		    }
		  }
	    
		
		
		
		/*
		
		public void modificarPerfil(Perfil p) {
	    	 Statement st;
	        try {
	        	
	        	Conexion con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	        	st = jdbcConnection.createStatement();
	    		 con.getJdbcConnection();
	    		 
	    		
	    		 st.close();
	             con.desconectar();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}  
	    
		
		
		public void eliminarPerfil(int idPerfil) {
	    
	    	Statement st;
	    try {
	    	Conexion con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	    	st = jdbcConnection.createStatement();
			con.getJdbcConnection();
			
			 st.close();
	         con.desconectar();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}*/
	}


