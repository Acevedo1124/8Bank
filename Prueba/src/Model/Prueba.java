package Model;


import java.sql.SQLException;
 
/*
 * @autor: Elivar Largo
 * @web: www.ecodeup.com
 */
 
public class Prueba {
	private Conexion con;

 //Constructor que recibe los datos de la conexi�n SQL e inicializa el objeto de conexi�n con dichos dpar�metros
	public Prueba(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
 
		
	public void Test() throws SQLException {
		//Inicia la conexi�n
		con.conectar();
		//INGRESE AQUI COSAS SQL
		con.desconectar();
		//cierra la conexi�n

	}
 
 

}
