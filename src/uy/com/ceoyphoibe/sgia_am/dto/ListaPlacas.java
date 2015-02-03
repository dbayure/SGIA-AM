package uy.com.ceoyphoibe.sgia_am.dto;

/**
 * La clase ListaPlacas permite cargar los datos de una Placa para pasarlos en una lista a la vista
 */
public class ListaPlacas {
	
	private int imagenPlaca; 
	private String tituloPlaca; 
	private String descripcionPlaca; 
	  
	public ListaPlacas (int idImagen, String titulo, String desc) { 
	    this.imagenPlaca = idImagen; 
	    this.tituloPlaca = titulo; 
	    this.descripcionPlaca = desc; 
	}
	
	public String get_textoEncima() { 
	    return tituloPlaca; 
	}
	
	public String get_textoDebajo() { 
	    return descripcionPlaca; 
	}
	
	public int get_idImagen() {
	    return imagenPlaca; 
	} 
}
