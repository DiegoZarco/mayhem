package es.sanitas.hos.mayhem.persistence.entities.agenda;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.sanitas.hos.mayhem.persistence.entities.comunes.Prestacion;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Proveedor;

/**
 * Clase Agenda que modela la agenda con las citas que pueda llegar a tener un
 * proveedor de servicios para un dia determinado (fecha).
 * 
 * @author DIEGO
 * 
 */
@Entity
@Table(name = "AGENDA")
@SequenceGenerator(name="AGENDA_SEQ", sequenceName="AGENDA_SEQ")
public class Agenda implements Serializable {

	private static final long serialVersionUID = -7409472835613280004L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENDA_SEQ")
	private Long id;

	@ManyToOne(targetEntity = Proveedor.class, fetch = FetchType.LAZY)
	private Proveedor proveedor;
	
	@ManyToOne(targetEntity = Prestacion.class, fetch = FetchType.LAZY)
	private Prestacion prestacion;

	@OneToMany(targetEntity = Cita.class, cascade = CascadeType.ALL)
	private List<Cita> citas;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA")
	private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Prestacion getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agenda [");
		if (proveedor != null) {
			builder.append("proveedor=");
			builder.append(proveedor);
			builder.append(", ");
		}
		if (citas != null) {
			builder.append("citas=");
			builder.append(citas);
			builder.append(", ");
		}
		if (fecha != null) {
			builder.append("fecha=");
			builder.append(fecha);
		}
		builder.append("]");
		return builder.toString();
	}
}
