package uy.com.ceoyphoibe.sgia_am.dto;

/**
 * La clase ListaLogs permite cargar los datos de un Log para pasarlos en una lista a la vista
 */
public class ListaLogs {
	
	private String nombreTipoLog; 
	private String fechaHora;
	
	public ListaLogs(String nombreTipoLog, String fechaHora) {
		super();
		this.nombreTipoLog = nombreTipoLog;
		this.fechaHora = fechaHora;
	}

	public String getNombreTipoLog() {
		return nombreTipoLog;
	}

	public void setNombreTipoLog(String nombreTipoLog) {
		this.nombreTipoLog = nombreTipoLog;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	} 
	
	
	
}
