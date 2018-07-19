package bean;

import java.io.*;
import java.util.*;
import javax.faces.bean.*;
import dao.impl.*;
import dto.*;

@ManagedBean(name = "mpermisoBean")
@SessionScoped
public class PermisosBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// Model
	private Permiso permisos = new Permiso();

	// DAO Implementation
	private PermisoImpl permisoImpl = new PermisoImpl();
	
	// Bean 
	@ManagedProperty(value = "#{rolbean}")
	private RolBean rolbean;


	// Getters & Setters
		
	public Permiso getPermisos() {
		return permisos;
	}

	public void setPermisos(Permiso permisos) {
		this.permisos = permisos;
	}

	public RolBean getRolbean() {
		return rolbean;
	}

	public void setRolbean(RolBean rolbean) {
		this.rolbean = rolbean;
	}

	
	// CRUD
	public String create() {
		permisoImpl.create(permisos);
		return "index";
	}

	public List<Permiso> getAll() {
		try {
			List<Permiso> list = permisoImpl.getAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String update() {
		permisoImpl.update(permisos);
		return "index";
	}
	
	public String delete() {
		Long id = this.permisos.getId();
		this.permisos = new Permiso();
		permisoImpl.delete(id);
		return "/pages/permisos/index.xhtml?faces-redirect=true";
	}

	// Methods
	public String add() {
		this.permisos = new Permiso();
		long max = permisoImpl.getMaxId();
		this.permisos.setId(max);
		return "add";
	}

	public String edit() {
		Long id = this.permisos.getId();
		this.permisos = new Permiso();
		this.permisos = (Permiso) permisoImpl.getById(id);
		return "edit";
	}

	public String show() {
		Long id = this.permisos.getId();
		this.permisos = new Permiso();
		this.permisos = (Permiso) permisoImpl.getById(id);
		return "show";
	}

	// Routes
	public String index() {
		return "/pages/permisos/index";
	}
	}