package es.sanitas.hos.ehealth.services.api.vo.comunes;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Clase para la capa vista de pretaciones
 * @author DIEGO
 *
 */
public class PrestacionVO implements Serializable{

	private static final long serialVersionUID = -6428671634071850412L;

	private Long id;
	private String descripcion;
	private BigDecimal precio;
	private Long idServicio;
	private String descServicio;	
	
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
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Long getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}
	public String getDescServicio() {
		return descServicio;
	}
	public void setDescServicio(String descServicio) {
		this.descServicio = descServicio;
	}
}
