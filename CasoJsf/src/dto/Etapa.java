package dto;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "etapa")
public class Etapa {
	private static final long serialVersionUID = 1L;

	public Etapa() {
		super();
		proyecto = new Proyecto();
	}
	
	@Id
	@Basic
	@Column(name = "id")
	private Long id;
	
	@Column(name = "denominacion")
	private String denominacion;

	@Column(name = "duracion")
	private Long duracion;

	@ManyToOne
	//@JoinColumn(name = "proyecto_id")
	private Proyecto proyecto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Long getDuracion() {
		return duracion;
	}

	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Etapa [id=" + id + ", denominacion=" + denominacion + ", duracion=" + duracion + ", proyecto="
				+ proyecto + "]";
	}
	
	
	
	
}
