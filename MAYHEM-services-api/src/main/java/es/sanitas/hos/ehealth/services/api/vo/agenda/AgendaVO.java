package es.sanitas.hos.ehealth.services.api.vo.agenda;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import es.sanitas.hos.ehealth.services.api.vo.comunes.PrestacionVO;
import es.sanitas.hos.ehealth.services.api.vo.comunes.ProveedorVO;

public class AgendaVO implements Serializable{

	private static final long serialVersionUID = -406913760986469459L;

	private Long id;
	private ProveedorVO proveedor;
	private PrestacionVO prestacion;
	private List<CitaVO> lstCitas;
	private Date fecha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProveedorVO getProveedor() {
		return proveedor;
	}
	public void setProveedor(ProveedorVO proveedor) {
		this.proveedor = proveedor;
	}
	public PrestacionVO getPrestacion() {
		return prestacion;
	}
	public void setPrestacion(PrestacionVO prestacion) {
		this.prestacion = prestacion;
	}
	public List<CitaVO> getLstCitas() {
		return lstCitas;
	}
	public void setLstCitas(List<CitaVO> lstCitas) {
		this.lstCitas = lstCitas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
