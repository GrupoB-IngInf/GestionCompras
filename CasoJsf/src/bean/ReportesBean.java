package bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import dao.impl.AreaNegocioImpl;
import dao.impl.CentrocostoImpl;
import dao.impl.GrupoImpl;
import dao.impl.MaterialImpl;
import dao.impl.ProyectoImpl;
import dao.impl.UsuarioImpl;
import dto.AreaNegocio;
import dto.Centrocosto;
import dto.Grupo;
import dto.Material;
import dto.Proyecto;
import dto.Usuario;
import net.sf.jasperreports.engine.JRException;

@ManagedBean(name="reportesBean")
@ViewScoped
public class ReportesBean implements Serializable {

	private static final long serialVersionUID = 1L;
			
	public void materiales() throws JRException, IOException {
		MaterialImpl materialImpl = new MaterialImpl();
		List<Material> dataSource = materialImpl.getAll();	
				
		String filename = "reporte_materiales.pdf";
		String jasperPath = "/resources/materiales.jasper";
		
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
		ProyectoImpl proyectoImpl = new ProyectoImpl();
		List<Proyecto> dataSource = proyectoImpl.getAll();
				
		String filename = "reporte_proyectos.pdf";
		String jasperPath = "/resources/proyectos.jasper";
		
		PDFGenerator.showPDF(null, jasperPath, dataSource, filename);
	}
	
	public void usuarios() throws JRException, IOException {
		UsuarioImpl usuarioImpl = new UsuarioImpl();
		List<Usuario> dataSource = usuarioImpl.getAll();	
				
		String filename = "reporte_usuarios.pdf";
		String jasperPath = "/resources/usuarios.jasper";
		
		PDFGenerator.showPDF(null, jasperPath, dataSource, filename);
	}
	
	public void centroCosto() throws JRException, IOException {
		CentrocostoImpl centroCostoImpl = new CentrocostoImpl();
		List<Centrocosto> dataSource = centroCostoImpl.getAll();	
				
		String filename = "reporte_centro_de_costos.pdf";
		String jasperPath = "/resources/centro_de_costo.jasper";
		
		PDFGenerator.showPDF(null, jasperPath, dataSource, filename);
	}
	
	public void grupos() throws JRException, IOException {
		GrupoImpl gruposImpl = new GrupoImpl();
		List<Grupo> dataSource = gruposImpl.getAll();	
				
		String filename = "reporte_grupos.pdf";
		String jasperPath = "/resources/grupos.jasper";
		
		PDFGenerator.showPDF(null, jasperPath, dataSource, filename);
	}
	
}
