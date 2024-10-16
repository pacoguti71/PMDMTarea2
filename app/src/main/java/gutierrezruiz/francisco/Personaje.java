package gutierrezruiz.francisco;

public class Personaje {
    private final String nombre;
    private final int imagenId;
    private final String descripcion;
    private final String habilidad;

    // Constructor
    public Personaje(String nombre, int imagenId, String descripcion, String habilidad) {
        this.nombre = nombre;
        this.imagenId = imagenId;
        this.descripcion = descripcion;
        this.habilidad = habilidad;
    }

    // Método getter que devuelve el nombre del personaje
    public String getNombre() {
        return nombre;
    }

    // Método getter que devuelve la imagen del personaje como un entero
    public int getImagenId() {
        return imagenId;
    }

    // Método getter que devuelve la descripcion del personaje
    public String getDescripcion() {
        return descripcion;
    }

    // Método getter que devuelve la habilidad del personaje
    public String getHabilidad() {
        return habilidad;
    }
}
