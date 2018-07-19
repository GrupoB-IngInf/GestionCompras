package bean;

import java.io.*;
import java.util.*;
import javax.faces.bean.*;
import dao.impl.*;
import dto.*;

@ManagedBean(name = "mbancoBean")
@SessionScoped

public class BancoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		// Model
		private Banco banco = new Banco();

		// DAO Implementation
		private BancoImpl bancoImpl = new BancoImpl();

		// Getters & Setters
		public Banco getbanco() {
			return banco;
		}

		public void setbanco(Banco banco) {
			this.banco = banco;
		}

		// CRUD
		public String create() {
			bancoImpl.create(banco);
			return "index";
		}

		public List<Banco> getAll() {
			try {
				List<Banco> list = bancoImpl.getAll();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		public String update() {
			bancoImpl.update(banco);
			return "index";
		}
		
		public String delete() {
			Long id = this.banco.getId();
			this.banco = new Banco();
			bancoImpl.delete(id);
			return "/pages/banco/index.xhtml?faces-redirect=true";
		}

		// Methods
		public String add() {
			this.banco = new Banco();
			long max = bancoImpl.getMaxId();
			this.banco.setId(max);
			return "add";
		}

		public String edit() {
			Long id = this.banco.getId();
			this.banco = new Banco();
			this.banco = (Banco) bancoImpl.getById(id);
			return "edit";
		}

		public String show() {
			Long id = this.banco.getId();
			this.banco = new Banco();
			this.banco = (Banco) bancoImpl.getById(id);
			return "show";
		}

		// Routes
		public String index() {
			return "/pages/banco/index";
		}

	

}
