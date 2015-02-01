package uy.com.ceoyphoibe.sgia_am.ws;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import uy.com.ceoyphoibe.sgia_am.model.EstadosPlaca_AM;
import android.os.AsyncTask;

public class WS_estadosPlaca extends AsyncTask<Long, Void, EstadosPlaca_AM> {

	private String NAMESPACE = null;
	private String URL = null;
	private String METHOD_NAME = null;
	private String SOAP_ACTION = null;

	private SoapObject request = null;
	private SoapSerializationEnvelope envelope = null;

	private SoapObject resultsRequestSOAP = null;
	
	

	public WS_estadosPlaca(String nAMESPACE, String uRL, String mETHOD_NAME) {
		super();
		NAMESPACE = nAMESPACE;
		URL = uRL;
		METHOD_NAME = mETHOD_NAME;
		SOAP_ACTION = NAMESPACE+METHOD_NAME;
	}

	@Override
	protected EstadosPlaca_AM doInBackground(Long... arg0) {
		EstadosPlaca_AM estados= new EstadosPlaca_AM();
		request = new SoapObject(NAMESPACE, METHOD_NAME);
		Long idPlaca= arg0[0];
		
		request.addProperty("arg0", idPlaca);
		envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		envelope.addMapping(NAMESPACE, "SoapObject", new SoapObject().getClass());
		HttpTransportSE transporte = new HttpTransportSE(URL);
		try {
			transporte.call(SOAP_ACTION, envelope);
			resultsRequestSOAP = (SoapObject)envelope.getResponse();
        	
        	String estado = resultsRequestSOAP.getProperty("estadoSistema").toString();
        	String alerta= resultsRequestSOAP.getProperty("estadoAlerta").toString();
        	estados.setEstadoSistema(estado);
        	estados.setEstadoAlerta(alerta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
		return estados;
	}
	
	@Override
	protected void onPostExecute(EstadosPlaca_AM result) {
		 
        if (result != null)
        {
        	
        }
        else
        {
            System.out.println("Error!");
        }
    }

}
