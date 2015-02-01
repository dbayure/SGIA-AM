package uy.com.ceoyphoibe.sgia_am.controladores;

import uy.com.ceoyphoibe.sgia_am.R;
import uy.com.ceoyphoibe.sgia_am.model.Placa_AM;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class EstadoPlaca extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_estado_placa);
		
		final VariablesGlobales variables= (VariablesGlobales) getApplicationContext();
		Placa_AM placa = variables.getPlaca();
		TextView descripcion = (TextView) this.findViewById(R.id.DescripcionPlaca);
		descripcion.setText(placa.getDescripcion());
		descripcion.setTypeface(null, Typeface.BOLD_ITALIC);
		TextView serie  = (TextView) this.findViewById(R.id.Serie);
		serie.setText(placa.getNroSerie());
		serie.setTypeface(null, Typeface.BOLD_ITALIC);
		TextView estado = (TextView) this.findViewById(R.id.EstadoPlaca);
		if (placa.getEstado().equals("I")){
			estado.setText("Inactivo");
			estado.setTypeface(null, Typeface.BOLD_ITALIC);
		}else{
			if (placa.getEstado().equals("C")){
				estado.setText("Configuracion");
				estado.setTypeface(null, Typeface.BOLD_ITALIC);
			}
			else{
				if (placa.getEstado().equals("M")){
					estado.setText("Manual");
					estado.setTypeface(null, Typeface.BOLD_ITALIC);
				}
				else{
					estado.setText("Automatico");
					estado.setTypeface(null, Typeface.BOLD_ITALIC);
				}
			}
		}
				
		TextView alerta = (TextView) this.findViewById(R.id.Alerta);
		if (placa.getEstadoAlerta().equals("S")){
			alerta.setText("SI");
			alerta.setTextColor(Color.RED);
			alerta.setTypeface(null, Typeface.BOLD_ITALIC);
		}
		else{
			alerta.setText("NO");
			alerta.setTextColor(Color.BLUE);
			alerta.setTypeface(null, Typeface.BOLD_ITALIC);
		}
		ImageView imgPlaca = (ImageView) this.findViewById(R.id.imageView_imagenEstadoPlaca);
		imgPlaca.setImageResource(R.drawable.placa);
		
		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.estado_placa, menu);
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
