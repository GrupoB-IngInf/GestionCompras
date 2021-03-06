package bean;

import java.io.*;
import java.util.*;

import javax.faces.bean.*;

import dao.impl.*;
import dto.*;

@ManagedBean
@SessionScoped
public class ProyectoBean  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Proyecto proyecto = new Proyecto();
	
	private ProyectoImpl proyectoImpl=new ProyectoImpl();
	
	//inyectar beanEtapa
	
	private Etapa etapa = new Etapa();
	private EtapaImpl etapaImpl = new EtapaImpl();

	
	public String addEtapa()
	{
		etapa.setProyecto(proyecto);
		etapaImpl.create(etapa);

		return "index";
	}
	
	public String removeEtapa()
	{
		Long deleteId = this.proyecto.getId();
		this.etapa= new Etapa();
		etapaImpl.delete(deleteId);
		return "index";
	}
	public Etapa getEtapa() {
		return etapa;
	}
	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	public String create() {
		proyectoImpl.create(proyecto);
		return "index";
	}
	


	public List<Proyecto> getAll() {
		try {
			List<Proyecto> list = proyectoImpl.getAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String update() {
		proyectoImpl.update(proyecto);
		return "index";
	}

	public String delete() {
		Long deleteId = this.proyecto.getId();
		this.proyecto = new Proyecto();
		proyectoImpl.delete(deleteId);
		return "/pages/proyecto/index.xhtml?faces-redirect=true\"";
	}

	


	// Redirecciones - Rutas
	public String add() {
		this.proyecto = new Proyecto();
		long max = proyectoImpl.getMaxId();
		long maxEtapa = etapaImpl.getMaxId();
		this.etapa.setId(maxEtapa);
		this.proyecto.setId(max);
		return "add"; //muestra la vista
	}

	public String edit() {
		Long editId = this.proyecto.getId();
		this.proyecto = new Proyecto();
		this.proyecto = (Proyecto) proyectoImpl.getById(editId);
		long maxEtapa = etapaImpl.getMaxId();
		this.etapa.setId(maxEtapa);
		return "edit";
	}




	public String show() {
		Long id = this.proyecto.getId();
		this.proyecto = new Proyecto();
		this.proyecto = (Proyecto) proyectoImpl.getById(id);
		return "show";
	}




	public String index() {
		return "/pages/proyecto/index";
	}
	
	
	
	
	
	
}
