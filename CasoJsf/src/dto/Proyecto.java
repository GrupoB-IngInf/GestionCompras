package dto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable {

	private static final long serialVersionUID = 1L;

	public Proyecto() {
		super();
	}

	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ubicacion")
	private String ubicacion;
/*
	 @OneToMany(
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
 */
	@OneToMany(mappedBy="proyecto")
    private List<Etapa> etapas = new ArrayList<>();
    
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


	public List<Etapa> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<Etapa> etapas) {
		this.etapas = etapas;
	}

	public void addEtapa(Etapa etapa)
	{
		etapas.add(etapa);
		etapa.setProyecto(this);
	}
	
	public void removeEtapa(Etapa etapa)
	{
		etapas.remove(etapa);
		etapa.setProyecto(null);
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	
	


}
