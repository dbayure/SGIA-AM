package uy.com.ceoyphoibe.sgia_am.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import uy.com.ceoyphoibe.sgia_am.controladores.SeleccionPlaca;
import uy.com.ceoyphoibe.sgia_am.model.Placa_AM;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class WS_seleccionPlaca extends AsyncTask<String, Integer, List<Placa_AM>> {

	private String NAMESPACE = null;
	private String URL = null;
	private String METHOD_NAME = null;
	private String SOAP_ACTION = null;

	// Declaracion de variables para consumir el web service
	private SoapObject request = null;
	private SoapSerializationEnvelope envelope = null;
	//private Object resultsRequestSOAP = null;
	private Vector<SoapObject> resultsRequestSOAP = null;
	
	Context myContexto;

	public WS_seleccionPlaca(String nAMESPACE, String uRL, String mETHOD_NAME, Context contexto) {
		super();
		NAMESPACE = nAMESPACE;
		URL = uRL;
		METHOD_NAME = mETHOD_NAME;
		SOAP_ACTION = NAMESPACE+METHOD_NAME;
		
		myContexto = contexto;
		System.out.println("Parametros construidos: ");
		System.out.println("namespace: "+ NAMESPACE);
		System.out.println("url: "+ URL);
		System.out.println("method name: "+ METHOD_NAME);
		System.out.println("soap action: "+ SOAP_ACTION);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Placa_AM> doInBackground(String... arg0) {
		List<Placa_AM> listaPlacas= new ArrayList<Placa_AM>();

//		Se crea un objeto SoapObject para poder realizar la peticion
//		para consumir el ws SOAP. El constructor recibe
//		el namespace. Por lo regular el namespace es el dominio
//		donde se encuentra el web service
		request = new SoapObject(NAMESPACE, METHOD_NAME);
		
//		Se crea un objeto SoapSerializationEnvelope para serializar la
//		peticion SOAP y permitir viajar el mensaje por la nube
//		el constructor recibe la version de SOAP
		envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	
		//Se envuelve la peticion soap
		envelope.setOutputSoapObject(request);
		envelope.addMapping(NAMESPACE, "Vector<SoapObject>", new Vector<SoapObject>().getClass());

		//Objeto que representa el modelo de transporte
		//Recibe la URL del ws
		HttpTransportSE transporte = new HttpTransportSE(URL);

		try {
			//Hace la llamada al ws
			transporte.call(SOAP_ACTION, envelope);
			//Se crea un objeto SoapPrimitive y se obtiene la respuesta de la peticion
			resultsRequestSOAP = (Vector<SoapObject>)envelope.getResponse();

        	for (SoapObject s : resultsRequestSOAP)
        	{
        		Long id= Long.valueOf(s.getProperty("id").toString()) ;
        		String estado = s.getProperty("estado").toString();
        		String nroSerie= s.getProperty("nroSerie").toString();
        		String descripcion= s.getProperty("descripcion").toString();
        		String estadoAlerta= s.getProperty("estadoAlerta").toString();
        		Placa_AM p= new Placa_AM(id, estado, nroSerie, descripcion, estadoAlerta);
        		listaPlacas.add(p);
        	}

		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return listaPlacas;
	}
	
	@Override
	protected void onPostExecute(List<Placa_AM> result) {
        if (result.size() != 0) {
        	System.out.println("ok!" + result.size());
        }
        else{
        	AlertDialog.Builder dialog = new AlertDialog.Builder(myContexto);
        	dialog.setMessage("No fue posible conectarse al servidor");
        	dialog.setCancelable(false);
        	dialog.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
        		@Override
        	  public void onClick(DialogInterface dialog, int which) {
        		  ((SeleccionPlaca)(myContexto)).finish();
        		  }
        	});
        	dialog.show();
        }
    }
}