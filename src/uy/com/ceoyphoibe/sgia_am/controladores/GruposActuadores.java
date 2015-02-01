package uy.com.ceoyphoibe.sgia_am.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import uy.com.ceoyphoibe.sgia_am.R;
import uy.com.ceoyphoibe.sgia_am.dto.ListaGrupoActuadores;
import uy.com.ceoyphoibe.sgia_am.model.GrupoActuador_AM;
import uy.com.ceoyphoibe.sgia_am.ws.WS_listaGrupoActuadores;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class GruposActuadores extends Activity {
	
	private ListView lista;
	List<GrupoActuador_AM> listaGrupos = new ArrayList<GrupoActuador_AM>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grupos_actuadores);

		ArrayList<ListaGrupoActuadores> datos = new ArrayList<ListaGrupoActuadores>();
		String namespace= getString(R.string.namespace);
	    String url= getString(R.string.urlWS);
	    String method= getString(R.string.ws_listaGrupoActuadores);
	    WS_listaGrupoActuadores tarea = new WS_listaGrupoActuadores(namespace, url, method);
	    try {
	    	final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
	    	Long idPlaca= variables.getPlaca().getId();
	    	listaGrupos = tarea.execute(idPlaca).get();
			for (GrupoActuador_AM g : listaGrupos) {
				String estado;
				if (g.getEstado().equals("E"))
					estado= "Encendido";
				else if (g.getEstado().equals("A"))
					estado= "Apagado";
				else
					estado= "Pos.: "+g.getEstado();
				if (g.getNombre().matches("(.*)Ventiladores(.*)") )
				{
					datos.add(new ListaGrupoActuadores(R.drawable.ventiladores, g.getNombre(), estado));
				}
				else if (g.getNombre().matches("(.*)Luces(.*)") ) {
					datos.add(new ListaGrupoActuadores(R.drawable.luces, g.getNombre(), estado));
				}
				else if (g.getNombre().matches("(.*)Aspersores(.*)") ) {
					datos.add(new ListaGrupoActuadores(R.drawable.aspersor, g.getNombre(), estado));
				}
				else if (g.getNombre().matches("(.*)Extractores(.*)") ) {
					datos.add(new ListaGrupoActuadores(R.drawable.extractor, g.getNombre(), estado));
				}
				else if (g.getNombre().matches("(.*)Cortinas(.*)") ) {
					datos.add(new ListaGrupoActuadores(R.drawable.cortina, g.getNombre(), estado));
				}
				else
					datos.add(new ListaGrupoActuadores(R.drawable.grupo_actuadores, g.getNombre(), estado));

			}
		} catch (InterruptedException e) {
			((Throwable) e).printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	    lista = (ListView) findViewById(R.id.listViewGruposActuadores);
		lista.setAdapter(new AdaptadorLista(this, R.layout.fragment_grupos_actuadores, datos) {
		@Override
		public void onEntrada(Object entrada, View view) {
			if (entrada != null) {
				TextView texto_superior_entrada = (TextView) view.findViewById(R.id.nombreGrupoActuadores);
				if (texto_superior_entrada != null)
					texto_superior_entrada.setText(((ListaGrupoActuadores) entrada).getNombreGrupoActuador());
				TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.estadoGrupoActuadores);
				if (texto_inferior_entrada != null)
					texto_inferior_entrada.setText(((ListaGrupoActuadores) entrada).getEstadoGrupoActuador());
				ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageViewGrupoActuadores);
				if (imagen_entrada != null)
					imagen_entrada.setImageResource(((ListaGrupoActuadores) entrada).getImagenGrupoActuador());
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.grupos_actuadores, menu);
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
