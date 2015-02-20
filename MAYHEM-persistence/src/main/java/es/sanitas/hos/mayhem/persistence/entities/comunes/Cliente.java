package es.sanitas.hos.mayhem.persistence.entities.comunes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Identifica a un client que recibe un servicio determinado por parte de un
 * proveedor
 * 
 * @author DIEGO
 * 
 */
@Entity
@Table(name = "CLIENTE")
@SequenceGenerator(name="CLIENTE_SEQ", sequenceName="CLIENTE_SEQ")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 4070768222956321658L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
	private Long id;
	
	//El cliente debe estar asociado a una empresa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPRESA_ID", nullable = false)
	private Empresa empresa;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "APELLIDO1", nullable = false)
	private String apellido1;

	@Column(name = "APELLIDO2", nullable = true)
	private String apellido2;

	@Column(name = "DOCUMENTO", nullable = true)
	private String documento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NAC", nullable = false)
	private Date fechaNacimiento;
	
	@Column(name = "DOMICILIO", nullable = true)
	private String domicilio;
	
	@Column(name = "TELEFONO1", nullable = true)
	private String telefono1;
	
	@Column(name = "TELEFONO2", nullable = true)
	private String telefono2;

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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
