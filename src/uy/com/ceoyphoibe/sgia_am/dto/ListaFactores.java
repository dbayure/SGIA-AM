package uy.com.ceoyphoibe.sgia_am.dto;

public class ListaFactores {
	
	private int imagenFactor; 
	private String nombreFactor; 
	private String unidadFactor;
	
	public ListaFactores(int imagenFactor, String nombreFactor,
			String unidadFactor) {
		super();
		this.imagenFactor = imagenFactor;
		this.nombreFactor = nombreFactor;
		this.unidadFactor = unidadFactor;
	}

	public int getImagenFactor() {
		return imagenFactor;
	}

	public void setImagenFactor(int imagenFactor) {
		this.imagenFactor = imagenFactor;
	}

	public String getNombreFactor() {
		return nombreFactor;
	}

	public void setNombreFactor(String nombreFactor) {
		this.nombreFactor = nombreFactor;
	}

	public String getUnidadFactor() {
		return unidadFactor;
	}

	public void setUnidadFactor(String unidadFactor) {
		this.unidadFactor = unidadFactor;
	} 
	  
	
}
