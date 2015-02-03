package uy.com.ceoyphoibe.sgia_am.dto;

/**
 * La clase ListaDispositivos permite cargar los datos de un Dispositivo para pasarlos en una lista a la vista
 */
public class ListaDispositivos {
	
	private int imagenEstado; 
	private String nomDispositivo; 
	private String modeloDispositivo; 
	  
	public ListaDispositivos (int idImagen, String titulo, String desc) { 
	    this.imagenEstado = idImagen; 
	    this.nomDispositivo = titulo; 
	    this.modeloDispositivo = desc; 
	}
	
	public String get_NomDispositivo() { 
	    return nomDispositivo; 
	}
	
	public String get_ModeloDispositivo() { 
	    return modeloDispositivo; 
	}
	
	public int get_idImagenDispositivoEstado() {
	    return imagenEstado; 
	} 
}
