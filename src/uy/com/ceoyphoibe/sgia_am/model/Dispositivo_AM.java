package uy.com.ceoyphoibe.sgia_am.model;

import java.io.Serializable;
/**
 * La clase Dispositivo_AM contiene la información relativa a un dispositivo perteneciente a la placa controladora
 */
public class Dispositivo_AM implements Serializable {

	private static final long serialVersionUID = -3135147364907375174L;
	private Long idDispositivo;
	private String nombre;
	private String modelo;
	private String estadoAlerta;
	
	public Dispositivo_AM() {		
	}

	/**
	 * @param idDispositivo
	 * @param nombre
	 * @param modelo
	 * @param estadoAlerta
	 */
	public Dispositivo_AM(Long idDispositivo, String nombre, String modelo,
			String estadoAlerta) {
		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
		this.modelo = modelo;
		this.estadoAlerta = estadoAlerta;
	}

	/**
	 * @return el identificador del dispositivo
	 */
	public Long getIdDispositivo() {
		return idDispositivo;
	}

	/**
	 * @param idDispositivo
	 */
	public void setIdDispositivo(Long idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	/**
	 * @return el nombre del dispositivo
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
	 * @return el modelo del dispositivo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return el estado de alerta del dispositivo
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