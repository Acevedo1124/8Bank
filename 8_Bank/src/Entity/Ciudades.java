package Entity;

public class Ciudades {

	private int id,idDepart,identificacion;
	private String nombre;
	
	public Ciudades() {
		
		this.id = 0;
		this.idDepart =0;
		this.identificacion = 0;
		this.nombre = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDepart() {
		return idDepart;
	}

	public void setIdDepart(int idDepart) {
		this.idDepart = idDepart;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
}
