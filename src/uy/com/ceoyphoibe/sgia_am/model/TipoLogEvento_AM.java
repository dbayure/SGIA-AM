package uy.com.ceoyphoibe.sgia_am.model;

import java.io.Serializable;
/**
 * La clase TipoLogEvento_AM contiene los parámetros relativos a un tipo de log de eventos
 */
public class TipoLogEvento_AM implements Serializable {

	private static final long serialVersionUID = -3135147364907375174L;
	private Long idTipoLogEventos;
	private String nombre;
	private String enviarSMS;
	private String enviarMail;
	
	public TipoLogEvento_AM() {
	}

	/**
	 * @param idTipoLogEventos
	 * @param nombre
	 * @param enviarSMS
	 * @param enviarMail
	 */
	public TipoLogEvento_AM(Long idTipoLogEventos, String nombre,
			String enviarSMS, String enviarMail) {
		this.idTipoLogEventos = idTipoLogEventos;
		this.nombre = nombre;
		this.enviarSMS = enviarSMS;
		this.enviarMail = enviarMail;
	}

	/**
	 * @return el identificador del tipo de log de eventos
	 */
	public Long getIdTipoLogEventos() {
		return idTipoLogEventos;
	}

	/**
	 * @param idTipoLogEventos
	 */
	public void setIdTipoLogEventos(Long idTipoLogEventos) {
		this.idTipoLogEventos = idTipoLogEventos;
	}

	/**
	 * @return el nombre del tipo de log de eventos
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el indicador si corresponde enviar notificación por SMS
	 */
	public String getEnviarSMS() {
		return enviarSMS;
	}

	/**
	 * @param enviarSMS
	 */
	public void setEnviarSMS(String enviarSMS) {
		this.enviarSMS = enviarSMS;
	}

	/**
	 * @return el indicador si corresponde enviar notificación por Mail
	 */
	public String getEnviarMail() {
		return enviarMail;
	}

	/**
	 * @param enviarMail
	 */
	public void setEnviarMail(String enviarMail) {
		this.enviarMail = enviarMail;
	}
}
