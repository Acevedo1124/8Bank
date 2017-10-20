package Entity;

public class Ciudades {
	
	private int id_ciudad;
	private String nombre;
	private String id_departamento;

	public Ciudades(int id_ciudad, String nombre, String id_departamento) {
		super();
		this.id_ciudad = id_ciudad;
		this.nombre = nombre;
		this.id_departamento = id_departamento;
	}

	public int getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(String id_departamento) {
		this.id_departamento = id_departamento;
	}
}
