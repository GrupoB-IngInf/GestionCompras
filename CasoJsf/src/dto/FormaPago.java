package dto;

public enum FormaPago {
	
	CONTADO("Contado"),
	CONTRAENTREGA("Contraentrega"),
	FACTURA_7_DIAS("Factura a 7 días"),
	FACTURA_15_DIAS("Factura a 15 días"),
	FACTURA_30_DIAS("Factura a 30 días"),
	LETRA_30_DIAS("Letra a 30 días"),
	LETRA_45_DIAS("Letra a 45 días"),
	LETRA_60_DIAS("Letra a 60 días");

	private String etiqueta;

	private FormaPago(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getEtiqueta() {
		return etiqueta;
	}
}
