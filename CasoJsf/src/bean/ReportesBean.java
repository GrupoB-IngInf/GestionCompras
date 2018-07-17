package bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import dao.impl.MaterialImpl;
import dto.Material;
import net.sf.jasperreports.engine.JRException;

@ManagedBean(name="reportesBean")
@ViewScoped
public class ReportesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{materialBean}")
	private MaterialBean materialBean;
	
	private MaterialImpl materialImpl = new MaterialImpl();
	
	public void materiales() throws JRException, IOException {
		List<Material> dataSource = materialImpl.getAll();	
				
		String filename = "reporte_materiales.pdf";
		String jasperPath = "/resources/report.jasper";
		
		PDFGenerator.showPDF(null, jasperPath, dataSource, filename);
	}

	public MaterialBean getMaterialBean() {
		return materialBean;
	}

	public void setMaterialBean(MaterialBean materialBean) {
		this.materialBean = materialBean;
	}

}
