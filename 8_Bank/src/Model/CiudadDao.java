package Model;

import java.sql.*;
import java.util.ArrayList;
import util.Conexion;
import Entity.Ciudades;

public class CiudadDao {
	Conexion conexion;

	public CiudadDao() {
		conexion = new Conexion();
	}
	
	public String insertar_ciudad(int id, String nombre, int identificacion, int idDepart) {
		
		String rptaRegsitro = null;
		try {
			Connection accesoDB = conexion.getConexion();	        
	        String sql = "insert into tb_ciuadades (idtb_Ciuadades,nombre,tb_Departamentos_idtb_Departamentos,Identificacion) values (?,?,?,?);";
	        
			PreparedStatement statement = accesoDB.prepareStatement(sql);
			statement.setString(1, Integer.toString(id));
			statement.setString(2, nombre);			
			statement.setString(3, Integer.toString(idDepart));
			statement.setString(4, Integer.toString(identificacion));
			
			int numAfec = statement.executeUpdate();
			if(numAfec > 0) {
				rptaRegsitro = "Registro exitoso";
			}
	        
		}
		catch(Exception e)
		{
			rptaRegsitro = "No se pudo registrar";
		}
		
		return rptaRegsitro;
	}
	
	public ArrayList<Ciudades> ListarCiudades(){
		ArrayList ListarCiudades = new ArrayList();
		Ciudades ciudad;
		try {
			Connection acceDB = conexion.getConexion();
			PreparedStatement ps = acceDB.prepareStatement("select * from tb_ciuadades;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ciudad = new Ciudades();
				ciudad.setId(rs.getInt(1));
				ciudad.setNombre(rs.getString(2));				
				ciudad.setIdDepart(rs.getInt(3));
				ciudad.setIdentificacion(rs.getInt(4));
				ListarCiudades.add(ciudad);				
			}
			
		}catch(Exception e) {
			
		}
		
		return ListarCiudades;
	}
}
