package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dao.impl.PermisoImpl;
import dao.impl.RolesImpl;
import dto.Rol;
import dto.Rol;

@ManagedBean(name = "rolbean")
@SessionScoped
public class RolBean implements Serializable{

	private static final long serialVersionUID = 1L;

	// Model
		private Rol rol = new Rol();

		// DAO Implementation
		private RolesImpl rolesimpl = new RolesImpl();
		
		// Bean 
		


		// Getters & Setters
			
		public Rol getRol() {
			return rol;
		}

		public void setRol(Rol rol) {
			this.rol = rol;
		}

	
		
		// CRUD
		public String create() {
			rolesimpl.create(rol);
			return "index";
		}

		
		public List<Rol> getAll() {
			try {
				List<Rol> list = rolesimpl.getAll();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		public String update() {
			rolesimpl.update(rol);
			return "index";
		}
		
		public String delete() {
			Long id = this.rol.getId();
			this.rol = new Rol();
			rolesimpl.delete(id);
			return "/pages/rol/index.xhtml?faces-redirect=true";
		}

		// Methods
		public String add() {
			this.rol = new Rol();
			long max = rolesimpl.getMaxId();
			this.rol.setId(max);
			return "add";
		}

		public String edit() {
			Long id = this.rol.getId();
			this.rol = new Rol();
			this.rol = (Rol) rolesimpl.getById(id);
			return "edit";
		}

		public String show() {
			Long id = this.rol.getId();
			this.rol = new Rol();
			this.rol = (Rol) rolesimpl.getById(id);
			return "show";
		}

		// Routes
		public String index() {
			return "/pages/rol/index";
		}
}
