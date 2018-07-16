package bean;

import java.io.*;
import java.util.*;
import javax.faces.bean.*;
import dao.impl.*;
import dto.*;

@ManagedBean(name = "mgrupoBean")
@SessionScoped
public class GrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Model
	private Grupo grupo = new Grupo();

	// DAO Implementation
	private GrupoImpl grupoImpl = new GrupoImpl();

	// Getters & Setters
	public Grupo getgrupo() {
		return grupo;
	}

	public void setgrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	// CRUD
	public String create() {
		grupoImpl.create(grupo);
		return "index";
	}

	public List<Grupo> getAll() {
		try {
			List<Grupo> list = grupoImpl.getAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String update() {
		grupoImpl.update(grupo);
		return "index";
	}
	
	public String delete() {
		Long id = this.grupo.getId();
		this.grupo = new Grupo();
		grupoImpl.delete(id);
		return "/pages/grupo/index.xhtml?faces-redirect=true";
	}

	// Methods
	public String add() {
		this.grupo = new Grupo();
		long max = grupoImpl.getMaxId();
		this.grupo.setId(max);
		return "add";
	}

	public String edit() {
		Long id = this.grupo.getId();
		this.grupo = new Grupo();
		this.grupo = (Grupo) grupoImpl.getById(id);
		return "edit";
	}

	public String show() {
		Long id = this.grupo.getId();
		this.grupo = new Grupo();
		this.grupo = (Grupo) grupoImpl.getById(id);
		return "show";
	}

	// Routes
	public String index() {
		return "/pages/grupo/index";
	}

}
