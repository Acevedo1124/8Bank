package Entity;

public class Departamentos {
	 
	 private int idDpto;
	 private String nombreDpto;
	 private Boolean estadoDpto;
	 
	 public Departamentos(int idDpto, String nombreDpto, Boolean estadoDpto) {
		 
		this.idDpto = idDpto;
		this.nombreDpto = nombreDpto;
		this.estadoDpto = estadoDpto;
	}
	 
	public Departamentos() {
		// TODO Auto-generated constructor stub
	}

	public int getIdDpto() {
		return idDpto;
	}
	public void setIdDpto(int idDpto) {
		this.idDpto = idDpto;
	}
	public String getNombreDpto() {
		return nombreDpto;
	}
	public void setNombreDpto(String nombreDpto) {
		this.nombreDpto = nombreDpto;
	}
	public Boolean getEstadoDpto() {
		return estadoDpto;
	}
	public void setEstadoDpto(Boolean estadoDpto) {
		this.estadoDpto= estadoDpto;
	}
}
