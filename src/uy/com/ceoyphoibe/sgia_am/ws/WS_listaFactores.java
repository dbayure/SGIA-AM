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

import uy.com.ceoyphoibe.sgia_am.model.Factor_AM;
import android.os.AsyncTask;

/**
 * La clase WS_listaFactores es una tarea asíncrona que se utiliza para invocar el servicio web mediante el que se obtiene la lista de factores
 */
public class WS_listaFactores extends AsyncTask<Long, Void, List<Factor_AM>> {

	private String NAMESPACE = null;
	private String URL = null;
	private String METHOD_NAME = null;
	private String SOAP_ACTION = null;

	private SoapObject request = null;
	private SoapSerializationEnvelope envelope = null;
	private Vector<SoapObject> resultsRequestSOAP = null;
	
	public WS_listaFactores(String nAMESPACE, String uRL, String mETHOD_NAME) {
		super();
		NAMESPACE = nAMESPACE;
		URL = uRL;
		METHOD_NAME = mETHOD_NAME;
		SOAP_ACTION = NAMESPACE+METHOD_NAME;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Factor_AM> doInBackground(Long... arg0) {
		List<Factor_AM> listaFactores= new ArrayList<Factor_AM>();
		request = new SoapObject(NAMESPACE, METHOD_NAME);
		Long idPlaca= arg0[0];
		System.out.println("Recibe como parametro el id: "+idPlaca);
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
        		Long idFactor= Long.valueOf(s.getProperty("idFactor").toString()) ;
        		String nombre = s.getProperty("nombre").toString();
        		String unidad= s.getProperty("unidad").toString();
        		int valorMin= Integer.parseInt(s.getProperty("valorMin").toString());
        		int valorMax= Integer.parseInt(s.getProperty("valorMax").toString());
        		Factor_AM f= new Factor_AM(idFactor, nombre, unidad, valorMin, valorMax);
        		listaFactores.add(f);
        	}
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return listaFactores;
	}
	
	@Override
	protected void onPostExecute(List<Factor_AM> result) {
        if (result.size() != 0)
        {
        	
        }
        else
        {
            System.out.println("Error!");
        }
    }

}
