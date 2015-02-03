package uy.com.ceoyphoibe.sgia_am.dto;

/**
 * La clase ListaAcciones permite cargar los datos de una Accion para pasarlos en una lista a la vista
 */
public class ListaAcciones {

	private String fecha; 
	private String hora; 
	private String accion;
	private String nombreDispositivo;
	private String modeloDispositivo;

	public ListaAcciones(String fecha, String hora, String accion,
			String nombreDispositivo, String modeloDispositivo) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.accion = accion;
		this.nombreDispositivo = nombreDispositivo;
		this.modeloDispositivo = modeloDispositivo;
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

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getNombreDispositivo() {
		return nombreDispositivo;
	}

	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}

	public String getModeloDispositivo() {
		return modeloDispositivo;
	}

	public void setModeloDispositivo(String modeloDispositivo) {
		this.modeloDispositivo = modeloDispositivo;
	}
}
