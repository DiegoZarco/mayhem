package es.sanitas.hos.ehealth.services.api.vo.comunes;

import java.io.Serializable;
import java.util.Date;

public class ClienteVO implements Serializable{

	private static final long serialVersionUID = -7389191728627744281L;

	private Long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String documento;
	private String domicilio;
	private String telefono1;
	private String telefono2;
	private Date fechaNac;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(final Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
}
