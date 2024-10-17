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


/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2024/10/16
 *
 * Toma una lista de personajes y los coloca uno por uno en una vista, mostrando su nombre y su imagen.
 * Cada elemento de la lista es clickeable, y cuando lo haces, abre una nueva pantalla (actividad) con más detalles sobre el personaje.
 * Extiende de la clase estática del fin del código.
 * Este adaptador maneja los datos de los personajes y los asigna al diseño de cada ítem. El contexto es dónde se mostrará la lista.
 */
public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {

    private final List<Personaje> listaPersonajes; // Referencia a la lista de personajes
    private final Context context; // Contexto

    /**
     * Instancia un nuevo adaptador de personajes.
     *
     * @param listaPersonajes la lista personajes
     * @param context         el context
     */
// Constructor
    public PersonajeAdapter(List<Personaje> listaPersonajes, Context context) {
        this.listaPersonajes = listaPersonajes;
        this.context = context;
    }

    /**
     * Método parte de la clase RecyclerView.Adapter, que se utiliza para mostrar
     * una lista de elementos en un RecyclerView. Es responsable de crear un nuevo
     * ViewHolder cada vez que el RecyclerView necesita mostrar un nuevo elemento
     * en la lista. El ViewHolder es una clase que contiene las vistas que representan un elemento individual en la lista
     *
     * @param parent   el ViewGroup padre. Normalmente el RecyclerView
     * @param viewType entero que representa el tipo de vista que se debe crear
     * @return nuevo objeto PersonajeViewHolder
     */
    @NonNull
    @Override
    // Dice cómo se verá cada tarjeta (personaje). Aquí se infla el archivo XML (item_personaje)
    // que contiene el diseño de la tarjeta (una imagen y un nombre).
    // Usa la clase estática del fin del código
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    /**
     * Método parte de la clase RecyclerView.Adapter, responsable de actualizar los datos
     * de un ViewHolder existente con la información del elemento que se va a mostrar en
     * la posición especificada.
     *
     * @param holder   ViewHolder que se va a actualizar. Ha sido creado previamente por el método onCreateViewHolder().
     * @param position posición del elemento en la lista que se va a mostrar
     */
    @Override
    // Se toma un personaje de la lista según su posición y se le asignan los datos:
    // El nombre se pone en un TextView. La imagen se pone en un ImageView.
    // Recibe un objeto de la clase estática del fin del código
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personaje = listaPersonajes.get(position);
        holder.nombrePersonaje.setText(personaje.getNombre());
        holder.imagenPersonaje.setImageResource(personaje.getImagenId());
        // Si quisieramos mostrar más elementos
        //    holder.descripcionPersonaje.setText(personaje.getDescripcion());
        //    holder.habilidadPersonaje.setText(personaje.getHabilidad());

        // Para cada tarjeta (cada personaje), se configura un evento al hacer clic en la tarjeta
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cargarmos la fuente personalizada
                Typeface customFont = ResourcesCompat.getFont(v.getContext(), R.font.maquinaescribir);
                // Creamos el toast a mostrar
                String mensaje = context.getString(R.string.mensaje_toast, personaje.getNombre());
                // String mensaje = context.getString(R.string.mensaje_toast) + personaje.getNombre();
                Toast toast = Toast.makeText(context, mensaje, Toast.LENGTH_SHORT);
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

    /**
     * Devuelve el total de elementos.
     *
     * @return total de elementos
     */
    @Override
    // Devuelve la cantidad total de personajes en la lista para que el RecyclerView sepa cuántas tarjetas debe crear.
    public int getItemCount() {
        return listaPersonajes.size();
    }

    /**
     * Clase estática. Conecta los elementos de la interfaz (imagen y nombre)
     * con su correspondiente vista en el diseño (item_personaje).
     */
    public static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        ImageView imagenPersonaje; // La imagen del personaje
        TextView nombrePersonaje; // El nombre del personaje
        TextView descripcionPersonaje; // La descripción del personaje
        TextView habilidadPersonaje; // La habilidad del personaje

        /**
         * Instancia un numevo personaje view holder.
         *
         * @param itemView la vista del elemento
         */
        // Coinstructor
        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenPersonaje = itemView.findViewById(R.id.imagenPersonaje);
            nombrePersonaje = itemView.findViewById(R.id.nombrePersonaje);
            descripcionPersonaje = itemView.findViewById(R.id.descripcionPersonaje);
            habilidadPersonaje = itemView.findViewById(R.id.habilidadPersonaje);
        }
    }
}
