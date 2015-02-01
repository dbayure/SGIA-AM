package uy.com.ceoyphoibe.sgia_am.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import uy.com.ceoyphoibe.sgia_am.R;
import uy.com.ceoyphoibe.sgia_am.dto.ListaPlacas;
import uy.com.ceoyphoibe.sgia_am.model.Placa_AM;
import uy.com.ceoyphoibe.sgia_am.ws.WS_seleccionPlaca;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SeleccionPlaca extends Activity {
	private ListView lista;
	List<Placa_AM> listaPlacas = new ArrayList<Placa_AM>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seleccion_placa);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		ArrayList<ListaPlacas> datos = new ArrayList<ListaPlacas>();
		String namespace= getString(R.string.namespace);
	    String url= getString(R.string.urlWS);
	    String method= getString(R.string.ws_listaPlacas);
	    WS_seleccionPlaca tarea = new WS_seleccionPlaca(namespace, url, method, this);
		try {
			listaPlacas = tarea.execute().get();
			for (Placa_AM p : listaPlacas) {
				datos.add(new ListaPlacas(R.drawable.placa, p.getDescripcion(), p.getNroSerie()));
			}
		} catch (InterruptedException e) {
			((Throwable) e).printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		lista = (ListView) findViewById(R.id.listViewPlacas);
		lista.setAdapter(new AdaptadorLista(this, R.layout.fragment_vista_placa, datos) {
		@Override
		public void onEntrada(Object entrada, View view) {
			if (entrada != null) {
				TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
				if (texto_superior_entrada != null)
					texto_superior_entrada.setText(((ListaPlacas) entrada).get_textoEncima());
				TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
				if (texto_inferior_entrada != null)
					texto_inferior_entrada.setText(((ListaPlacas) entrada).get_textoDebajo());
				ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
				if (imagen_entrada != null)
					imagen_entrada.setImageResource(((ListaPlacas) entrada).get_idImagen());
				}
			}
		});
		lista.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        
            Placa_AM placaSeleccionada= listaPlacas.get(position);
            final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
            variables.setPlaca(placaSeleccionada);
         	Intent newActivity0 = new Intent(SeleccionPlaca.this,MenuPrincipal.class);     
        	startActivity(newActivity0);
        }
      });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.seleccion_placa, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_seleccion_placa,
					container, false);
			return rootView;
		}
	}
}
