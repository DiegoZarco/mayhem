package es.sanitas.hos.mayhem.persistence.entities.comunes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICIO")
@SequenceGenerator(name = "SERVICIO_SEQ", sequenceName = "SERVICIO_SEQ")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 2122371907268149476L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVICIO_SEQ")
	private Long id;

	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	// Un servicio tiene varias prestaciones
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "servicio")
	private List<Prestacion> prestaciones;

	// Un servicio se proporciona en un centro determinado y a su vez un centro
	// tiene varios servicios
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Centro> centros;

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

	public List<Prestacion> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(List<Prestacion> prestaciones) {
		this.prestaciones = prestaciones;
	}

	public List<Centro> getCentros() {
		return centros;
	}

	public void setCentros(List<Centro> centros) {
		this.centros = centros;
	}
}
