package es.sanitas.hos.ehealth.services.api.vo.comunes;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la capa vista de Servicio
 * @author DIEGO
 *
 */
public class ServicioVO implements Serializable{

	private static final long serialVersionUID = -3935810983470787313L;

	private Long id;
	private String descripcion;
	private List<PrestacionVO> prestaciones;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<PrestacionVO> getPrestaciones() {
		return prestaciones;
	}
	public void setPrestaciones(List<PrestacionVO> prestaciones) {
		this.prestaciones = prestaciones;
	}
}
