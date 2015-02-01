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

import uy.com.ceoyphoibe.sgia_am.controladores.Mensaje;
import uy.com.ceoyphoibe.sgia_am.model.Dispositivo_AM;
import uy.com.ceoyphoibe.sgia_am.model.LogEvento_AM;
import uy.com.ceoyphoibe.sgia_am.model.TipoLogEvento_AM;
import android.os.AsyncTask;

public class WS_listaLogEventos extends AsyncTask<Long, Void, List<LogEvento_AM>> {

	private String NAMESPACE = null;
	private String URL = null;
	private String METHOD_NAME = null;
	private String SOAP_ACTION = null;

	private SoapObject request = null;
	private SoapSerializationEnvelope envelope = null;
	private Vector<SoapObject> resultsRequestSOAP = null;

	public WS_listaLogEventos(String nAMESPACE, String uRL, String mETHOD_NAME) {
		super();
		NAMESPACE = nAMESPACE;
		URL = uRL;
		METHOD_NAME = mETHOD_NAME;
		SOAP_ACTION = NAMESPACE+METHOD_NAME;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<LogEvento_AM> doInBackground(Long... arg0) {
		List<LogEvento_AM> listaLogEventos= new ArrayList<LogEvento_AM>();
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
        		Long idLogEvento= Long.valueOf(s.getProperty("idLogEvento").toString());
        		
        		SoapObject SODisp= (SoapObject) s.getProperty("dispositivo");
        		Long idDispositivo= Long.valueOf(SODisp.getProperty("idDispositivo").toString());
        		String nombre= SODisp.getProperty("nombre").toString();
        		String modelo= SODisp.getProperty("modelo").toString();
        		String estadoAlerta= SODisp.getProperty("estadoAlerta").toString();
        		Dispositivo_AM dispositivo= new Dispositivo_AM(idDispositivo, nombre, modelo, estadoAlerta);
        		
        		SoapObject SOMens= (SoapObject) s.getProperty("mensaje");
        		Long idMensaje= Long.valueOf(SOMens.getProperty("id").toString());
        		String tipoMensaje= SOMens.getProperty("tipo").toString();
        		String texto= SOMens.getProperty("texto").toString();
        		Mensaje mensaje= new Mensaje(idMensaje, tipoMensaje, texto);
        		
        		SoapObject SOTipoLog= (SoapObject) s.getProperty("tipoLog");
        		Long idTipoLogEventos= Long.valueOf(SOTipoLog.getProperty("idTipoLogEventos").toString());
        		String nombreTipoLog= SOTipoLog.getProperty("nombre").toString();
        		String enviarSMS= SOTipoLog.getProperty("enviarSMS").toString();
        		String enviarMail= SOTipoLog.getProperty("enviarMail").toString();
        		TipoLogEvento_AM tipoLog= new TipoLogEvento_AM(idTipoLogEventos, nombreTipoLog, enviarSMS, enviarMail);
   		
        		LogEvento_AM logEventoAM= new LogEvento_AM(idLogEvento, fechaHora, mensaje, tipoLog, dispositivo);
        		
        		listaLogEventos.add(logEventoAM);
        	}
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return listaLogEventos;
	}
	
	@Override
	protected void onPostExecute(List<LogEvento_AM> result) {
		 
        if (result.size() != 0)
        {
        	
        }
        else
        {
            System.out.println("Error!");
        }
    }
}
