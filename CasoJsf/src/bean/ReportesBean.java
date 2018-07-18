package bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import dao.impl.AreaNegocioImpl;
import dao.impl.MaterialImpl;
import dto.AreaNegocio;
import dto.Material;
import net.sf.jasperreports.engine.JRException;

@ManagedBean(name="reportesBean")
@ViewScoped
public class ReportesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{materialBean}")
	private MaterialBean materialBean;
		
	public void materiales() throws JRException, IOException {
		MaterialImpl materialImpl = new MaterialImpl();
		List<Material> dataSource = materialImpl.getAll();	
				
		String filename = "reporte_materiales.pdf";
		String jasperPath = "/resources/report.jasper";
		
		PDFGenerator.showPDF(null, jasperPath, dataSource, filename);
	}
	
	public void areasNegocio() throws JRException, IOException {
		AreaNegocioImpl areanegocioImpl = new AreaNegocioImpl();
		List<AreaNegocio> dataSource = areanegocioImpl.getAll();	
				
		String filename = "reporte_area_de_negocio.pdf";
		String jasperPath = "/resources/area_de_negocio.jasper";
		
		PDFGenerator.showPDF(null, jasperPath, dataSource, filename);
	}
	
	public void proyectos() throws JRException, IOException {
		//ProyectoImpl proyectoImpl = new ProyectoImpl();
		//List<Proyecto> dataSource = proyectoImpl.getAll();	
				
		String filename = "reporte_proyectos.pdf";
		String jasperPath = "/resources/proyectos.jasper";
		
		PDFGenerator.showPDF(null, jasperPath, null, filename);
	}
	
	public void usuarios() throws JRException, IOException {
		//UsuarioImpl usuarioImpl = new UsuarioImpl();
		//List<Usuario> dataSource = usuarioImpl.getAll();	
				
		String filename = "reporte_usuarios.pdf";
		String jasperPath = "/resources/usuarios.jasper";
		
		PDFGenerator.showPDF(null, jasperPath, null, filename);
	}

	public MaterialBean getMaterialBean() {
		return materialBean;
	}

	public void setMaterialBean(MaterialBean materialBean) {
		this.materialBean = materialBean;
	}

}
