package bean;

import java.io.*;
import java.util.*;
import javax.faces.bean.*;
import dao.impl.*;
import dto.*;

@ManagedBean
@SessionScoped
public class ProveedorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
		// Model
		private Proveedor proveedor = new Proveedor();

		// DAO Implementation
		private ProveedorImpl proveedorImpl = new ProveedorImpl();

		// Bean Inyectado
		@ManagedProperty(value = "#{mBancoBean}")
		private BancoBean bancoBean;

		// Getters & Setters

		public Proveedor getProveedor() {
			return proveedor;
		}

		public void setProveedor(Proveedor proveedor) {
			this.proveedor = proveedor;
		}

		public BancoBean getBancoBean() {
			return bancoBean;
		}

		public void setBancoBean(BancoBean bancoBean) {
			this.bancoBean = bancoBean;
		}

		// CRUD
		public String create() {
			proveedorImpl.create(proveedor);
			return "index";
		}



		public List<Proveedor> getAll() {
			try {
				List<Proveedor> list = proveedorImpl.getAll();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		public String update() {
			proveedorImpl.update(proveedor);
			return "index";
		}

		public String delete() {
			Long deleteId = this.proveedor.getId();
			this.proveedor = new Proveedor();
			proveedorImpl.delete(deleteId);
			return "/pages/proveedor/index.xhtml?faces-redirect=true";
		}

		public String unsuscribe() {
			Long unsuscribeId = this.proveedor.getId();
			this.proveedor = new Proveedor();
			this.proveedor = (Proveedor) proveedorImpl.getById(unsuscribeId);
			proveedorImpl.unSuscribe(proveedor);
			return "/pages/proveedor/index.xhtml?faces-redirect=true";
		}

		// Redirecciones - Rutas
		public String add() {
			this.proveedor = new Proveedor();
			long max = proveedorImpl.getMaxId();
			this.proveedor.setId(max);
			return "add"; //muestra la vista
		}

		public String edit() {
			Long editId = this.proveedor.getId();
			this.proveedor = new Proveedor();
			this.proveedor = (Proveedor) proveedorImpl.getById(editId);
			return "edit";
		}




		public String show() {
			Long id = this.proveedor.getId();
			this.proveedor = new Proveedor();
			this.proveedor = (Proveedor) proveedorImpl.getById(id);
			return "show";
		}




		public String index() {
			return "/pages/proveedor/index";
		}

	}

	
	

