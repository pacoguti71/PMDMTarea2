package gutierrezruiz.francisco;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2024/10/16
 *
 * Muestra los detalles de un personaje.
 */
public class DetallesPersonajeActivity extends AppCompatActivity {

    /**
     * Método On create.
     *
     * @param savedInstanceState el estado de la instancia guardada
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Establecemos el diseño de la pantalla secundaria
        setContentView(R.layout.activity_detalles_personaje);

        // Configuramos la barra de herramientas
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Manejamos los insets para evitar superposición con la barra de estado o de navegación
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtenemos las referencias a los elementos de la UI
        TextView nombrePersonajeTextView = findViewById(R.id.nombrePersonaje);
        ImageView imagenPersonajeImageView = findViewById(R.id.imagenPersonaje);
        TextView descripcionPersonajeTextView = findViewById(R.id.descripcionPersonaje);
        TextView habilidadPersonajeTextView = findViewById(R.id.habilidadPersonaje);

        // Obtenemos los datos pasados a través del intent
        Intent intent = getIntent();
        String nombrePersonaje = intent.getStringExtra("nombrePersonaje");
        int imagenPersonajeId = intent.getIntExtra("imagenPersonaje", -1);
        String descripcionPersonaje = intent.getStringExtra("descripcionPersonaje");
        String habilidadPersonaje = intent.getStringExtra("habilidadPersonaje");

        // Asignamos los datos a los elementos visuales
        nombrePersonajeTextView.setText(nombrePersonaje);
        if (imagenPersonajeId != -1) {
            // Si la imagen existe
            imagenPersonajeImageView.setImageResource(imagenPersonajeId);
        }
        descripcionPersonajeTextView.setText(descripcionPersonaje);
        habilidadPersonajeTextView.setText(habilidadPersonaje);

        // Cuando el usuario pulsa el botón de retroceso (callback)
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            // Hará esto:
            public void handleOnBackPressed() {
                // Navegar hacia la actividad padre
                // En el AndroidManifest hemos incluido estas líneas en DetallesPersonajeActivity
                //       android:name=".DetallesPersonajeActivity"
                //       android:parentActivityName=".MainActivity"
                NavUtils.navigateUpFromSameTask(DetallesPersonajeActivity.this);
            }
        };

        // Le decimos a Android (Dispatcher) que ejecute la función definida en el callback
        getOnBackPressedDispatcher().addCallback(this, callback);

    }
}