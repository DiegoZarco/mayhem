package es.sanitas.hos.ehealth.services.api.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase encargada de recoger la informacion de la pantalla de creacion de
 * agenda
 * 
 * @author DIEGO
 * 
 */
public class CrearAgendaVO implements Serializable {

	private static final long serialVersionUID = 7560263978958330504L;
	
	private Date fechaInicio;
	private Date fechaFin;
	private Long idPrestacion;
	private Long idProveedor;
	private Integer minutosHueco;
	private String horaInicio;
	private String horaFin;
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Long getIdPrestacion() {
		return idPrestacion;
	}
	public void setIdPrestacion(Long idPrestacion) {
		this.idPrestacion = idPrestacion;
	}
	public Long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}
	public Integer getMinutosHueco() {
		return minutosHueco;
	}
	public void setMinutosHueco(Integer minutosHueco) {
		this.minutosHueco = minutosHueco;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
}
