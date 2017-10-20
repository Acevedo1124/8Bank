package Entity;

public class Usuario {
	
	private int Identificacion, Estado, Borrado, idCiudades,Rol;
	private String Nombre, Primer_apellido, Segundo_apellido, Mail, Telefono, Usuario, Contraseña;
	
	public Usuario() {
		this.Identificacion = 0;
		this.Estado = 0;
		this.Borrado = 0;
		this.idCiudades = 0;
		this.Nombre = "";
		this.Primer_apellido = "";
		this.Segundo_apellido = "";
		this.Mail = "";
		this.Telefono = "";
		this.Usuario = "";
		this.Contraseña = "";
		this.Rol =0;
	}
	
	public Usuario(int Identificacion,int Estado,int Borrado,int idCiudades,String Nombre,
				String Primer_apellido,String Segundo_apellido,String Mail,String Telefono,String Usuario,String Contraseña,int Rol) {
		this.Identificacion = Identificacion;
		this.Estado = Estado;
		this.Borrado = Borrado;
		this.idCiudades = idCiudades;
		this.Nombre = Nombre;
		this.Primer_apellido = Primer_apellido;
		this.Segundo_apellido = Segundo_apellido;
		this.Mail = Mail;
		this.Telefono = Telefono;
		this.Usuario = Usuario;
		this.Contraseña = Contraseña;
		this.Rol =Rol;
	}
	
	public int getIdentificacion() {
		return Identificacion;
	}
	public void setRol(int Rol) {
		this.Rol = Rol;
	}
	public int getRol() {
		return Rol;
	}
	public void setIdentificacion(int identificacion) {
		Identificacion = identificacion;
	}
	
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	public int getBorrado() {
		return Borrado;
	}
	public void setBorrado(int borrado) {
		Borrado = borrado;
	}
	public int getIdCiudades() {
		return idCiudades;
	}
	public void setIdCiudades(int idCiudades) {
		this.idCiudades = idCiudades;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getPrimer_apellido() {
		return Primer_apellido;
	}
	public void setPrimer_apellido(String primer_apellido) {
		Primer_apellido = primer_apellido;
	}
	public String getSegundo_apellido() {
		return Segundo_apellido;
	}
	public void setSegundo_apellido(String segundo_apellido) {
		Segundo_apellido = segundo_apellido;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	
}
