package util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 //Librer�a de conexi�n SQL
 
public class Conexion {
	
	private Connection jdbcConnection;
	//Objeto de conexi�n SQL, aqu� se puede tener informaci�n del estado de las conexiones SQL en el sistema
    private String jdbcURL;
    //String en el cual se especifica la direcci�n del servidor y la base de datos conectarse
    private String jdbcUsername;
    //String en el que se especifica el usuario de la base de datos.
    private String jdbcPassword;
    //String en el que se especifica la contrase�a del usuario en la base de datos
    
    
    
    public Conexion(String jdbcURL, String jdbcUsername, String jdbcPassword) {
    	//constructor en el que se trae los datos de conexi�n y se asignan localmente
    	this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
 
	public void conectar() throws SQLException {
		//Si la conexi�n SQL es nula o est� cerrada
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
            	//Inicializa el driver e inicializa la conexi�n
                Class.forName("com.mysql.jdbc.Driver");
                jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
           
            } catch (ClassNotFoundException e) {
            	//Muestra la exepci�n ante cualquier error 
                throw new SQLException(e);
            }
            
        }
       
    }
     
    public void desconectar() throws SQLException {
    	//si no es nula o no est� cerrada la conexi�n
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            //CIerra la conexi�n
        	jdbcConnection.close();
            
        }
    }
 
	public Connection getJdbcConnection() {
		//OBtiene el objeto Connection para usarlo externamente
		return jdbcConnection;
	}  
 

}
