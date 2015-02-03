package uy.com.ceoyphoibe.sgia_am.dto;

/**
 * La clase ListaOpciones permite cargar los datos de cada elemento del menu principal para pasarlos como una lista a la vista
 */
public class ListaOpciones {
	
	private int imagenOpcion; 
	private String tituloOpcion; 
	private String descripcionOpcion; 
	  
	public ListaOpciones (int idImagen, String titulo, String desc) { 
	    this.imagenOpcion = idImagen; 
	    this.tituloOpcion = titulo; 
	    this.descripcionOpcion = desc; 
	}
	
	public String get_textoEncima() { 
	    return tituloOpcion; 
	}
	
	public String get_textoDebajo() { 
	    return descripcionOpcion; 
	}
	
	public int get_idImagen() {
	    return imagenOpcion; 
	} 
}
