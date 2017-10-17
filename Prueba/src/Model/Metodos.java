package Model;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
/*
 * @autor: Elivar Largo
 * @web: www.ecodeup.com
 */
 
public class Metodos {
	private Conexion con;
	private Connection connection;
 //Constructor que recibe los datos de la conexión SQL e inicializa el objeto de conexión con dichos dparámetros
	public Metodos(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
 
	public Metodos() throws SQLException {
		System.out.println();
		con = new Conexion();
	}
	public void Test() throws SQLException {
		//Inicia la conexión
		con.conectar();
		//INGRESE AQUI COSAS SQL
		con.desconectar();
		//cierra la conexión

	}
	
	public List<Rol>  ListRol() throws SQLException {
		//Inicia la conexión
		con.conectar();
 
		List<Rol> listaArticulos = new ArrayList<Rol>();
		String sql = "SELECT * FROM tb_rol";
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("idtb_Rol");
			String nombre = resulSet.getString("nombre");
			String descripcion = resulSet.getString("descripcion");

			Rol articulo = new Rol(id, nombre, descripcion);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
		
	
		//cierra la conexión

	}
 

}
