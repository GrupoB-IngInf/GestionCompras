package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.impl.UnidadMedidaImpl;
import dto.UnidadMedida;

@ManagedBean(name = "munidadmedidaBean")
@SessionScoped
public class UnidadMedidaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Model
			private UnidadMedida unidadMedida = new UnidadMedida();

			// DAO Implementation
			private UnidadMedidaImpl unidadMedidaImpl = new UnidadMedidaImpl();

			// Getters & Setters
			public UnidadMedida getunidadMedida() {
				return unidadMedida;
			}

			public void setunidadMedida(UnidadMedida unidadMedida) {
				this.unidadMedida = unidadMedida;
			}

			// CRUD
			public String create() {
				unidadMedidaImpl.create(unidadMedida);
				return "index";
			}

			public List<UnidadMedida> getAll() {
				try {
					List<UnidadMedida> list = unidadMedidaImpl.getAll();
					return list;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}

			public String update() {
				unidadMedidaImpl.update(unidadMedida);
				return "index";
			}
			
			public String delete() {
				Long id = this.unidadMedida.getId();
				this.unidadMedida = new UnidadMedida();
				unidadMedidaImpl.delete(id);
				return "/pages/unidades/index.xhtml?faces-redirect=true";
			}

			// Methods
			public String add() {
				this.unidadMedida = new UnidadMedida();
				long max = unidadMedidaImpl.getMaxId();
				this.unidadMedida.setId(max);
				return "add";
			}

			public String edit() {
				Long id = this.unidadMedida.getId();
				this.unidadMedida = new UnidadMedida();
				this.unidadMedida = (UnidadMedida) unidadMedidaImpl.getById(id);
				return "edit";
			}

			public String show() {
				Long id = this.unidadMedida.getId();
				this.unidadMedida = new UnidadMedida();
				this.unidadMedida = (UnidadMedida) unidadMedidaImpl.getById(id);
				return "show";
			}

			// Routes
			public String index() {
				return "/pages/unidades/index";
			}
}
