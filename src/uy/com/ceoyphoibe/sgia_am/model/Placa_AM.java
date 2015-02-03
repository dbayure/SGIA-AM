package uy.com.ceoyphoibe.sgia_am.model;

import java.io.Serializable;
/**
 * La clase Placa_AM contiene los parámetros relativos a una placa controladora
 */
public class Placa_AM implements Serializable {

	private static final long serialVersionUID = -3135147364907375174L;
	private Long id;
	private String estado;
	private String nroSerie;
	private String descripcion;
	private String estadoAlerta;
	
	
	public Placa_AM() {
	}
	
	/**
	 * @param id
	 * @param estado
	 * @param nroSerie
	 * @param descripcion
	 * @param estadoAlerta
	 */
	public Placa_AM(Long id, String estado, String nroSerie, String descripcion,
			String estadoAlerta) {
		this.id = id;
		this.estado = estado;
		this.nroSerie = nroSerie;
		this.descripcion = descripcion;
		this.estadoAlerta = estadoAlerta;
	}
	
	/**
	 * @return el identificador de la placa controladora
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return el estado de la placa
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
	
	/**
	 * @return el número de serie de la placa
	 */
	public String getNroSerie() {
		return nroSerie;
	}
	
	/**
	 * @param nroSerie
	 */
	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}
	
	/**
	 * @return la descripcion de la placa
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @return el estadode alerta de la placa controladora
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