package uy.com.ceoyphoibe.sgia_am.controladores;

import uy.com.ceoyphoibe.sgia_am.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
 

/**
 * Manejador de los diálogos desplegados al usuario
 */
public class AlertDialogManager {
	
    @SuppressWarnings("deprecation")
	public void showAlertDialog(Context context, String title, String message,
            Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
 
        alertDialog.setTitle(title);
 
        alertDialog.setMessage(message);
        if(status != null)
            alertDialog.setIcon((status) ? R.drawable.placa : R.drawable.exit);
 
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }
}