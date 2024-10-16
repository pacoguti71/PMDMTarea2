package gutierrezruiz.francisco;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class DialogoAlerta extends DialogFragment {

    private String autor;
    private String version;

    // Creamos el dialogo de alerta
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inicializamos las variables con el contexto ya disponible
        autor = getString(R.string.app_author);

        try {
            // Obtener la información del paquete y la versión
            PackageInfo packageInfo = getActivity().getPackageManager()
                    .getPackageInfo(getActivity().getPackageName(), 0);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            version = "N/A"; // En caso de error
        }
        // Creamos el objeto AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Asignamos las propiedades que se mostrarán.
        builder.setTitle("Acerca de:")
                .setMessage("Aplicación desarrollada por:\n" + autor + ".\nVersión: " + version)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acciones a realizar cuando pulsamos el botón.
                        dialog.cancel();
                    }
                });

        return builder.create();
    }


}
