package Controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import Entity.Ciudades;
import Entity.Departamentos;
import Entity.Rol;
import Entity.Usuario;
import Model.ModeloCiudades;
import Model.ModeloDepartamentos;

@WebServlet("/ControlCiudades")
public class ControlCiudades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModeloCiudades Objeto_ModeloCiudades;
	ModeloDepartamentos Objeto_ModeloDepartamentos;
	String Ciu;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			Objeto_ModeloCiudades = new ModeloCiudades(jdbcURL, jdbcUsername, jdbcPassword);
			Objeto_ModeloDepartamentos = new ModeloDepartamentos(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
		
		}
	}
	
	public ControlCiudades() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Ciu = request.getParameter("Ciu");
		String accion = request.getParameter("action");
		System.out.println(Ciu);
		try {
			
			if (accion !="" && accion!= null) {				
				if (accion.equals("Guardar"))
					GuardarCiudad(request,response);
				if (accion.equals("Modificar"))
					ModificarCiudad(request,response);
				if (accion.equals("Eliminar"))
					EliminarCiudad(request,response);
				if (accion.equals("Listar"))
					ListCiudad(request, response);
				if (accion.equals("Filtrar"))
					FiltrarCiudad(request,response);
				if (accion.equals("ModificarXid"))
					ModificarXid(request,response);
				if (accion.equals("GuardarNuevo"))
					Guardar(request, response);
			}
			if (Ciu!="" && Ciu!= null)
				BuscarCiudad(request, response);
			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void GuardarCiudad(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher;
		String nombre = request.getParameter("txtNombre");
		String departamento = (request.getParameter("txtDepartamento"));
		Ciudades ciudad = new Ciudades(0, nombre, departamento);
		try {
			Objeto_ModeloCiudades.guardar_ciudad(ciudad);
			dispatcher = request.getRequestDispatcher("ControlCiudades?action=Listar&guardado="+nombre);
		}
		catch(Exception e){
			dispatcher = request.getRequestDispatcher("View/AddCiudad.jsp");
			request.setAttribute("resultado", "Error al guardar la ciudad " + nombre);
			System.out.println("ERRROR al guardar...");
		}
			dispatcher.forward(request, response);
	}
	
	private void ModificarCiudad(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher;
		int id = Integer.parseInt(request.getParameter("txtId"));
		String nombre = request.getParameter("txtNombre");
		String departamento = (request.getParameter("txtDepartamento"));
		Ciudades ciudad = new Ciudades(id, nombre, departamento);
		try {
			Objeto_ModeloCiudades.modificar_ciudad(ciudad);
			dispatcher = request.getRequestDispatcher("ControlCiudades?action=Listar&modifico="+nombre);
		}
		catch(Exception e){
			dispatcher = request.getRequestDispatcher("View/UpdateCiudad.jsp");
			request.setAttribute("resultado", "Error al modificar la ciudad " + nombre);
			System.out.println("ERRROR al modificar...");
		}
			dispatcher.forward(request, response);
	}
	
	private void EliminarCiudad(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher;
		int id = Integer.parseInt(request.getParameter("Id"));
		Ciudades ciudad = new Ciudades(id,"","");
		try {
			Objeto_ModeloCiudades.eliminar_ciudad(ciudad);
			dispatcher = request.getRequestDispatcher("ControlCiudades?action=Listar&elimino="+id);
		}
		catch(Exception e){
			dispatcher = request.getRequestDispatcher("View/AddCiudad.jsp");
			request.setAttribute("resultado", "Error al modificar la ciudad " + id);
			System.out.println("ERRROR al modificar...");
		}
			dispatcher.forward(request, response);
	}
	
	private void ListCiudad(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ListCiudad.jsp");
		List<Ciudades> CiudadesTabla;
		try {
			CiudadesTabla =  Objeto_ModeloCiudades.listar_ciudades();
			request.setAttribute("lista", CiudadesTabla);
			String nomGuar = request.getParameter("guardado");
			String nomMod = request.getParameter("modifico");
			String nomEli = request.getParameter("elimino");
			if (nomGuar!=null && nomGuar!="") {
				request.setAttribute("resultado", "Se ha guardado la ciudad " + nomGuar + " exitosamente");
				}
			if (nomMod!=null && nomMod!="") {
				request.setAttribute("resultado", "Se ha modificado la ciudad " + nomMod + " exitosamente");
				}
			if (nomEli!=null && nomEli!="") {
				request.setAttribute("resultado", "Se ha eliminado la ciudad " + nomEli + " exitosamente");
				}
		}
		catch(Exception e){
			System.out.println("ERRROR al listar...");
		}
			dispatcher.forward(request, response);
	}
	
	private void BuscarCiudad(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/IndexCiudad.jsp");
		Boolean Verificacion;
		try {
			Verificacion =  Objeto_ModeloCiudades.buscar_ciudades(Ciu);
			if(Verificacion)
				request.setAttribute("Respuesta", "Existe");
			else
				request.setAttribute("Respuesta", "No Existe");
		}
		catch(Exception e){
			System.out.println("ERRROR al buscar..."+e);
			System.out.println("ERRROR al buscar...");
		}
			dispatcher.forward(request, response);
	}
	
	private void FiltrarCiudad(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/ListCiudad.jsp");
		List<Ciudades> CiudadTabla;
		String nombre = request.getParameter("FilterNombre");
		String departamento = request.getParameter("FilterDepartamento");
		int Op =0;
		if (nombre != "")
			Op=1;
		if (departamento != "")
			Op=2;
		if (nombre != "" && departamento != "")
			Op=3;
		try {
			CiudadTabla =  Objeto_ModeloCiudades.FiltrarCiudades(nombre, departamento, Op);
			request.setAttribute("lista", CiudadTabla);
		}
		catch(Exception e){
			System.out.println("ERRROR al filtrar...");
		}
			dispatcher.forward(request, response);
	}
	
	private void ModificarXid(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/UpdateCiudad.jsp");
		List<Ciudades> CiudadTabla;
		String Id = request.getParameter("FilterId");
		try {
			CiudadTabla =  Objeto_ModeloCiudades.modificarXid(Id);
			request.setAttribute("IdCiudad", CiudadTabla.get(0).getId_ciudad());
			request.setAttribute("nombre", CiudadTabla.get(0).getNombre());
			request.setAttribute("id_departamento", CiudadTabla.get(0).getId_departamento());
		}
		catch(Exception e){
			System.out.println("ERRROR al consultar...");
		}
			dispatcher.forward(request, response);
	}
	
	private void ListarDepartamento(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/AddCiudad.jsp");
		List<Departamentos> ListaDepartamentos;
		String Id = request.getParameter("");
		String Nombre = request.getParameter("");
		try {
			ListaDepartamentos =  Objeto_ModeloCiudades.Listar_departamentos(Id, Nombre);
			request.setAttribute("IdDepar", ListaDepartamentos.get(0).getIdDpto());
			request.setAttribute("nombre", ListaDepartamentos.get(0).getNombreDpto());
			request.setAttribute("id_departamento", ListaDepartamentos.get(0).getEstadoDpto());
		}
		catch(Exception e){
			System.out.println("ERRROR al consultar...");
		}
			dispatcher.forward(request, response);
	}
	
	private void Guardar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/AddCiudad.jsp");
		List<Departamentos> ListaDpto;
		try {
 		ListaDpto=Objeto_ModeloDepartamentos.listarDpto();
			
			
			request.setAttribute("Dpto", ListaDpto);	
			
			dispatcher.forward(request, response);
		}
		catch(Exception e){
			System.out.println("ERRROR al buscar...");
		}
		
	}

}



