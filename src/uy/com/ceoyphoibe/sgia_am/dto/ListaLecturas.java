package uy.com.ceoyphoibe.sgia_am.dto;

public class ListaLecturas {
	
	private String fecha; 
	private String hora; 
	private String valor;
	
	public ListaLecturas(String fecha, String hora, String valor) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.valor = valor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
}
