package uy.com.ceoyphoibe.sgia_am.controladores;

import uy.com.ceoyphoibe.sgia_am.R;
import uy.com.ceoyphoibe.sgia_am.model.LogEvento_AM;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * La clase DetalleLog controla el activity para mostrar el detalle de un log de evento
 */
public class DetalleLog extends Activity {

	private TextView fechaHora;
	private TextView nombreTipoLog;
	private TextView smsMailTipoLog;
	private TextView textoMensaje;
	private TextView nombreDispositivo;
	private TextView modeloDispositivo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_log);

		final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
	    //obtiene el log de evento seleccionado para ver el detalle
		LogEvento_AM logSeleccionado= variables.getLogEvento();
	    //obtiene cada uno de los parametros del log de evento
	    fechaHora= (TextView) findViewById(R.id.detLog_fechaHora);
	    nombreTipoLog= (TextView) findViewById(R.id.detLog_nombreTipoLog);
	    smsMailTipoLog= (TextView) findViewById(R.id.detLog_smsMail);
	    textoMensaje= (TextView) findViewById(R.id.detLog_textoMensaje);
	    nombreDispositivo= (TextView) findViewById(R.id.detLog_nombreDispositivo);
	    modeloDispositivo= (TextView) findViewById(R.id.detLog_modeloDispositivo);
	    fechaHora.setText(logSeleccionado.getFechaHora().substring(0, 10) + " "+ logSeleccionado.getFechaHora().substring(11, 16));  
	    nombreTipoLog.setText(logSeleccionado.getTipoLog().getNombre());
	    String sms;
	    if (logSeleccionado.getTipoLog().getEnviarSMS().equals("S"))
	    	sms="Sí";
	    else
	    	sms="No";
	    String mail;
	    if (logSeleccionado.getTipoLog().getEnviarMail().equals("S"))
	    	mail="Sí";
	    else
	    	mail="No";
	    smsMailTipoLog.setText("SMS?: "+sms+ "  -  Mail?: "+mail);
	    textoMensaje.setText(logSeleccionado.getMensaje().getTexto());
	    nombreDispositivo.setText("Nombre: "+logSeleccionado.getDispositivo().getNombre());
	    modeloDispositivo.setText("Modelo: "+logSeleccionado.getDispositivo().getModelo());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.detalle_log, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
