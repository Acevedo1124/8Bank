package Model;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entity.Rol;
import util.Conexion;

import java.sql.Statement;
import java.sql.ResultSet;
/*
 * @autor: Yina Muñoz, Santiago agudelo
 * 
 */
public class ModeloRol {
	private Conexion con;
	private Connection connection;
 //Constructor que recibe los datos de la conexión SQL e inicializa el objeto de conexión con dichos dparámetros
	public ModeloRol(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	public ModeloRol() throws SQLException {
		System.out.println("Inicializando");
		//Constructor en caso de que no se ingresen los datos de la conexión
		con = new Conexion();
	}
	//Método en el cual se listan todos los roles en la base de datos
	public List<Rol>  ListRol() throws SQLException {
		//Inicia la conexión
		con.conectar();
		//se crea la lista, en la cual se almacenarán los resultados de la consulta
		List<Rol> listaRoles= new ArrayList<Rol>();
		//Se crea el string de la consulta
		String sql = "SELECT * FROM tb_rol";
		//se obtiene la conexión y se ejecuta el query
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		//Y se lleva el resultado del query a un ResultSet
		//Si hay datos resultSet.next() retorna true, entonces
		//mientras halla lectura de datos se amacenarán los resultados de la consulta
		//en el List de Rol que creamos anteriormente
		while (resulSet.next()) {
			//se llama cada dato del resultado de la consta por nombre de la columna
			int id = resulSet.getInt("idtb_Rol");
			String nombre = resulSet.getString("nombre");
			String descripcion = resulSet.getString("descripcion");
			//se crea el constructor de la clase Rol
			Rol articulo = new Rol(id, nombre, descripcion);
			//Se almacenan en la lista
			listaRoles.add(articulo);
		}
		con.desconectar();
		//finalmente se desconecta y se retorna la lista
		return listaRoles;
		//cierra la conexión
	}
	//Filtrar es un método muy similar a listar, sólo cambia la consulta sql
	public List<Rol>  FiltrarRol(String ID,String Nombre,int Op) throws SQLException {
		//Inicia la conexión
		con.conectar(); 
		//se inicializa una lista por si la consulta devuelve más de un resultado
		List<Rol> listaRoles= new ArrayList<Rol>();
		//inicialmente se tiene que la consulta a realizar es para listar toda la tabla
		String sql="SELECT * FROM tb_rol";
		if (Op==1)
			//si solo se llenó el campo ID la variable Op es igual a 1, lo cual resulta en esta consulta
			sql = "SELECT * FROM tb_rol where idtb_rol = " + ID;
		if (Op==2)
			// si solo se llenó el campo nombre la variable Op es igual a 2, lo cual resulta en esta consulta
			sql = "SELECT * FROM tb_rol where nombre = '" + Nombre + "'";
		if (Op==3)
			// si se llenaron ambos campos Op es igual a 3 lo cual resulta en esta consulta
			sql = "SELECT * FROM tb_rol where  idtb_rol = " + ID + " and nombre = '" + Nombre + "'";
		//se obtiene la conexión y se ejecuta el query
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		//y de igual forma que en el Listar rol se obtiene cada campo de la consulta
		//mientras existan datos en el objeto ResultSet
		while (resulSet.next()) {
			//Se obtienen los campos uno a uno y se guardan en la lista previamente creada
			int id = resulSet.getInt("idtb_Rol");
			String nombre = resulSet.getString("nombre");
			String descripcion = resulSet.getString("descripcion");
			Rol articulo = new Rol(id, nombre, descripcion);
			listaRoles.add(articulo);
		}
		//se desconecta y se retorna la lista creada
		con.desconectar();
		return listaRoles;
	
		//cierra la conexión
	}
	//en buscar es una comprovaciòn y función de prueba para el login
	//lo que se hace es buscar un campo en la base de datos, si existe se retorna true, caso contrario false
	public Boolean Buscar(String Usr) throws SQLException {
		//Inicia la conexión
		con.conectar();
		//Se crea el Query y se ejecuta la consulta
		String sql = "SELECT * FROM tb_rol where nombre='"+ Usr+"';";
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
		//cierra la conexión dontro del if y el else ya que dentro de estos se retorna
	}
	//En guardar rol se obtiene un objeto tipo Rol y se almacena en la base de datos
	public void guardarRol(Rol RolNuevo){
		//Se obtiene solo el nombre y la descripción de dicho objeto
		String nombre = RolNuevo.getNombre();
		String descripcion = RolNuevo.getDescripcion();
		Statement st;
	    try {
	    	//se conecta y se obtiene la conexión.
	    	con.conectar();
	    	connection = con.getJdbcConnection();
	    	st = connection.createStatement();
	    	//se prepara el string de la consulta, solo se agrega nombre y descripción
	    	// ya que el ID es un valor auto-incremento y no es necesario especificarlo
	    st.execute("INSERT INTO tb_rol ( nombre, descripcion) VALUES ('"+ nombre +"','" + descripcion +"');");
	    st.close();
	    //se ejecuta y se  cierra tanto el statement como la conexiòn
        con.desconectar();
	    } catch (SQLException ex) {
	        Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
	    }
	  }
	//metodo modificarRol
public void modificarRol(Rol rolModificar) { //llamo a la clase Rol y le asigno un objeto dentro del método
		int id = rolModificar.getId();
		String nombre = rolModificar.getNombre(); //asigno en una variable, lo que tiene el objeto
		String descripcion = rolModificar.getDescripcion();
		rolModificar.setNombre(nombre);
		rolModificar.setDescripcion(descripcion);
		rolModificar.setId(id);
		Statement st;
		try {
			con.conectar(); //se llama al metodo conectar, y se obtiene la conexion
			connection = con.getJdbcConnection(); //asignamos al objeto lo que tiene la conexion
			st = connection.createStatement();// almacenamos en el objeto st la conexion
			st.execute("update tb_rol set nombre='"+rolModificar.getNombre()+"', descripcion = '"+rolModificar.getDescripcion()+"' WHERE idtb_Rol="+rolModificar.getId()+";");
			//asigamos en el objeto la ejecucion de la conexion
		} catch (Exception e) {
			Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
