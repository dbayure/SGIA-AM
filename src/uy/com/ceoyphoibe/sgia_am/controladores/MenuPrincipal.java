package uy.com.ceoyphoibe.sgia_am.controladores;

import java.util.ArrayList;

import uy.com.ceoyphoibe.sgia_am.R;
import uy.com.ceoyphoibe.sgia_am.dto.ListaOpciones;
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

/**
 * La clase MenuPrincipal controla el activity del menu principal de la aplicación
 *
 */
public class MenuPrincipal extends Activity {
	private ListView lista;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_principal);
		//obtiene la lista de opciones
		ArrayList<ListaOpciones> opciones = new ArrayList<ListaOpciones>();
		opciones.add(new ListaOpciones(R.drawable.lupa, "Estado Placa", "Estado del sistema y de alerta"));
		opciones.add(new ListaOpciones(R.drawable.dispositivo, "Estado Dispositivos", "Estado alerta de los dispositivos"));
		opciones.add(new ListaOpciones(R.drawable.lecturas, "Lecturas", "Lecturas según factor"));
		opciones.add(new ListaOpciones(R.drawable.grupo_actuadores, "Grupos Actuadores", "Estado de Grupos de Actuadores"));
		opciones.add(new ListaOpciones(R.drawable.acciones, "Acciones", "Últimas acciones disparadas"));
		opciones.add(new ListaOpciones(R.drawable.logevento, "Logs de Eventos", "Últimos log de eventos"));
		//carga en la vista la lista de opciones
		lista = (ListView) findViewById(R.id.listViewMenuPrincipal);
		lista.setAdapter(new AdaptadorLista(this, R.layout.fragment_menu_principal, opciones) {
		@Override
		public void onEntrada(Object entrada, View view) {
			if (entrada != null) {
				TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_nombreFactor);
				if (texto_superior_entrada != null)
					texto_superior_entrada.setText(((ListaOpciones) entrada).get_textoEncima());
				TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_unidadFactor);
				if (texto_inferior_entrada != null)
					texto_inferior_entrada.setText(((ListaOpciones) entrada).get_textoDebajo());
				ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagenMenu);
				if (imagen_entrada != null)
					imagen_entrada.setImageResource(((ListaOpciones) entrada).get_idImagen());
				}
			}
		});
		//asigna la acción a disparar ante la selección de uno de los objetos de la lista pertenecientes al menu
		lista.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        
            switch (position) {
            case 0:
            	Intent newActivity0 = new Intent(MenuPrincipal.this,EstadoPlaca.class);     
            	startActivity(newActivity0);
            	break;
            case 1:
            	Intent newActivity1 = new Intent(MenuPrincipal.this,Dispositivos.class);     
            	startActivity(newActivity1);
            	break;
            case 2:
            	Intent newActivity2 = new Intent(MenuPrincipal.this,Factores.class);     
            	startActivity(newActivity2);
            	break;
            case 3:
            	Intent newActivity3 = new Intent(MenuPrincipal.this,GruposActuadores.class);     
            	startActivity(newActivity3);
            	break;
            case 4:
            	Intent newActivity4 = new Intent(MenuPrincipal.this,Acciones.class);     
            	startActivity(newActivity4);
            	break;
            case 5:
            	Intent newActivity5 = new Intent(MenuPrincipal.this,Logs.class);     
            	startActivity(newActivity5);
            	break;
            default:
              
          }
        }
      });
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_principal, menu);
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
