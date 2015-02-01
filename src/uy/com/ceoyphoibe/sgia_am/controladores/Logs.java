package uy.com.ceoyphoibe.sgia_am.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import uy.com.ceoyphoibe.sgia_am.R;
import uy.com.ceoyphoibe.sgia_am.dto.ListaLogs;
import uy.com.ceoyphoibe.sgia_am.model.LogEvento_AM;
import uy.com.ceoyphoibe.sgia_am.ws.WS_listaLogEventos;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class Logs extends Activity {

	private ListView lista;
	List<LogEvento_AM> listaLogEventos = new ArrayList<LogEvento_AM>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logs);
		ArrayList<ListaLogs> datos = new ArrayList<ListaLogs>();
		String namespace= getString(R.string.namespace);
	    String url= getString(R.string.urlWS);
	    String method= getString(R.string.ws_listaLogEventos);
	    WS_listaLogEventos tarea = new WS_listaLogEventos(namespace, url, method);
	    try {
	    	final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
	    	Long idPlaca= variables.getPlaca().getId();
	    	listaLogEventos = tarea.execute((idPlaca)).get();
	    	for (LogEvento_AM l : listaLogEventos) {
	    		String nombreTipoLog= l.getTipoLog().getNombre();
	    		String fechaHora= l.getFechaHora().substring(0, 10) + " "+ l.getFechaHora().substring(11, 16);
	    		ListaLogs temp= new ListaLogs(nombreTipoLog, fechaHora);
	    		datos.add(temp);	    		
	    	}
		    
		} catch (InterruptedException e) {
			((Throwable) e).printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	    
	    lista = (ListView) findViewById(R.id.listViewLogEventos);
		lista.setAdapter(new AdaptadorLista(this, R.layout.fragment_logs, datos) {
		@Override
		public void onEntrada(Object entrada, View view) {
			if (entrada != null) {
				TextView texto_superior_entrada = (TextView) view.findViewById(R.id.nombreTipoLog);
				if (texto_superior_entrada != null)
					texto_superior_entrada.setText(((ListaLogs) entrada).getNombreTipoLog());
				TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.fechaHoraLog);
				if (texto_inferior_entrada != null)
					texto_inferior_entrada.setText(((ListaLogs) entrada).getFechaHora());
				}
			}
		});
		lista.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        
        	LogEvento_AM logSeleccionado= listaLogEventos.get(position);
            final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
            variables.setLogEvento(logSeleccionado);
            	
         	Intent newActivity0 = new Intent(Logs.this,DetalleLog.class);     
        	startActivity(newActivity0);

        }
      });
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.logs, menu);
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
