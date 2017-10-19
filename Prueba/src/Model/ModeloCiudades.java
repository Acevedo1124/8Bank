package Model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;

import Entity.Ciudades;
import Entity.Departamentos;
import util.Conexion;

public class ModeloCiudades {
	private Conexion con;
	private Connection connection;
	
	public ModeloCiudades(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public ModeloCiudades() throws SQLException {
		System.out.println("Inicializando");
		con = new Conexion();
	}
	
	public void guardar_ciudad(Ciudades ciudad){
		String nombre = ciudad.getNombre();
		int departamento = ciudad.getId_departamento();
		Statement st;
	    try {
	    	con.conectar();
	    	connection = con.getJdbcConnection();
	    	st = connection.createStatement();
	    st.execute("insert into tb_ciudades (nombre, tb_Departamentos_idtb_Departamentos,Estado) values ('"+nombre+"','"+departamento+"',1);");
	    st.close();
        con.desconectar();
	    } catch (SQLException ex) {
	        Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
	    }
	  }
	
	public void modificar_ciudad(Ciudades ciudad){		
		int id = ciudad.getId_ciudad();
		String nombre = ciudad.getNombre();
		int departamento = ciudad.getId_departamento();
		Statement st;
	    try {
	    	con.conectar();
	    	connection = con.getJdbcConnection();
	    	st = connection.createStatement();
	    st.execute("update tb_ciudades set nombre = '"+nombre+"', tb_Departamentos_idtb_Departamentos = '"+departamento+"' where idtb_Ciudades = '"+id+"';");
	    st.close();
        con.desconectar();
	    } catch (SQLException ex) {
	        Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
	    }
	  }
	
	public List<Ciudades>  modificarXid(String Id) throws SQLException {
		con.conectar(); 
		List<Ciudades> listaCiudades= new ArrayList<Ciudades>();
		String sql = "SELECT * FROM tb_ciudades WHERE idtb_Ciudades = '"+ Id +"';";
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		while (resulSet.next()) {
			int id =resulSet.getInt("idtb_Ciudades");
			String nombre = resulSet.getString("nombre");
			int departamento =resulSet.getInt("tb_Departamentos_idtb_Departamentos");
			Ciudades ciudad = new Ciudades(id, nombre, departamento);
			listaCiudades.add(ciudad);
		}
       con.desconectar();
       return listaCiudades;
	}
	
	public void eliminar_ciudad(Ciudades ciudad){		
		int id = ciudad.getId_ciudad();
		Statement st;
	    try {
	    	con.conectar();
	    	connection = con.getJdbcConnection();
	    	st = connection.createStatement();
	    st.execute("update tb_ciudades set Estado = 0 where idtb_Ciudades = '"+id+"'; ");
	    st.close();
        con.desconectar();
	    } catch (SQLException ex) {
	        Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
	    }
	  }
	
	public List<Ciudades>  listar_ciudades() throws SQLException {
		con.conectar();
		List<Ciudades> listaCiudades= new ArrayList<Ciudades>();
		String sql = "SELECT * FROM tb_ciudades where Estado = 1";
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		while (resulSet.next()) {
			int id = resulSet.getInt("idtb_Ciudades");
			String nombre = resulSet.getString("nombre");
			int departamento = resulSet.getInt("tb_Departamentos_idtb_Departamentos");
			Ciudades ciudad = new Ciudades(id, nombre, departamento);
			listaCiudades.add(ciudad);
		}
		con.desconectar();
		return listaCiudades;
	}
	
	public Boolean buscar_ciudades(String ciu) throws SQLException {
		con.conectar();
		String sql = "SELECT * FROM tb_ciudades where nombre = '"+ ciu +"' and Estado = 1;";
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = null;
		resulSet = statement.executeQuery(sql);
		
		if(resulSet.next()) {
			con.desconectar();
			return true;
		}
		else {
			con.desconectar();
			return false;
		}
	}
	
	public List<Ciudades>  FiltrarCiudades(String Nombre,String Departamento, int Op) throws SQLException {
		con.conectar(); 
		List<Ciudades> listaCiudades= new ArrayList<Ciudades>();
		String sql = "SELECT * FROM tb_ciudades where Estado = 1;;";
		if (Op==1)
			sql = "SELECT * FROM tb_ciudades where nombre = '"+ Nombre +"' and Estado = 1;;";
		if (Op == 2)
		    sql = "SELECT * FROM tb_ciudades WHERE tb_Departamentos_idtb_Departamentos = '"+ Departamento +"' and Estado = 1;;";
		if (Op == 3)
			sql = "SELECT * FROM tb_ciudades WHERE nombre = '"+ Nombre +"' and tb_Departamentos_idtb_Departamentos = '"+ Departamento +"' and Estado = 1;;";
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		while (resulSet.next()) {
			int id =resulSet.getInt("idtb_Ciudades");
			String nombre = resulSet.getString("nombre");
			int departamento =resulSet.getInt("tb_Departamentos_idtb_Departamentos");
			Ciudades ciudad = new Ciudades(id, nombre, departamento);
			listaCiudades.add(ciudad);
		}
       con.desconectar();
       return listaCiudades;
	}
	
	public List<Departamentos>  Listar_departamentos(String Id, String Nombre) throws SQLException {
		con.conectar(); 
		List<Departamentos> listarDepartamentos= new ArrayList<Departamentos>();
		String sql = "SELECT * FROM tb_departamentos;";
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		while (resulSet.next()) {
			int id = resulSet.getInt("idtb_Departamentos");
			String nombre = resulSet.getString("nombre");
			Boolean estado = resulSet.getBoolean("estado");
			Departamentos departamentos = new Departamentos(id, nombre,estado);
			listarDepartamentos.add(departamentos);
		}
       con.desconectar();
       return listarDepartamentos;
	}

}
