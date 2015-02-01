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

import uy.com.ceoyphoibe.sgia_am.model.Lectura_AM;
import android.os.AsyncTask;

public class WS_listaLecturas extends AsyncTask<Long, Void, List<Lectura_AM>> {

	private String NAMESPACE = null;
	private String URL = null;
	private String METHOD_NAME = null;
	private String SOAP_ACTION = null;

	private SoapObject request = null;
	private SoapSerializationEnvelope envelope = null;
	private Vector<SoapObject> resultsRequestSOAP = null;

	public WS_listaLecturas(String nAMESPACE, String uRL, String mETHOD_NAME) {
		super();
		NAMESPACE = nAMESPACE;
		URL = uRL;
		METHOD_NAME = mETHOD_NAME;
		SOAP_ACTION = NAMESPACE+METHOD_NAME;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Lectura_AM> doInBackground(Long... arg0) {
		List<Lectura_AM> listaLecturas= new ArrayList<Lectura_AM>();
		request = new SoapObject(NAMESPACE, METHOD_NAME);
		Long idPlaca= arg0[0];
		Long idFactor= arg0[1];
		
		request.addProperty("arg0", idPlaca);
		request.addProperty("arg1", idFactor);
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
        		float valor= Float.valueOf(s.getProperty("valor").toString());
        		Lectura_AM l= new Lectura_AM(fechaHora, valor);
        		listaLecturas.add(l);
        	}
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return listaLecturas;
	}
	
	@Override
	protected void onPostExecute(List<Lectura_AM> result) {
        if (result.size() != 0)
        {
        	
        }
        else
        {
            System.out.println("Error!");
        }
    }
}
