package es.sanitas.hos.mayhem.persistence.entities.comunes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase Proveedor, identifica a una persona fisica que provee de servicios a clientes
 * (Medicos, Profesores, etc)
 * @author DIEGO
 *
 */
@Entity
@Table(name = "PROVEEDOR")
@SequenceGenerator(name="PROVEEDOR_SEQ", sequenceName="PROVEEDOR_SEQ")
public class Proveedor implements Serializable{

	private static final long serialVersionUID = 3090021381523072269L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVEEDOR_SEQ")
	private Long id;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "APELLIDO1", nullable = false)
	private String apellido1;
	
	@Column(name = "APELLIDO2", nullable = true)
	private String apellido2;
	
	public Proveedor() {
	}

	public Proveedor(Long id) {
		super();
		this.id = id;
	}

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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Proveedor [");
		if (nombre != null) {
			builder.append("nombre=");
			builder.append(nombre);
			builder.append(", ");
		}
		if (apellido1 != null) {
			builder.append("apellido1=");
			builder.append(apellido1);
			builder.append(", ");
		}
		if (apellido2 != null) {
			builder.append("apellido2=");
			builder.append(apellido2);
		}
		builder.append("]");
		return builder.toString();
	}
}
