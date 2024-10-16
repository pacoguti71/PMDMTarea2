package gutierrezruiz.francisco;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Personaje> misPersonajes = new ArrayList<>(); // Lista de personajes

    // Creamos la pantalla principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecemos el diseño de la pantalla principal
        setContentView(R.layout.activity_main);

        // Configuramos la barra de herramientas
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Manejamos los insets para evitar superposición con la barra de estado o de navegación
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Iniciamos la lista de personajes
        iniciarListaPersonajes();

        // Configuramos el RecyclerView
        RecyclerView miRecyclerView = findViewById(R.id.recyclerViewPersonajes);
        miRecyclerView.setHasFixedSize(true);
        miRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Añadimos una línea divisoria entre los elementos del RecyclerView
        DividerItemDecoration lineaDivisoria = new DividerItemDecoration(miRecyclerView.getContext(), LinearLayoutManager.VERTICAL);
        miRecyclerView.addItemDecoration(lineaDivisoria);

        // Configuramos el adaptador del RecyclerView
        PersonajeAdapter personajeAdapter = new PersonajeAdapter(misPersonajes, this);
        miRecyclerView.setAdapter(personajeAdapter);
    }

    // Creamos el menú de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Establecemos el diseño del menú de opciones
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Manejamos las opciones elegidas del menú de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Sólo hay una opción elegible
        if (item.getItemId() == R.id.acercade) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            // Mostramos el dialogo de alerta
            DialogoAlerta dialogo = new DialogoAlerta();
            dialogo.show(fragmentManager, "tagAlerta");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Método que inicia la lista de personajes
    private void iniciarListaPersonajes() {
        misPersonajes.add(new Personaje("Boo", R.drawable.boo, "Boo es un fantasma tímido que forma parte de la corte de Bowser. Es conocido por ser travieso y moverse solo cuando no lo miran.", "Invisibilidad – Boo puede volverse invisible y atravesar paredes cuando nadie lo está mirando."));
        misPersonajes.add(new Personaje("Bowser", R.drawable.bowser, "Bowser es el rey de los Koopas y el archienemigo de Mario. Su gran tamaño y su fuerza lo hacen un rival formidable.", "Llamarada – Bowser puede escupir fuego desde su boca, quemando todo a su paso."));
        misPersonajes.add(new Personaje("Bowser Jr", R.drawable.bowserjr, "Bowser Jr. es el hijo de Bowser, que sigue los pasos de su padre en su lucha contra Mario. Es travieso y tiene mucha energía.", "Cañón Koopa – Bowser Jr. usa su vehículo equipado con cañones para disparar proyectiles."));
        misPersonajes.add(new Personaje("Daisy", R.drawable.daisy, "Daisy es la princesa de Sarasaland y amiga de Peach. Es extrovertida, enérgica y aventurera.", "Golpe de flor – Daisy puede invocar una ráfaga de flores para atacar a sus enemigos o mejorar sus habilidades."));
        misPersonajes.add(new Personaje("Diddy Kong", R.drawable.diddykong, "Diddy es el compañero fiel de Donkey Kong. Es ágil, rápido y siempre está listo para la acción.", "Jet Pack – Diddy puede volar usando su mochila propulsora para llegar a lugares altos o esquivar ataques."));
        misPersonajes.add(new Personaje("Donkey Kong", R.drawable.donkeykong, "Donkey Kong es un gorila fuerte y protector de la isla Kong. Aunque tiene un lado rudo, es muy leal a sus amigos.", "Puñetazo potente – Donkey Kong puede dar un poderoso golpe que derriba a sus enemigos."));
        misPersonajes.add(new Personaje("Luigi", R.drawable.luigi, "Luigi es el hermano de Mario y un poco más tímido que él, pero siempre está dispuesto a ayudar en la aventura.", "Super Salto – Luigi puede saltar más alto que Mario, lo que le permite alcanzar plataformas más elevadas."));
        misPersonajes.add(new Personaje("Mario", R.drawable.mario, "Mario es el héroe principal del Reino Champiñón, siempre listo para rescatar a la princesa Peach de las garras de Bowser.", "Salto en pared – Mario puede saltar entre paredes para alcanzar lugares difíciles o esquivar ataques."));
        misPersonajes.add(new Personaje("Peach", R.drawable.peach, "Peach es la princesa del Reino Champiñón. Aunque es a menudo capturada por Bowser, también sabe defenderse cuando es necesario.", "Flotación – Peach puede flotar en el aire durante un corto período de tiempo, lo que le da ventaja en saltos largos."));
        misPersonajes.add(new Personaje("Rosalina", R.drawable.rosalina, "Rosalina es la guardiana del cosmos y madre adoptiva de los Lumas. Es sabia, tranquila y poderosa.", "Magia estelar – Rosalina puede controlar las estrellas para lanzar poderosos ataques de energía cósmica."));
        misPersonajes.add(new Personaje("Toad", R.drawable.toad, "Toad es un habitante del Reino Champiñón, leal a la princesa Peach. Aunque pequeño, es rápido y trabajador.", "Velocidad Champiñón – Toad puede correr a gran velocidad, superando a sus enemigos en carreras cortas."));
        misPersonajes.add(new Personaje("Waluigi", R.drawable.waluigi, "Waluigi es el rival de Luigi y es conocido por su carácter mezquino y sus habilidades en deportes.", "Trampa de enredadera – Waluigi puede plantar enredaderas que ralentizan a sus oponentes y los atrapan."));
        misPersonajes.add(new Personaje("Wario", R.drawable.wario, "Wario es el rival de Mario, codicioso y fuerte. Aunque es avaro, también es astuto y siempre busca su propio beneficio.", "Impacto aplastante – Wario puede cargar un ataque para aplastar a sus enemigos con su cuerpo."));
        misPersonajes.add(new Personaje("Yoshi", R.drawable.yoshi, "Yoshi es un dinosaurio amigable y fiel compañero de Mario. Puede comer enemigos con su larga lengua.", "Salto con patada – Yoshi puede dar un salto seguido de una patada para eliminar enemigos y destruir bloques."));
    }
}
