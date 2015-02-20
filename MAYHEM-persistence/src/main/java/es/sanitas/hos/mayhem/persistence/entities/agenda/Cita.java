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
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.sanitas.hos.mayhem.persistence.entities.comunes.Cliente;

/**
 * Momento fisico en el que se produce el encuentro (ya sea fisico o digital)
 * entre un proveedor de servicios y un cliente
 * 
 * @author DIEGO
 * 
 */
@Entity
@Table(name = "CITA")
@SequenceGenerator(name="CITA_SEQ", sequenceName="CITA_SEQ")
public class Cita implements Serializable {

	private static final long serialVersionUID = 7105530210496946289L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITA_SEQ")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA", nullable = false)
	private Date fecha;

	@Column(name = "HORA_INI", nullable = false)
	private String horaInicio;

	@Column(name = "HORA_FIN", nullable = false)
	private String horaFin;

	//Una cita puede estar asociada a varios clientes al mismo tiempo
	@ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	private List<Cliente> clientes;

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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cita [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (fecha != null) {
			builder.append("fecha=");
			builder.append(fecha);
			builder.append(", ");
		}
		if (horaInicio != null) {
			builder.append("horaInicio=");
			builder.append(horaInicio);
			builder.append(", ");
		}
		if (horaFin != null) {
			builder.append("horaFin=");
			builder.append(horaFin);
			builder.append(", ");
		}
		if (clientes != null) {
			builder.append("clientes=");
			for (Cliente c : clientes) {
				builder.append(c.toString());
			}
		}
		builder.append("]");
		return builder.toString();
	}
}
