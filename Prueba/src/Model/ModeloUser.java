package Model;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entity.Usuario;
import util.Conexion;

import java.sql.Statement;
import java.sql.ResultSet;

 
public class ModeloUser {
	private Conexion con;
	private Connection connection;
 //Constructor que recibe los datos de la conexi�n SQL e inicializa el objeto de conexi�n con dichos par�metros
	public ModeloUser(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
 
	public ModeloUser() throws SQLException {
		System.out.println("Inicializando");
		//Constructor en caso de que no se ingresen los datos de la conexi�n
		con = new Conexion();
	}
	
	
	//M�todo en el cual se listan todos los roles en la base de datos
	public List<Usuario>  ListUsuario() throws SQLException {
		//Inicia la conexi�n
		con.conectar();
		//se crea la lista, en la cual se almacenar�n los resultados de la consulta
		List<Usuario> listaUser= new ArrayList<Usuario>();
		//Se crea el string de la consulta
		String sql = "SELECT * FROM tb_rol";
		//se obtiene la conexi�n y se ejecuta el query
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		//Y se lleva el resultado del query a un ResultSet
		//Si hay datos resultSet.next() retorna true, entonces
		//mientras halla lectura de datos se amacenar�n los resultados de la consulta
		//en el List de Rol que creamos anteriormente
		while (resulSet.next()) {
			int Identificacion = resulSet.getInt("Identificacion");
			int Estado = resulSet.getInt("Estado");
			int Borrado= resulSet.getInt("Borrado");
			int idCiudades= resulSet.getInt("tb_Ciudades_idtb_Ciudades");
			
			String Nombre = resulSet.getString("Nombre");
			String Primer_apellido = resulSet.getString("Primer_apellido");
			String Segundo_apellido= resulSet.getString("Segundo_apellido");
			String Mail = resulSet.getString("Mail");
			String Telefono = resulSet.getString("Telefono");
			String Usuario = resulSet.getString("Usuario");
			String Contrase�a = resulSet.getString("Contrase�a");
		
			//se crea el constructor de la clase Usuario
			Usuario us = new Usuario(Identificacion, Estado, Borrado, idCiudades,Nombre, Primer_apellido, Segundo_apellido, Mail, Telefono, Usuario, Contrase�a);
			//Se almacenan en la lista
			listaUser.add(us);
		}
		con.desconectar();
		//finalmente se desconecta y se retorna la lista
		return listaUser;
		
	
		//cierra la conexi�n

	}
 
	
	public List<Usuario>  FiltrarUser(int Id, String nombre, int Op) throws SQLException {
		
		con.conectar(); 
		
		List<Usuario> listaUser= new ArrayList<Usuario>();
		
		String sql="SELECT * FROM tb_usuario";
		if (Op==1)
			
			sql = "SELECT * FROM tb_usuario where Identificacion = " + Id;
		if (Op==2)
			
			sql = "SELECT * FROM tb_usuario where Nombre = '" + nombre + "'";
		if (Op==3)
			
			sql = "SELECT * FROM tb_usuario where  Identificacion = " + Id + " and Nombre = '" + nombre + "'";
		
		//se obtiene la conexi�n y se ejecuta el query
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		//y de igual forma que en el Listar rol se obtiene cada campo de la consulta
		//mientras existan datos en el objeto ResultSet
		while (resulSet.next()) {
			//Se obtienen los campos uno a uno y se guardan en la lista previamente creada
			int Identificacion = resulSet.getInt("Identificacion");
			int Estado = resulSet.getInt("Estado");
			int Borrado= resulSet.getInt("Borrado");
			int idCiudades= resulSet.getInt("tb_Ciudades_idtb_Ciudades");
			String Nombre = resulSet.getString("Nombre");
			String Primer_apellido = resulSet.getString("Primer_apellido");
			String Segundo_apellido= resulSet.getString("Segundo_apellido");
			String Mail = resulSet.getString("Mail");
			String Telefono = resulSet.getString("Telefono");
			String Usuario = resulSet.getString("Usuario");
			String Contrase�a = resulSet.getString("Contrase�a");
			
			Usuario us = new Usuario(Identificacion, Estado, Borrado, idCiudades,Nombre, Primer_apellido, Segundo_apellido, Mail, Telefono, Usuario, Contrase�a);
			
			listaUser.add(us);
		}
		//se desconecta y se retorna la lista creada
		con.desconectar();
		return listaUser;
		

	}
	
	
	
	
	//en buscar es una comprovaci�n y funci�n de prueba para el login
	//lo que se hace es buscar un campo en la base de datos, si existe se retorna true, caso contrario false
	public Boolean BuscarId(int id) throws SQLException {
		//Inicia la conexi�n
		con.conectar();
		//Se crea el Query y se ejecuta la consulta
		String sql = "SELECT * FROM tb_usuario where Identificacion="+ id+";";
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = null;
		resulSet = statement.executeQuery(sql);
		
//el Usr consultado existe, resultSet.next() es true, caso contrario es falso.
		if(resulSet.next()) {
			con.desconectar();
			return true;
		}
		else {
			con.desconectar();
			return false;
		}
		
		
	
		//cierra la conexi�n dontro del if y el else ya que dentro de estos se retorna

	}
	
	public Boolean BuscarNombre(String nombre) throws SQLException {
		//Inicia la conexi�n
		con.conectar();
		//Se crea el Query y se ejecuta la consulta
		String sql = "SELECT * FROM tb_usuario where Nombre ='"+ nombre+"';";
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = null;
		resulSet = statement.executeQuery(sql);
		
//el Usr consultado existe, resultSet.next() es true, caso contrario es falso.
		if(resulSet.next()) {
			con.desconectar();
			return true;
		}
		else {
			con.desconectar();
			return false;
		}
		
		
	
		//cierra la conexi�n dontro del if y el else ya que dentro de estos se retorna

	}
	
	//En guardar rol se obtiene un objeto tipo Rol y se almacena en la base de datos
	
	public void guardarUser(Usuario UserNuevo){

		
		//Se obtiene solo el nombre y la descripci�n de dicho objeto
		
		Statement st;
	    try {
	    	//se conecta y se obtiene la conexi�n.
	    	con.conectar();
	    	connection = con.getJdbcConnection();
	    	st = connection.createStatement();
	    	//se prepara el string de la consulta, solo se agrega nombre y descripci�n
	    	// ya que el ID es un valor auto-incremento y no es necesario especificarlo
	    	
	    	String sql= "INSERT INTO `tb_usuario` (`Identificacion`, `Nombre`, `Primer_apellido`, `Segundo_apellido`, `Mail`, `Telefono`, `Usuario`, `Contrase�a`, `Estado`, `Borrado`, `tb_Ciuadades_idtb_Ciuadades`) VALUES\r\n" + 
	    			"("+UserNuevo.getIdentificacion()+",'"+UserNuevo.getNombre()+"','"+UserNuevo.getPrimer_apellido()+"','"+UserNuevo.getSegundo_apellido()+"','"+UserNuevo.getMail()+"','"+UserNuevo.getTelefono()+"','"+UserNuevo.getUsuario()+"','"+UserNuevo.getContrase�a()+"',"+UserNuevo.getEstado()+","+UserNuevo.getBorrado()+",'"+UserNuevo.getIdCiudades()+");";
	    st.execute(sql); 
	    st.close();
	    //se ejecuta y se  cierra tanto el statement como la conexi�n
        con.desconectar();
	    } catch (SQLException ex) {
	        Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
	    }
	  }

}

