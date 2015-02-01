package uy.com.ceoyphoibe.sgia_am.dto;

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
