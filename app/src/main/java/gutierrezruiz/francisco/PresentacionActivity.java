package gutierrezruiz.francisco;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class PresentacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);

        // Mostramos la pantalla splash durante 3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Después de 3 segundos, lanzamos la actividad principal
                Intent intent = new Intent(PresentacionActivity.this, PrincipalActivity.class);
                startActivity(intent);
                // Finaliza esta actividad para que no vuelva al presionar "atrás"
                finish();
            }
        }, 3000); // 3000 milisegundos = 3 segundos
    }
}
