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

	@Column(name = "ubicacion")
	private String ubicacion;

	@ManyToOne
	@JoinColumn(name = "proyecto_id")
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	
}
