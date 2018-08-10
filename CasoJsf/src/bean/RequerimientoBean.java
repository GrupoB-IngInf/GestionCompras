package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dao.impl.AreaNegocioImpl;
import dao.impl.CentrocostoImpl;
import dao.impl.EtapaImpl;
import dao.impl.MaterialImpl;
import dao.impl.RequerimientoImpl;
import dto.AreaNegocio;
import dto.Centrocosto;
import dto.Etapa;
import dto.Material;
import dto.Requerimiento;
import dto.RequerimientoDetalle;
import dto.Usuario;

@ManagedBean(name = "requerimientoBean")
@SessionScoped
public class RequerimientoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Model
	private Requerimiento requerimiento;
	private RequerimientoDetalle requerimientoDetalle;
	private Centrocosto centrocosto;
	private AreaNegocio areaNegocio;
	private Usuario usuario;
	private Material material;
	private Etapa etapa;
	private long idEtapa;
	private long idCentroCosto;
	private long idAreaNegocio;
	private long idMaterial;
	//Dao Impl
	
	private RequerimientoImpl requerimientoImpl = new RequerimientoImpl();
	private EtapaImpl etapaImpl = new EtapaImpl();
	private CentrocostoImpl centrocostoImpl = new CentrocostoImpl();
	private AreaNegocioImpl areaNegocioImpl = new AreaNegocioImpl();
	private MaterialImpl materialImpl = new MaterialImpl();
	
	
	@PostConstruct
	public void init() {
		requerimiento = new Requerimiento();
		requerimiento.setUsuario(new Usuario());
		requerimiento.setAreaNegocio(new AreaNegocio());
		requerimiento.setCentroCosto(new Centrocosto());
		
	}
	
	//Beans inyectados
	
	@ManagedProperty(value = "#{mMaterialBean}")
	private MaterialBean materialBean;
	
	@ManagedProperty(value = "#{mAreaNegocioBean}")
	private AreaNegocioBean areaNegocioBean;
	
	@ManagedProperty(value = "#{mUsuarioBean}")
	private UsuarioBean usuarioBean;
	
	@ManagedProperty(value = "#{mCentroCostoBean}")
	private CentrocostoBean centroCostoBean;

	@ManagedProperty(value = "#{mEtapaBean}")
	private EtapaBean etapaBean;

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}
	
	
	
	
	
	
	public long getIdEtapa() {
		return idEtapa;
	}






	public void setIdEtapa(long idEtapa) {
		this.idEtapa = idEtapa;
	}






	public long getIdCentroCosto() {
		return idCentroCosto;
	}






	public void setIdCentroCosto(long idCentroCosto) {
		this.idCentroCosto = idCentroCosto;
	}






	public Etapa getEtapa() {
		return etapa;
	}






	public long getIdAreaNegocio() {
		return idAreaNegocio;
	}






	public void setIdAreaNegocio(long idAreaCosto) {
		this.idAreaNegocio = idAreaCosto;
	}






	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}




	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}



	public Centrocosto getCentrocosto() {
		return centrocosto;
	}




	public void setCentrocosto(Centrocosto centrocosto) {
		this.centrocosto = centrocosto;
	}




	public AreaNegocio getAreaNegocio() {
		return areaNegocio;
	}


	public void setAreaNegocio(AreaNegocio areaNegocio) {
		this.areaNegocio = areaNegocio;
	}




	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public RequerimientoDetalle getRequerimientoDetalle() {
		return requerimientoDetalle;
	}

	public void setRequerimientoDetalle(RequerimientoDetalle requerimientoDetalle) {
		this.requerimientoDetalle = requerimientoDetalle;
	}

	public RequerimientoImpl getRequerimientoImpl() {
		return requerimientoImpl;
	}

	public void setRequerimientoImpl(RequerimientoImpl requerimientoImpl) {
		this.requerimientoImpl = requerimientoImpl;
	}

	
	
	//Detalles add  

	
	public String additem() {
		Etapa etapa = (Etapa) etapaImpl.getById(this.idEtapa);
		Centrocosto centrocosto = (Centrocosto) centrocostoImpl.getById(this.idCentroCosto);
		AreaNegocio areaNegocio = (AreaNegocio) areaNegocioImpl.getById(this.idAreaNegocio);
		Material material = (Material) materialImpl.getById(this.idMaterial);
		System.out.println(etapa);
		System.out.println(centrocosto);
		System.out.println(areaNegocio);
		System.out.println(material);
		RequerimientoDetalle requerimientoDeta = new RequerimientoDetalle(this.requerimientoDetalle.getCantidad(), this.requerimientoDetalle.getObservaciones(),
				this.requerimientoDetalle.getRequerimiento(), etapa, material);
		
		this.requerimiento.addDetail(requerimientoDeta);
		this.requerimientoDetalle.setCantidad(0);
		
		return null;
	}
	
	public String removeItem(RequerimientoDetalle item) {
	      this.requerimiento.removeDetail(item);
	      return null;
	}
	
	//Fin - Detalles

	
	public MaterialBean getMaterialBean() {
		return materialBean;
	}

	public void setMaterialBean(MaterialBean materialBean) {
		this.materialBean = materialBean;
	}
	
	

	
	//@ManagedProperty(value = "#{mOrdenCompraDetalle}")
	//private OrdenCompraDetalle ordenCompraDetalle;
	
	
	
	
	public AreaNegocioBean getAreaNegocioBean() {
		return areaNegocioBean;
	}

	public long getIdMaterial() {
		return idMaterial;
	}






	public void setIdMaterial(long idMaterial) {
		this.idMaterial = idMaterial;
	}






	public EtapaImpl getEtapaImpl() {
		return etapaImpl;
	}






	public void setEtapaImpl(EtapaImpl etapaImpl) {
		this.etapaImpl = etapaImpl;
	}






	public CentrocostoImpl getCentrocostoImpl() {
		return centrocostoImpl;
	}






	public void setCentrocostoImpl(CentrocostoImpl centrocostoImpl) {
		this.centrocostoImpl = centrocostoImpl;
	}






	public AreaNegocioImpl getAreaNegocioImpl() {
		return areaNegocioImpl;
	}






	public void setAreaNegocioImpl(AreaNegocioImpl areaNegocioImpl) {
		this.areaNegocioImpl = areaNegocioImpl;
	}






	public MaterialImpl getMaterialImpl() {
		return materialImpl;
	}






	public void setMaterialImpl(MaterialImpl materialImpl) {
		this.materialImpl = materialImpl;
	}






	public void setAreaNegocioBean(AreaNegocioBean areaNegocioBean) {
		this.areaNegocioBean = areaNegocioBean;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public CentrocostoBean getCentroCostoBean() {
		return centroCostoBean;
	}

	public void setCentroCostoBean(CentrocostoBean centroCostoBean) {
		this.centroCostoBean = centroCostoBean;
	}

	public EtapaBean getEtapaBean() {
		return etapaBean;
	}

	public void setEtapaBean(EtapaBean etapaBean) {
		this.etapaBean = etapaBean;
	}


	
	//CRUD
	public List<Requerimiento> getAll() {
		try {
			List<Requerimiento> list = requerimientoImpl.getAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String create() {
		requerimientoImpl.create(requerimiento);
		return "index";
	}
	
	public String update() {
		
		requerimientoImpl.update(requerimiento);
		return "index";
	}

	public String delete() {
		Long deleteId = this.requerimiento.getId();
		this.requerimiento = new Requerimiento();
		requerimientoImpl.delete(deleteId);
		return "/pages/requerimiento/index.xhtml?faces-redirect=true";
	}
	
	//Redirecciones
	public String add() {
		this.requerimiento = new Requerimiento();
		this.requerimientoDetalle = new RequerimientoDetalle();
		long max = requerimientoImpl.getMaxId();
		this.requerimiento.setId(max);
		return "add";
	}

	public String edit() {
		Long editId = this.requerimiento.getId();
		this.requerimiento = new Requerimiento();
		this.requerimiento = (Requerimiento) requerimientoImpl.getById(editId);
		return "edit";
	}

	public String show() {
		Long id = this.requerimiento.getId();
		this.requerimiento= new Requerimiento();
		this.requerimiento = (Requerimiento) requerimientoImpl.getById(id);
		return "show";
	}
	
	//Routes
	
	public String index() {
		return "/pages/requerimiento/index";
	}
}