package bean;

import java.io.*;
import java.util.*;
import javax.faces.bean.*;
import dao.impl.*;
import dto.*;

@ManagedBean(name = "mareaNegocioBean")
@SessionScoped
public class AreaNegocioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Model
	private AreaNegocio area = new AreaNegocio();

	// DAO Implementation
	private AreaNegocioImpl areaImpl = new AreaNegocioImpl();

	// Getters & Setters
	public AreaNegocio getArea() {
		return area;
	}

	public void setArea(AreaNegocio area) {
		this.area = area;
	}

	// CRUD
	public String create() {
		areaImpl.create(area);
		return "index";
	}

	public List<AreaNegocio> getAll() {
		try {
			List<AreaNegocio> list = areaImpl.getAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String update() {
		areaImpl.update(area);
		return "index";
	}
	
	public String delete() {
		Long id = this.area.getId();
		this.area = new AreaNegocio();
		areaImpl.delete(id);
		return "/pages/areanegocio/index.xhtml?faces-redirect=true";
	}

	// Methods
	public String add() {
		this.area = new AreaNegocio();
		long max = areaImpl.getMaxId();
		this.area.setId(max);
		return "add";
	}

	public String edit() {
		Long id = this.area.getId();
		this.area = new AreaNegocio();
		this.area = (AreaNegocio) areaImpl.getById(id);
		return "edit";
	}

	public String show() {
		Long id = this.area.getId();
		this.area = new AreaNegocio();
		this.area = (AreaNegocio) areaImpl.getById(id);
		return "show";
	}

	// Routes
	public String index() {
		return "/pages/areanegocio/index";
	}

}

