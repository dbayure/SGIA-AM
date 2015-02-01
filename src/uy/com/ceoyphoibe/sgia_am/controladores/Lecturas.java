package uy.com.ceoyphoibe.sgia_am.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import uy.com.ceoyphoibe.sgia_am.R;
import uy.com.ceoyphoibe.sgia_am.dto.ListaLecturas;
import uy.com.ceoyphoibe.sgia_am.model.Factor_AM;
import uy.com.ceoyphoibe.sgia_am.model.Lectura_AM;
import uy.com.ceoyphoibe.sgia_am.ws.WS_listaLecturas;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Lecturas extends Activity {

	private ListView lista;
	List<Lectura_AM> listaLecturas = new ArrayList<Lectura_AM>();
	private ImageView imagenFactor;
	private TextView nombreFactor;
	private TextView unidadFactor;
	private TextView limitesFactor;
	
	@SuppressLint("DefaultLocale")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lecturas);

		imagenFactor= (ImageView) findViewById(R.id.imagenFactorLectura);
		nombreFactor= (TextView) findViewById(R.id.nombreFactorLectura);
		unidadFactor= (TextView) findViewById(R.id.unidadFactorLectura);
		limitesFactor= (TextView) findViewById(R.id.limitesFactorLectura);
		final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
		Factor_AM factorSeleccionado= variables.getFactor();
		nombreFactor.setText(factorSeleccionado.getNombre());
		unidadFactor.setText("Unidad: "+factorSeleccionado.getUnidad());
		limitesFactor.setText("Mín: "+String.valueOf(factorSeleccionado.getValorMin())+"  -  Máx: "+String.valueOf(factorSeleccionado.getValorMax()));
		if (factorSeleccionado.getNombre().equals("Temperatura"))
			imagenFactor.setImageResource(R.drawable.temperatura);
		else if (factorSeleccionado.getNombre().equals("Humedad"))
			imagenFactor.setImageResource(R.drawable.humedad);
		else if (factorSeleccionado.getNombre().equals("Viento"))
			imagenFactor.setImageResource(R.drawable.viento);
		else if (factorSeleccionado.getNombre().equals("Luminosidad"))
			imagenFactor.setImageResource(R.drawable.luminosidad);
		else if (factorSeleccionado.getNombre().equals("Amoniaco"))
			imagenFactor.setImageResource(R.drawable.amoniaco);
		
		ArrayList<ListaLecturas> datos = new ArrayList<ListaLecturas>();
		String namespace= getString(R.string.namespace);
	    String url= getString(R.string.urlWS);
	    String method= getString(R.string.ws_listaLecturas);
	    WS_listaLecturas tarea = new WS_listaLecturas(namespace, url, method);
	    try {
	    	Long idPlaca= variables.getPlaca().getId();
	    	Long idFactor= variables.getFactor().getIdFactor();
	    	Long[] parametros={idPlaca, idFactor};
	    	listaLecturas = tarea.execute(parametros).get();
			for (Lectura_AM l: listaLecturas)
			{
				String fecha= l.getFechaHora().substring(0, 10);
				String hora= l.getFechaHora().substring(11, 16);
				String valor= String.format("%.2f", l.getValor());
				ListaLecturas temp= new ListaLecturas(fecha, hora, valor);
				datos.add(temp);
			}
		} catch (InterruptedException e) {
			((Throwable) e).printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	    
	    lista= (ListView) findViewById(R.id.listaLecturas);
		lista.setAdapter(new AdaptadorLista(this, R.layout.fragment_lecturas, datos) {
		@Override
		public void onEntrada(Object entrada, View view) {
			if (entrada != null) {
				TextView texto_superior_entrada = (TextView) view.findViewById(R.id.fragFechaLectura);
				if (texto_superior_entrada != null)
					texto_superior_entrada.setText(((ListaLecturas) entrada).getFecha());
				TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.fragHoraLectura);
				if (texto_inferior_entrada != null)
					texto_inferior_entrada.setText(((ListaLecturas) entrada).getHora());
				TextView texto_valor = (TextView) view.findViewById(R.id.fragValorLectura);
				if (texto_valor != null)
					texto_valor.setText(((ListaLecturas) entrada).getValor());
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lecturas, menu);
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
