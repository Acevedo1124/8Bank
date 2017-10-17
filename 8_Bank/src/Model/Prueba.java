package Model;


import java.sql.SQLException;
 
/*
 * @autor: Elivar Largo
 * @web: www.ecodeup.com
 */
 
public class Prueba {
	private Conexion con;

 //Constructor que recibe los datos de la conexión SQL e inicializa el objeto de conexión con dichos dparámetros
	public Prueba(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
 
		
	public void Test() throws SQLException {
		//Inicia la conexión
		con.conectar();
		//INGRESE AQUI COSAS SQL
		con.desconectar();
		//cierra la conexión

	}
 
 

}
