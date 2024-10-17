package gutierrezruiz.francisco;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2024/10/16
 *
 * Muestra un diálogo de alerta mostrando información sobre la aplicación.
 */
public class DialogoAlerta extends DialogFragment {

    private String autor; // autor de la aplicación
    private String versionName; // Versión de la aplicación

    /**
     * Diálogo On create dialog
     *
     * @param savedInstanceState el estado de la instancia guardada
     * @return el diálogo
     */
    // Creamos el dialogo de alerta
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inicializamos las variables con el contexto ya disponible
        autor = getString(R.string.app_author);

        try {
            // Obtener la información del paquete y la versión
            PackageInfo packageInfo = getActivity().getPackageManager()
                    .getPackageInfo(getActivity().getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            versionName = getString(R.string.version0); // En caso de error
        }

        // Creamos el objeto AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String titulo = getActivity().getString(R.string.acercade);
        String opcionAceptar = getActivity().getString(R.string.aceptar);
        String mensaje = getString(R.string.mensaje_acerca_de, autor, versionName);


        // Estabecemos el título del diálogo
        builder.setTitle(titulo)
                // Establecemos el mensaje del diálogo y cuando pulsamos el botón
                .setMessage(mensaje).setPositiveButton(opcionAceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cerramos el diálogo.
                        dialog.cancel();
                    }
                });
        // Devolvemos el diálogo creado
        return builder.create();
    }
}
