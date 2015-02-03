package uy.com.ceoyphoibe.sgia_am.model;

import java.io.Serializable;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 8487567124541697125L;
	private Long id;
	private String tipo;
	private String texto;

	public Mensaje() {
		super();
	}

	public Mensaje(Long id, String tipo, String texto) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.texto = texto;
	}

	/**
	 * @return el identificador del mensaje.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * 			El identificador a asignar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el tipo de mensaje (Error, Advertencia ó Informativo)
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 * 			El tipo de mensaje a asignar.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return el texto del mensaje.
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto
	 * 			El texto a asignar.
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}