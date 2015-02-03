package uy.com.ceoyphoibe.sgia_am.controladores;

import uy.com.ceoyphoibe.sgia_am.model.Factor_AM;
import uy.com.ceoyphoibe.sgia_am.model.LogEvento_AM;
import uy.com.ceoyphoibe.sgia_am.model.Placa_AM;
import android.app.Application;

/**
 * La clase VariablesGlobales posee y provee los métodos necesarios para manejar las variables globales necesarias en el sistema
 */
public class VariablesGlobales extends Application{
	
	private Placa_AM placa;
	private Factor_AM factor;
	private LogEvento_AM logEvento;
	
	public Placa_AM getPlaca() {
		return placa;
	}
	public void setPlaca(Placa_AM placa) {
		this.placa = placa;
	}
	public Factor_AM getFactor() {
		return factor;
	}
	public void setFactor(Factor_AM factor) {
		this.factor = factor;
	}
	public LogEvento_AM getLogEvento() {
		return logEvento;
	}
	public void setLogEvento(LogEvento_AM logEvento) {
		this.logEvento = logEvento;
	}
}
