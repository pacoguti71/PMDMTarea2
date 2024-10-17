package gutierrezruiz.francisco;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
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

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2024/10/16
 *
 * Pantalla principal. Muestra una lista de personajes.
 */
public class MainActivity extends AppCompatActivity {

    private final List<Personaje> misPersonajes = new ArrayList<>(); // Lista de personajes

    /**
     * Punto de entrada principal de una actividad y se llama cuando la actividad se crea por primera vez.
     * Android puede destruir una actividad en segundo plano si necesita liberar recursos del sistema
     * pero Android guarda información sobre su estado actual en un objeto Bundle.
     *
     * @param savedInstanceState estado de instancia guardado.
     */
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

    /**
     * Crea el menú de opciones de la actividad
     *
     * @param menu el menú
     * @return verdadero si se ha creado el menú
     */
// Creamos el menú de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Establecemos el diseño del menú de opciones
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Gestiona la elección de los items del menú de opciones
     *
     * @param item el item seleccionado
     * @return verdadero si el item ha sido seleccionado
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejamos las opciones elegidas. Si fueran más podría usarse un switch
        if (item.getItemId() == R.id.menu_icon) {
            // Mostrar el submenú al pulsar el ícono
            showPopupMenu(findViewById(R.id.menu_icon));
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    /**
     * Muestra el submenú al pulsar en el icono cel menú
     *
     * @param view la vista
     */
    private void showPopupMenu(View view) {
        // Cargamos el menú del submenú
        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.submenu, popup.getMenu());

        // Manejamos las selecciones del submenú
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.acercade) {
                    // Acción para la opción acerca de
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    // Creamos un objeto de nuestra clase DialogoAlerta que muestra el diálogo
                    DialogoAlerta dialogo = new DialogoAlerta();
                    // Mostramos el diálogo
                    dialogo.show(fragmentManager, "dialogoAcercade");
                    return true;
                } else if (itemId == R.id.salir) {
                    // Acción para la opción salir
                    finish();
                    return true;
                }
                return false;
            }
        });
        // Mostramos el PopupMenu
        popup.show();
    }

    /**
     * Inicia la lista de personajes.
     */

    private void iniciarListaPersonajes() {
        misPersonajes.add(new Personaje(getString(R.string.boo), R.drawable.boo, getString(R.string.boo_descripcion), getString(R.string.boo_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.bowser), R.drawable.bowser, getString(R.string.bowser_descripcion), getString(R.string.bowser_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.bowser_jr), R.drawable.bowserjr, getString(R.string.bowserjr_descripcion), getString(R.string.bowserjr_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.daisy), R.drawable.daisy, getString(R.string.daisy_descripcion), getString(R.string.daisy_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.diddy_kong), R.drawable.diddykong, getString(R.string.diddykong_descripcion), getString(R.string.diddykong_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.donkey_kong), R.drawable.donkeykong, getString(R.string.donkeykong_descripcion), getString(R.string.donkeykong_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.luigi), R.drawable.luigi, getString(R.string.luigi_descripcion), getString(R.string.luigi_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.mario), R.drawable.mario, getString(R.string.mario_descripcion), getString(R.string.mario_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.peach), R.drawable.peach, getString(R.string.peach_descripcion), getString(R.string.peach_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.rosalina), R.drawable.rosalina, getString(R.string.rosalina_descripcion), getString(R.string.rosalina_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.toad), R.drawable.toad, getString(R.string.toad_descripcion), getString(R.string.toad_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.waluigi), R.drawable.waluigi, getString(R.string.waluigi_descripcion), getString(R.string.waluigi_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.wario), R.drawable.wario, getString(R.string.wario_descripcion), getString(R.string.wario_habilidad)));
        misPersonajes.add(new Personaje(getString(R.string.yoshi), R.drawable.yoshi, getString(R.string.yoshi_descripcion), getString(R.string.yoshi_habilidad)));

    }
}
