<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMINISTRACION DE USUARIOS GRUPO 8BANK</title>
</head>
<body>
 <table class="table table-striped">
                    
                    
                    <tr>
                        <td><h6>Usuario*</h6></td>
                        <td><input type="text" class="texto" name="txtusuario"></td>
                        <td><h6>Identificacion*</h6></td>
                        <td><input type="text"  name="txtid" class="texto" ></td>
                        
                    </tr>  
                    <tr>
                        <td><h6>Nombre*</h6></td>
                        <td><input type="text" class="texto" name="txtnombre"></td>
                        <td><h6>1er Apellido *</h6></td>
                        <td><input type="text"  name="txtapellido1" class="texto" ></td>
                        <td><h6>2do Apellido</h6></td>
                        <td><input type="text"  name="txtapellido2" class="texto"></td>
                    </tr>  
                    <tr>
                    <td><h6>Correo*</h6></td>
                        <td><input type="text" class="texto" name="txtmail"  ></td>
                        <td><h6>Contraseña*</h6></td>
                        <td><input type="pasword" class ="password" name="txtclave" ></td>
                        <td><h6>Telefono*</h6></td>
                        <td><input type="text" class ="texto" name="txttelefono" ></td>
                        
                        
                    </tr>     

                    <tr>
                        
                        <td><h6>Estado*</h6></td>
                        <td><select  name="cboestado" class="texto">
                                <option value="">-Seleccione-</option>
                                <option value="Activo">Activo</option>
                                <option value="Inactivo">Inactivo</option>

                            </select>
                        </td>
                        <td><h6>Perfil*</h6></td>
                        <td><select  name="cboperfil" class="texto">
                                <option value="">-Seleccione-</option>
                                <option value="Admin" >Admin</option>
                                <option value="Cliente"  >Cliente</option>
                                <option value="Otro" >Otro</option>     
                            </select>
                        </td>
                    </tr>     
 
                </table>  
                
                 <jsp:include page="Fbotones.jsp" flush="true"/>
                 
                 
</body>
</html>