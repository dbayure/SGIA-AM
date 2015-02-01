package uy.com.ceoyphoibe.sgia_am.dto;

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
