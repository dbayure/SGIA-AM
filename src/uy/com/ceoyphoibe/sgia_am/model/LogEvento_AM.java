package uy.com.ceoyphoibe.sgia_am.model;

import java.io.Serializable;

/**
 * La clase LogEvento_AM contiene los parámetros pertenecientes a un log de evento generado
 */
public class LogEvento_AM implements Serializable {


	private static final long serialVersionUID = -3135147364907375174L;
	private Long idLogEvento;
	private String fechaHora;
	private Mensaje mensaje;
	private TipoLogEvento_AM tipoLog;
	private Dispositivo_AM dispositivo;
	
	public LogEvento_AM() {
	}

	/**
	 * @param idLogEvento
	 * @param fechaHora
	 * @param mensaje
	 * @param tipoLog
	 */
	public LogEvento_AM(Long idLogEvento, String fechaHora, Mensaje mensaje,
			TipoLogEvento_AM tipoLog, Dispositivo_AM dispositivo) {
		this.idLogEvento = idLogEvento;
		this.fechaHora = fechaHora;
		this.mensaje = mensaje;
		this.tipoLog = tipoLog;
		this.dispositivo=dispositivo;
	}

	/**
	 * @return el identificador del log de evento
	 */
	public Long getIdLogEvento() {
		return idLogEvento;
	}

	/**
	 * @param idLogEvento
	 */
	public void setIdLogEvento(Long idLogEvento) {
		this.idLogEvento = idLogEvento;
	}

	/**
	 * @return la fecha y hora en la que se produjo el log de evento
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
	 * @return el mensaje asociado al log de evento
	 */
	public Mensaje getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 */
	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return el tipo de log de evento al que pertenece el log de evento
	 */
	public TipoLogEvento_AM getTipoLog() {
		return tipoLog;
	}

	/**
	 * @param tipoLog
	 */
	public void setTipoLog(TipoLogEvento_AM tipoLog) {
		this.tipoLog = tipoLog;
	}

	/**
	 * @return el dispositivo que generó el log de evento
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
