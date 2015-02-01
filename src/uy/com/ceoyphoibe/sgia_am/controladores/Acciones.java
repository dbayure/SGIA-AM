package uy.com.ceoyphoibe.sgia_am.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import uy.com.ceoyphoibe.sgia_am.R;
import uy.com.ceoyphoibe.sgia_am.dto.ListaAcciones;
import uy.com.ceoyphoibe.sgia_am.model.Accion_AM;
import uy.com.ceoyphoibe.sgia_am.ws.WS_listaAcciones;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class Acciones extends Activity {
	
	private ListView lista;
	List<Accion_AM> listaAcciones = new ArrayList<Accion_AM>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acciones);

		final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
		
		ArrayList<ListaAcciones> datos = new ArrayList<ListaAcciones>();
		String namespace= getString(R.string.namespace);
	    String url= getString(R.string.urlWS);
	    String method= getString(R.string.ws_listaAcciones);
	    WS_listaAcciones tarea = new WS_listaAcciones(namespace, url, method);
	    try {
	    	Long idPlaca= variables.getPlaca().getId();
	    	
	    	
	    	listaAcciones = tarea.execute(idPlaca).get();
			for (Accion_AM a: listaAcciones)
			{
				String fecha= a.getFechaHora().substring(0, 10);
				String hora= a.getFechaHora().substring(11, 16);
				String accion;
				if (a.getTipoAccion().equals("A"))
					accion= "Apagado";
				else if (a.getTipoAccion().equals("E"))
					accion= "Encendido";
				else
					accion= "Posición #"+a.getTipoAccion();
				String nombreDispositivo= a.getDispositivo().getNombre();
				String modeloDispositivo= a.getDispositivo().getModelo();
				ListaAcciones temp= new ListaAcciones(fecha, hora, accion, nombreDispositivo, modeloDispositivo);
				datos.add(temp);
			}
	    	
		} catch (InterruptedException e) {
			((Throwable) e).printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	    
	    lista= (ListView) findViewById(R.id.listViewAcciones);
		lista.setAdapter(new AdaptadorLista(this, R.layout.fragment_acciones, datos) {
		@Override
		public void onEntrada(Object entrada, View view) {
			if (entrada != null) {
				TextView texto_nombreDispositivo = (TextView) view.findViewById(R.id.textViewDispositivoAccion);
				if (texto_nombreDispositivo != null)
					texto_nombreDispositivo.setText(((ListaAcciones) entrada).getNombreDispositivo());
				TextView texto_modeloDispositivo = (TextView) view.findViewById(R.id.textViewModeloDispositivoAccion);
				if (texto_modeloDispositivo != null)
					texto_modeloDispositivo.setText(((ListaAcciones) entrada).getModeloDispositivo());
				TextView texto_fecha = (TextView) view.findViewById(R.id.textViewFechaAccion);
				if (texto_fecha != null)
					texto_fecha.setText(((ListaAcciones) entrada).getFecha());
				TextView texto_hora = (TextView) view.findViewById(R.id.textViewHoraAccion);
				if (texto_hora != null)
					texto_hora.setText(((ListaAcciones) entrada).getHora());
				TextView texto_accion = (TextView) view.findViewById(R.id.textViewAccion);
				if (texto_accion != null)
					texto_accion.setText(((ListaAcciones) entrada).getAccion());
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.acciones, menu);
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
