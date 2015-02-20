package es.sanitas.hos.ehealth.services.api.vo.comunes;

import java.io.Serializable;

public class CentroVO implements Serializable{

	private static final long serialVersionUID = 3795242382454725077L;
	
	private Long id;
	private String nombre;
	private String codigo;
	private Long idEmpresa;
	
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

}
