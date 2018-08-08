package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.*;
import dao.impl.EtapaImpl;
import dao.impl.ProyectoImpl;
import dto.*;

@ManagedBean(name = "metapaBean")
@SessionScoped
public class EtapaBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	
	// // Model
	 private Proyecto proyecto = new Proyecto();

	 // DAO Implementation
	 private ProyectoImpl proyectoImpl = new ProyectoImpl();

	

	 // model
	 private Etapa etapa = new Etapa();

	 // dao
	 private EtapaImpl etapaImpl = new EtapaImpl();

	 // CRUD
	 public String create() {
		 etapaImpl.create(etapa);
	 	return "index";
	 }

	 public List<Etapa> getAll() {
	 	try {
	 		List<Etapa> list = etapaImpl.getAll();
	 		return list;
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 		return null;
	 	}
	 }

	 public String update() {
		 etapaImpl.update(etapa);
	 	return "index";
	 }
	 public String delete() {
		Long id = this.etapa.getId();
	 	this.etapa= new Etapa();
	 	etapaImpl.delete(id);
	 	return "/pages/grupo/index.xhtml?faces-redirect=true";
	 }

	 // Methods
	 public String add() {
	 	this.etapa = new Etapa();
	 	long max = etapaImpl.getMaxId();
	 	this.etapa.setId(max);
	 	return "add";
	 }

	 public String edit() {
	 	Long id = this.etapa.getId();
	 	this.etapa= new Etapa();
	 	this.etapa = (Etapa) etapaImpl.getById(id);
	 	return "edit";
	 }

	 public String show() {
	 	Long id = this.etapa.getId();
	 	this.etapa = new Etapa();
	 	this.etapa = (Etapa) etapaImpl.getById(id);
	 	return "show";
	 }

	 // Routes
	 public String index() {
	 	return "/pages/grupo/index";
	 }
}
