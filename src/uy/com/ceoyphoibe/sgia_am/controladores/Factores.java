package uy.com.ceoyphoibe.sgia_am.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import uy.com.ceoyphoibe.sgia_am.R;
import uy.com.ceoyphoibe.sgia_am.dto.ListaFactores;
import uy.com.ceoyphoibe.sgia_am.model.Factor_AM;
import uy.com.ceoyphoibe.sgia_am.ws.WS_listaFactores;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Factores extends Activity {

	private ListView lista;
	List<Factor_AM> listaFactores = new ArrayList<Factor_AM>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_factores);

		ArrayList<ListaFactores> datos = new ArrayList<ListaFactores>();
		String namespace= getString(R.string.namespace);
	    String url= getString(R.string.urlWS);
	    String method= getString(R.string.ws_listaFactores);
	    WS_listaFactores tarea = new WS_listaFactores(namespace, url, method);
	    try {
	    	final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
	    	Long idPlaca= variables.getPlaca().getId();
	    	listaFactores = tarea.execute((idPlaca)).get();

			for (Factor_AM f : listaFactores) {
				if (f.getNombre().equals("Temperatura")) 
				{
					datos.add(new ListaFactores(R.drawable.temperatura, f.getNombre(), f.getUnidad()));
				}
				else if (f.getNombre().equals("Humedad")) {
					datos.add(new ListaFactores(R.drawable.humedad, f.getNombre(), f.getUnidad()));
				}
				else if (f.getNombre().equals("Viento")) {
					datos.add(new ListaFactores(R.drawable.viento, f.getNombre(), f.getUnidad()));
				}
				else if (f.getNombre().equals("Luminosidad")) {
					datos.add(new ListaFactores(R.drawable.luminosidad, f.getNombre(), f.getUnidad()));
				}
				else if (f.getNombre().equals("Amoniaco")) {
					datos.add(new ListaFactores(R.drawable.amoniaco, f.getNombre(), f.getUnidad()));
				}
				else
					datos.add(new ListaFactores(R.drawable.lecturas, f.getNombre(), f.getUnidad()));

			}
		} catch (InterruptedException e) {
			((Throwable) e).printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	    lista = (ListView) findViewById(R.id.listViewFactores);
		lista.setAdapter(new AdaptadorLista(this, R.layout.fragment_factores, datos) {
		@Override
		public void onEntrada(Object entrada, View view) {
			if (entrada != null) {
				TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_nombreFactor);
				if (texto_superior_entrada != null)
					texto_superior_entrada.setText(((ListaFactores) entrada).getNombreFactor());
				TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_unidadFactor);
				if (texto_inferior_entrada != null)
					texto_inferior_entrada.setText(((ListaFactores) entrada).getUnidadFactor());
				ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagenMenu);
				if (imagen_entrada != null)
					imagen_entrada.setImageResource(((ListaFactores) entrada).getImagenFactor());
				}
			}
		});
		lista.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        
        	Factor_AM factorSeleccionado= listaFactores.get(position);
            final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
            variables.setFactor(factorSeleccionado);
            	
         	Intent newActivity0 = new Intent(Factores.this,Lecturas.class);     
        	startActivity(newActivity0);
        }
      });
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.factores, menu);
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
