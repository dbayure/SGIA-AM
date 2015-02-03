package uy.com.ceoyphoibe.sgia_am.model;


import java.io.Serializable;
/**
 * La clase EstadosPlaca_AM contiene la información relativa al estado del sistema y el estado de alerta de la placa controladora
 */
public class EstadosPlaca_AM implements Serializable {

	private static final long serialVersionUID = -3135147364907375174L;
	private String estadoSistema;
	private String estadoAlerta;
	
	public EstadosPlaca_AM() {
	}

	/**
	 * @param estadoSistema
	 * @param estadoAlerta
	 */
	public EstadosPlaca_AM(String estadoSistema, String estadoAlerta) {
		this.estadoSistema = estadoSistema;
		this.estadoAlerta = estadoAlerta;
	}

	/**
	 * @return el estado del sistema
	 */
	public String getEstadoSistema() {
		return estadoSistema;
	}

	/**
	 * @param estadoSistema
	 */
	public void setEstadoSistema(String estadoSistema) {
		this.estadoSistema = estadoSistema;
	}

	/**
	 * @return el estado de alerta de la placa controladora
	 */
	public String getEstadoAlerta() {
		return estadoAlerta;
	}

	/**
	 * @param estadoAlerta
	 */
	public void setEstadoAlerta(String estadoAlerta) {
		this.estadoAlerta = estadoAlerta;
	}
}