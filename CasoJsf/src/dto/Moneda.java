package dto;

public enum Moneda {
	SOLES("Soles"), 
	DOLARES("Dólares"), 
	EUROS("Euros");
	
	private String etiqueta;

    private Moneda(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

}
