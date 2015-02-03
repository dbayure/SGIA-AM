package uy.com.ceoyphoibe.sgia_am.model;

import java.io.Serializable;
/**
 * La clase Lectura_AM contiene los parámetros pertenecientes a una lectura de un factor perteneciente a la placa controladora
 */
public class Lectura_AM implements Serializable {

	private static final long serialVersionUID = -3135147364907375174L;
	private String fechaHora;
	private float valor;
	
	public Lectura_AM() {
	}

	/**
	 * @param fechaHora
	 * @param valor
	 */
	public Lectura_AM(String fechaHora, float valor) {
		this.fechaHora = fechaHora;
		this.valor = valor;
	}

	/**
	 * @return la fecha y hora en la que se produjo la lectura
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
	 * @return el valor obtenido en la lectura
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * @param valor
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}
}