package bean;

import java.io.*;
import java.util.*;
import javax.faces.bean.*;
import dao.impl.*;
import dto.*;

@ManagedBean
@SessionScoped
public class CentrocostoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Centrocosto centrocosto = new Centrocosto();
	
	private CentrocostoImpl centrocostoImpl = new CentrocostoImpl();


	// Getters & Setters
	
	public void setCentrocosto(Centrocosto centrocosto) {
		this.centrocosto = centrocosto;
	}
	public Centrocosto getCentrocosto() {
		return centrocosto;
	}
	
	
	//CRUD
	public String create() {
		centrocostoImpl.create(centrocosto);
		return "index";
	}
	
	public List<Centrocosto> getAll() {
		try {
			List<Centrocosto> list = centrocostoImpl.getAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String update() {
		centrocostoImpl.update(centrocosto);
		return "index";
	}
	
	public String delete() {
		Long deleteid = this.centrocosto.getId();
		this.centrocosto = new Centrocosto();
		centrocostoImpl.delete(deleteid);
		return "/pages/centrocosto/index.xhtml?faces-redirect=true";
	}
	
	
	public String unsuscribe() {
		Long unsuscribeId = this.centrocosto.getId();
		this.centrocosto = new Centrocosto();
		this.centrocosto = (Centrocosto) centrocostoImpl.getById(unsuscribeId);
		centrocostoImpl.unSuscribe(centrocosto);
		return "/pages/centrocosto/index.xhtml?faces-redirect=true";
	}
	
	// Rutas
	public String add() {
		this.centrocosto = new Centrocosto();
		long max = centrocostoImpl.getMaxId();
		this.centrocosto.setId(max);
		return "add";
	}

	public String edit() {
		Long editId = this.centrocosto.getId();
		this.centrocosto = new Centrocosto();
		this.centrocosto = (Centrocosto) centrocostoImpl.getById(editId);
		return "edit";
	}

	public String show() {
		Long id = this.centrocosto.getId();
		this.centrocosto = new Centrocosto();
		this.centrocosto = (Centrocosto) centrocostoImpl.getById(id);
		return "show";
	}

	// Routes
	public String index() {
		return "/pages/centrocosto/index";
	}


}
