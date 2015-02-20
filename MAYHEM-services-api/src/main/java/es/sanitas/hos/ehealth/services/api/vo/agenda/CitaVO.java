package es.sanitas.hos.ehealth.services.api.vo.agenda;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import es.sanitas.hos.ehealth.services.api.vo.comunes.ClienteVO;

public class CitaVO implements Serializable{

	private static final long serialVersionUID = 4699141891510275058L;

	private Long id;
	private Date fecha;
	private String horaInicio;
	private String horaFin;
	private List<ClienteVO> clientes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	public List<ClienteVO> getClientes() {
		return clientes;
	}
	public void setClientes(List<ClienteVO> clientes) {
		this.clientes = clientes;
	}
}
