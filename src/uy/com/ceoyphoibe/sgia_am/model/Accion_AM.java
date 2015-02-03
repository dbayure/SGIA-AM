package uy.com.ceoyphoibe.sgia_am.model;

import java.io.Serializable;
/**
 * La clase Accion_AM contiene la información relativa a una acción disparada por la placa controladora
 */
public class Accion_AM implements Serializable {

	private static final long serialVersionUID = -3135147364907375174L;
	private String fechaHora;
	private String tipoAccion;
	private Dispositivo_AM dispositivo;
	
	public Accion_AM() {
		
	}

	/**
	 * @param fechaHora
	 * @param tipoAccion
	 * @param dispositivo
	 */
	public Accion_AM(String fechaHora, String tipoAccion,
			Dispositivo_AM dispositivo) {
		this.fechaHora = fechaHora;
		this.tipoAccion = tipoAccion;
		this.dispositivo = dispositivo;
	}

	/**
	 * @return la fecha y hora en la que se produjo la acción
	 */
	public String getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora 
	 */
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return el tipo de acción que se produjo
	 */
	public String getTipoAccion() {
		return tipoAccion;
	}

	/**
	 * @param tipoAccion
	 */
	public void setTipoAccion(String tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	/**
	 * @return el dispositivo sobre el que se disparó la acción
	 */
	public Dispositivo_AM getDispositivo() {
		return dispositivo;
	}

	/**
	 * @param dispositivo
	 */
	public void setDispositivo(Dispositivo_AM dispositivo) {
		this.dispositivo = dispositivo;
	}
}