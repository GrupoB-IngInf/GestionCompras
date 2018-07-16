package bean;

import java.io.*;
import java.util.*;

import javax.faces.bean.*;

import dao.impl.*;
import dto.*;

@ManagedBean
@SessionScoped
public class MaterialBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Model
	private Material material = new Material();

	// DAO Implementation
	private MaterialImpl materialImpl = new MaterialImpl();

	// Bean Inyectado
	@ManagedProperty(value = "#{mGrupoBean}")
	private GrupoBean grupoBean;

	// Getters & Setters

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public GrupoBean getGrupoBean() {
		return grupoBean;
	}

	public void setGrupoBean(GrupoBean grupoBean) {
		this.grupoBean = grupoBean;
	}

	// CRUD
	public String create() {
		materialImpl.create(material);
		return "index";
	}



	public List<Material> getAll() {
		try {
			List<Material> list = materialImpl.getAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String update() {
		materialImpl.update(material);
		return "index";
	}

	public String delete() {
		Long deleteId = this.material.getId();
		this.material = new Material();
		materialImpl.delete(deleteId);
		return "/pages/material/index.xhtml?faces-redirect=true";
	}
	
	public String unsuscribe() {
		Long unsuscribeId = this.material.getId();
		this.material = new Material();
		this.material = (Material) materialImpl.getById(unsuscribeId);
		materialImpl.unSuscribe(material);
		return "/pages/material/index.xhtml?faces-redirect=true";
	}

	// Redirecciones - Rutas
	public String add() {
		this.material = new Material();
		long max = materialImpl.getMaxId();
		this.material.setId(max);
		return "add";
	}

	public String edit() {
		Long editId = this.material.getId();
		this.material = new Material();
		this.material = (Material) materialImpl.getById(editId);
		return "edit";
	}
	

	

	public String show() {
		Long id = this.material.getId();
		this.material = new Material();
		this.material = (Material) materialImpl.getById(id);
		return "show";
	}
	
	

	
	public String index() {
		return "/pages/material/index";
	}

}
