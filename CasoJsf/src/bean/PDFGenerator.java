package bean;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PDFGenerator {
	
	public static void downloadPDF(Map<String, Object> params, String jasperPath, List<?> dataSource, String fileName) throws JRException, IOException {
		String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath);
		File file = new File(relativeWebPath);
		
		JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(dataSource, false);
		JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, source);
				
		HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition", "attachment;filename=" + fileName);
		ServletOutputStream stream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(print, stream);
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public static void showPDF(Map<String, Object> params, String jasperPath, List<?> dataSource, String fileName) throws JRException, IOException {
		String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath);
		File file = new File(relativeWebPath);
		
		JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(dataSource, false);
		byte[] bytes = JasperRunManager.runReportToPdf(file.getPath(), params, source);
		HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream stream = response.getOutputStream();
		stream.write(bytes, 0, bytes.length);
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}

}
