package gutierrezruiz.francisco;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;


    public class DialogoAlerta extends DialogFragment {

        private ArrayList<Personaje> misPersonajes = new ArrayList<>(); // Inicializa la lista aquí.

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Creamos el objeto AlertDialog.Builder
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            // Asignamos las propiedades que se mostrarán.
            builder.setTitle("Importante")
                    .setMessage("Debes leer este mensaje.")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Acciones a realizar cuando pulsamos el botón.
                            dialog.cancel();
                        }
                    });

            return builder.create();
        }




    }
