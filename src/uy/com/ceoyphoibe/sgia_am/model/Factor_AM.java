package uy.com.ceoyphoibe.sgia_am.model;

import java.io.Serializable;
/**
 * La clase Factor_AM contiene la información relativa a un factor perteneciente al sistema
 */
public class Factor_AM implements Serializable {

	private static final long serialVersionUID = -3135147364907375174L;
	private Long idFactor;
	private String nombre;
	private String unidad;
	private int valorMin;
	private int valorMax;
		
	public Factor_AM() {
	}

	/**
	 * @param idFactor
	 * @param nombre
	 * @param unidad
	 * @param valorMin
	 * @param valorMax
	 */
	public Factor_AM(Long idFactor, String nombre, String unidad, int valorMin,
			int valorMax) {
		this.idFactor = idFactor;
		this.nombre = nombre;
		this.unidad = unidad;
		this.valorMin = valorMin;
		this.valorMax = valorMax;
	}

	/**
	 * @return el identificador del factor
	 */
	public Long getIdFactor() {
		return idFactor;
	}

	/**
	 * @param idFactor
	 */
	public void setIdFactor(Long idFactor) {
		this.idFactor = idFactor;
	}

	/**
	 * @return el nombre del factor
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
	 * @return la unidad de medida del factor
	 */
	public String getUnidad() {
		return unidad;
	}

	/**
	 * @param unidad
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	/**
	 * @return el valor mínimo permitido como lectura del factor
	 */
	public int getValorMin() {
		return valorMin;
	}

	/**
	 * @param valorMin
	 */
	public void setValorMin(int valorMin) {
		this.valorMin = valorMin;
	}

	/**
	 * @return el valor máximo permitido como lectura del factor
	 */
	public int getValorMax() {
		return valorMax;
	}

	/**
	 * @param valorMax
	 */
	public void setValorMax(int valorMax) {
		this.valorMax = valorMax;
	}
}