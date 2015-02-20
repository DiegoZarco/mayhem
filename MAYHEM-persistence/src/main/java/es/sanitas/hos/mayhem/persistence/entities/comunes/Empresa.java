package es.sanitas.hos.mayhem.persistence.entities.comunes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
@SequenceGenerator(name="EMPRESA_SEQ", sequenceName="EMPRESA_SEQ")
public class Empresa implements Serializable {

	private static final long serialVersionUID = -4952666851665552343L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPRESA_SEQ")
	private Long id;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	//Una empresa puede tener varios centros asociados
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresas")
	private List<Centro> centros;

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

	public List<Centro> getCentros() {
		return centros;
	}

	public void setCentros(List<Centro> centros) {
		this.centros = centros;
	}
}
