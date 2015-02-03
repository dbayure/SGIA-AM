package uy.com.ceoyphoibe.sgia_am.model;

import java.io.Serializable;
/**
 * La clase GrupoActuador_AM contiene los datos relativos a un grupo de actuadores perteneciente a la placa controladora
 */
public class GrupoActuador_AM implements Serializable {

	private static final long serialVersionUID = -3135147364907375174L;
	private String nombre;
	private String estado;

	public GrupoActuador_AM() {
	}

	/**
	 * @param nombre
	 * @param estado
	 */
	public GrupoActuador_AM(String nombre, String estado) {
		this.nombre = nombre;
		this.estado = estado;
	}

	/**
	 * @return el nombre del grupo de actuadores
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
	 * @return el estado actual del grupo de actuadores
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
}