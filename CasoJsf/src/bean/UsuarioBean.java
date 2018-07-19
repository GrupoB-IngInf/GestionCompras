package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import dao.impl.*;
import dto.Usuario;


@ManagedBean(name = "usuariosBean")
@SessionScoped
public class UsuarioBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	//Model
	private Usuario usuario= new Usuario();
	//DAO implementation
	private UsuarioImpl usuarioimpl = new UsuarioImpl();
	
	
	//Getters and Setters
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	// CRUD
		public String create() {
			usuarioimpl.create(usuario);
			return "index";
		}



		public List<Usuario> getAll() {
			try {
				List<Usuario> list = usuarioimpl.getAll();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		public String update() {
			usuarioimpl.update(usuario);
			return "index";
		}

		public String delete() {
			Long deleteId = this.usuario.getId();
			this.usuario = new Usuario();
			usuarioimpl.delete(deleteId);
			return "/pages/usuario/index.xhtml?faces-redirect=true";
		}
		
		public String unsuscribe() {
			Long unsuscribeId = this.usuario.getId();
			this.usuario = new Usuario();
			this.usuario = (Usuario) usuarioimpl.getById(unsuscribeId);
			usuarioimpl.unSuscribe(usuario);
			return "/pages/usuario/index.xhtml?faces-redirect=true";
		}

		// Redirecciones - Rutas
		public String add() {
			this.usuario = new Usuario();
			long max = usuarioimpl.getMaxId();
			this.usuario.setId(max);
			return "add";
		}

		public String edit() {
			Long editId = this.usuario.getId();
			this.usuario = new Usuario();
			this.usuario = (Usuario) usuarioimpl.getById(editId);
			return "edit";
		}
		

		

		public String show() {
			Long id = this.usuario.getId();
			this.usuario = new Usuario();
			this.usuario = (Usuario) usuarioimpl.getById(id);
			return "show";
		}
		
		

		
		public String index() {
			return "/pages/usuario/index";
		}

}
