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

import uy.com.ceoyphoibe.sgia_am.model.Dispositivo_AM;
import android.os.AsyncTask;

public class WS_listaDispositivos extends AsyncTask<Long, Void, List<Dispositivo_AM>> {

	private String NAMESPACE = null;
	private String URL = null;
	private String METHOD_NAME = null;
	private String SOAP_ACTION = null;

	private SoapObject request = null;
	private SoapSerializationEnvelope envelope = null;
	private Vector<SoapObject> resultsRequestSOAP = null;

	public WS_listaDispositivos(String nAMESPACE, String uRL, String mETHOD_NAME) {
		super();
		NAMESPACE = nAMESPACE;
		URL = uRL;
		METHOD_NAME = mETHOD_NAME;
		SOAP_ACTION = NAMESPACE+METHOD_NAME;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Dispositivo_AM> doInBackground(Long... arg0) {
		List<Dispositivo_AM> listaDispositivos= new ArrayList<Dispositivo_AM>();
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
        		Long idDispositivo= Long.valueOf(s.getProperty("idDispositivo").toString()) ;
        		String nombre = s.getProperty("nombre").toString();
        		String modelo = s.getProperty("modelo").toString();
        		String estadoAlerta = s.getProperty("estadoAlerta").toString();
        		Dispositivo_AM d = new Dispositivo_AM(idDispositivo, nombre, modelo, estadoAlerta);
        		listaDispositivos.add(d);
        	}
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return listaDispositivos;
	}
	
	@Override
	protected void onPostExecute(List<Dispositivo_AM> result) {
        if (result.size() != 0)
        {
        	
        }
        else
        {
            System.out.println("Error!");
        }
    }

}
