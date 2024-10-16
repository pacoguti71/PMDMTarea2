package gutierrezruiz.francisco;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


// Toma una lista de personajes y los coloca uno por uno en una vista, mostrando su nombre y su imagen.
// Cada elemento de la lista es clickeable, y cuando lo haces, abre una nueva pantalla (actividad) con más detalles sobre el personaje.
// Extiende de la clase estática del fin del código
public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {
    // Este adaptador maneja los datos de los personajes y los asigna al diseño de cada ítem. El contexto es dónde se mostrará la lista.
    private final List<Personaje> listaPersonajes;
    private final Context context;

    // Constructor
    public PersonajeAdapter(List<Personaje> listaPersonajes, Context context) {
        this.listaPersonajes = listaPersonajes;
        this.context = context;
    }

    @NonNull
    @Override
    // Dice cómo se verá cada tarjeta (personaje). Aquí se infla el archivo XML (item_personaje)
    // que contiene el diseño de la tarjeta (una imagen y un nombre).
    // Usa la clase estática del fin del código
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    @Override
    // Se toma un personaje de la lista según su posición y se le asignan los datos:
    // El nombre se pone en un TextView. La imagen se pone en un ImageView.
    // Recibe un objeto de la clase estática del fin del código
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personaje = listaPersonajes.get(position);
        holder.nombrePersonaje.setText(personaje.getNombre());
        holder.imagenPersonaje.setImageResource(personaje.getImagenId());
    //    holder.descripcionPersonaje.setText(personaje.getDescripcion());
    //    holder.habilidadPersonaje.setText(personaje.getHabilidad());

        // Para cada tarjeta (cada personaje), se configura un evento al hacer clic en la tarjeta
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cargarmos la fuente personalizada
                Typeface customFont = ResourcesCompat.getFont(v.getContext(), R.font.maquinaescribir);
                // Creamos el toast a mostrar
                Toast toast = Toast.makeText(context, "Detalles cargados para " + personaje.getNombre(), Toast.LENGTH_SHORT);
                // Creamos el TextView con el mensaje
                TextView textView = (TextView) toast.getView().findViewById(android.R.id.message);
                // Aplicamos la fuente personalizada
                textView.setTypeface(customFont);
                // Mostramos el toast
                toast.show();

                // Crea un intent para ir a DetallesPersonajeActivity
                Intent intent = new Intent(context, DetallesPersonajeActivity.class);
                // Pasa los datos del personaje seleccionado
                intent.putExtra("nombrePersonaje", personaje.getNombre());
                intent.putExtra("imagenPersonaje", personaje.getImagenId());
                intent.putExtra("descripcionPersonaje", personaje.getDescripcion());
                intent.putExtra("habilidadPersonaje", personaje.getHabilidad());
                // Inicia la nueva actividad
                context.startActivity(intent);
            }
        });
    }

    @Override
    // Devuelve la cantidad total de personajes en la lista para que el RecyclerView sepa cuántas tarjetas debe crear.
    public int getItemCount() {
        return listaPersonajes.size();
    }

    // Clase estática. Conecta los elementos de la interfaz (imagen y nombre) con su correspondiente vista en el diseño (item_personaje).
    public static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        ImageView imagenPersonaje;
        TextView nombrePersonaje;
        TextView descripcionPersonaje;
        TextView habilidadPersonaje;

        // Constructor
        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenPersonaje = itemView.findViewById(R.id.imagenPersonaje);
            nombrePersonaje = itemView.findViewById(R.id.nombrePersonaje);
            descripcionPersonaje = itemView.findViewById(R.id.descripcionPersonaje);
            habilidadPersonaje = itemView.findViewById(R.id.habilidadPersonaje);
        }
    }
}
