package es.sanitas.hos.ehealth.services.api.vo.comunes;

import java.io.Serializable;

public class ProveedorVO implements Serializable {

	private static final long serialVersionUID = -2899575196875946961L;

	private Long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
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
}
