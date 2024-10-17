package gutierrezruiz.francisco;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Mostrar la pantalla de splash durante 3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Después de 3 segundos, lanzar la actividad principal
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                // Finaliza esta actividad para que no vuelva al presionar "atrás"
                finish();
            }
        }, 3000); // 3000 milisegundos = 3 segundos
    }
}
