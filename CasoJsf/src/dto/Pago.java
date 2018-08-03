package dto;

public enum Pago {
	
	CHEQUE("Cheque"),
	EFECTIVO("Efectivo"),
	PAGARE("Pagare"),
	TRANSFERENCIA("Transferencia");
	
	private String etiqueta;
	
	private Pago(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public String getEtiqueta() {
		return etiqueta;
	}

}
