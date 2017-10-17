package util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 //Librería de conexión SQL
 
public class Conexion {
	
	private Connection jdbcConnection;
	//Objeto de conexión SQL, aquí se puede tener información del estado de las conexiones SQL en el sistema
    private String jdbcURL;
    //String en el cual se especifica la dirección del servidor y la base de datos conectarse
    private String jdbcUsername;
    //String en el que se especifica el usuario de la base de datos.
    private String jdbcPassword;
    //String en el que se especifica la contraseña del usuario en la base de datos
    
    
    
    public Conexion(String jdbcURL, String jdbcUsername, String jdbcPassword) {
    	//constructor en el que se trae los datos de conexión y se asignan localmente
    	this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
 
	public void conectar() throws SQLException {
		//Si la conexión SQL es nula o está cerrada
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
            	//Inicializa el driver e inicializa la conexión
                Class.forName("com.mysql.jdbc.Driver");
                jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
           
            } catch (ClassNotFoundException e) {
            	//Muestra la exepción ante cualquier error 
                throw new SQLException(e);
            }
            
        }
       
    }
     
    public void desconectar() throws SQLException {
    	//si no es nula o no está cerrada la conexión
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            //CIerra la conexión
        	jdbcConnection.close();
            
        }
    }
 
	public Connection getJdbcConnection() {
		//OBtiene el objeto Connection para usarlo externamente
		return jdbcConnection;
	}  
 

}
