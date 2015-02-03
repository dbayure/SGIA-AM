package uy.com.ceoyphoibe.sgia_am.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import uy.com.ceoyphoibe.sgia_am.R;
import uy.com.ceoyphoibe.sgia_am.dto.ListaDispositivos;
import uy.com.ceoyphoibe.sgia_am.model.Dispositivo_AM;
import uy.com.ceoyphoibe.sgia_am.ws.WS_listaDispositivos;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * La clase Dispositivos controla el activity para mostrar la lista de dispositivos y su respectivo estado de alerta
 */
public class Dispositivos extends Activity {
	private ListView lista;
	List<Dispositivo_AM> dispositivos = new ArrayList<Dispositivo_AM>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dispositivos);
		//obtiene la lista de dispositivos desde el ws
		ArrayList<ListaDispositivos> datos = new ArrayList<ListaDispositivos>();
		String namespace= getString(R.string.namespace);
	    String url= getString(R.string.urlWS);
	    String method= getString(R.string.ws_listaDispositivos);
	    WS_listaDispositivos tarea = new WS_listaDispositivos(namespace, url, method);
		try {
			final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
	    	Long idPlaca= variables.getPlaca().getId();
			dispositivos = tarea.execute(idPlaca).get();
			for (Dispositivo_AM d : dispositivos) {
				//a partir de la lista obtenida carga la lista de datos para pasar a la vista
				if (d.getEstadoAlerta().equals("S"))
					datos.add(new ListaDispositivos(R.drawable.alertadispositivo, d.getNombre(), d.getModelo()));
				else
					datos.add(new ListaDispositivos(R.drawable.dispestadok, d.getNombre(), d.getModelo()));
			}
		} catch (InterruptedException e) {
			((Throwable) e).printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		//carga la lista de datos en la vista
		lista = (ListView) findViewById(R.id.listViewDispositivoAlerta);
		lista.setAdapter(new AdaptadorLista(this, R.layout.fragment_dispositivos, datos) {
		@Override
		public void onEntrada(Object entrada, View view) {
			if (entrada != null) {
				TextView nombre = (TextView) view.findViewById(R.id.textView_NomDispositivo);
				if (nombre != null)
					nombre.setText(((ListaDispositivos) entrada).get_NomDispositivo());
				TextView modelo = (TextView) view.findViewById(R.id.textView_ModeloDispositivo);
				if (modelo != null)
					modelo.setText(((ListaDispositivos) entrada).get_ModeloDispositivo());
				ImageView imagenAlertaDispositivo = (ImageView) view.findViewById(R.id.imagen_AlertaDispositivo);
				if (imagenAlertaDispositivo != null)
					imagenAlertaDispositivo.setImageResource(((ListaDispositivos) entrada).get_idImagenDispositivoEstado());
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.dispositivos, menu);
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
