package es.sanitas.hos.ehealth.services.api.vo.comunes;

import java.io.Serializable;
import java.util.List;

public class EmpresaVO implements Serializable{

	private static final long serialVersionUID = 976587406405410443L;
	
	private Long id;
	private String nombre;
	private List<Long> idCentrosAsociados;
	
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
	public List<Long> getIdCentrosAsociados() {
		return idCentrosAsociados;
	}
	public void setIdCentrosAsociados(List<Long> idCentrosAsociados) {
		this.idCentrosAsociados = idCentrosAsociados;
	}
	
}
