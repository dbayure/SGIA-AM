package uy.com.ceoyphoibe.sgia_am.dto;

public class ListaGrupoActuadores {
	
	private int imagenGrupoActuador; 
	private String nombreGrupoActuador; 
	private String estadoGrupoActuador;
	
	public ListaGrupoActuadores(int imagenGrupoActuador,
			String nombreGrupoActuador, String estadoGrupoActuador) {
		super();
		this.imagenGrupoActuador = imagenGrupoActuador;
		this.nombreGrupoActuador = nombreGrupoActuador;
		this.estadoGrupoActuador = estadoGrupoActuador;
	}

	public int getImagenGrupoActuador() {
		return imagenGrupoActuador;
	}

	public void setImagenGrupoActuador(int imagenGrupoActuador) {
		this.imagenGrupoActuador = imagenGrupoActuador;
	}

	public String getNombreGrupoActuador() {
		return nombreGrupoActuador;
	}

	public void setNombreGrupoActuador(String nombreGrupoActuador) {
		this.nombreGrupoActuador = nombreGrupoActuador;
	}

	public String getEstadoGrupoActuador() {
		return estadoGrupoActuador;
	}

	public void setEstadoGrupoActuador(String estadoGrupoActuador) {
		this.estadoGrupoActuador = estadoGrupoActuador;
	}
	
	
	
}
