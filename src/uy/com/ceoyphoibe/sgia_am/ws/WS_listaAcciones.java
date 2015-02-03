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

import uy.com.ceoyphoibe.sgia_am.model.Accion_AM;
import uy.com.ceoyphoibe.sgia_am.model.Dispositivo_AM;
import android.os.AsyncTask;

/**
 * La clase WS_listaAcciones es una tarea asíncrona que se utiliza para invocar el servicio web mediante el que se obtiene la lista con las últimas diez acciones disparadas
 */
public class WS_listaAcciones extends AsyncTask<Long, Void, List<Accion_AM>> {

	private String NAMESPACE = null;
	private String URL = null;
	private String METHOD_NAME = null;
	private String SOAP_ACTION = null;

	private SoapObject request = null;
	private SoapSerializationEnvelope envelope = null;
	private Vector<SoapObject> resultsRequestSOAP = null;

	public WS_listaAcciones(String nAMESPACE, String uRL, String mETHOD_NAME) {
		super();
		NAMESPACE = nAMESPACE;
		URL = uRL;
		METHOD_NAME = mETHOD_NAME;
		SOAP_ACTION = NAMESPACE+METHOD_NAME;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Accion_AM> doInBackground(Long... arg0) {
		List<Accion_AM> listaAcciones= new ArrayList<Accion_AM>();
		request = new SoapObject(NAMESPACE, METHOD_NAME);
		Long idPlaca= arg0[0];
		
		request.addProperty("arg0", idPlaca);
		envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		envelope.addMapping(NAMESPACE, "Vector<SoapObject>", new Vector<SoapObject>().getClass());
		HttpTransportSE transporte = new HttpTransportSE(URL);
		try {
			transporte.call(SOAP_ACTION, envelope);
			resultsRequestSOAP = (Vector<SoapObject>)envelope.getResponse();
        	for (SoapObject s : resultsRequestSOAP)
        	{
        		String fechaHora = s.getProperty("fechaHora").toString();
        		String tipoAccion= s.getProperty("tipoAccion").toString();
        		SoapObject SODisp= (SoapObject) s.getProperty("dispositivo");
        		Long idDispositivo= Long.valueOf(SODisp.getProperty("idDispositivo").toString());
        		String nombre= SODisp.getProperty("nombre").toString();
        		String modelo= SODisp.getProperty("modelo").toString();
        		String estadoAlerta= SODisp.getProperty("estadoAlerta").toString();
        		Dispositivo_AM dispositivo= new Dispositivo_AM(idDispositivo, nombre, modelo, estadoAlerta);
        		Accion_AM accion= new Accion_AM(fechaHora, tipoAccion, dispositivo);
        		
        		listaAcciones.add(accion);
        	}
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return listaAcciones;
	}
	
	@Override
	protected void onPostExecute(List<Accion_AM> result) {
        if (result.size() != 0)
        {
        	
        }
        else
        {
            System.out.println("Error!");
        }
    }
}
