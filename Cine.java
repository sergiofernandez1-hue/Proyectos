import java.util.ArrayList;
import java.util.List;


class Pelicula {
    private String titulo;
    private String director;
    private int duracion;
    private String clasificacion;

    public Pelicula(String titulo, String director, int duracion, String clasificacion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
    }

    public String getTitulo() { return titulo; }
}

class Sala {
    private int numero;
    private int capacidad;

    public Sala(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }

    public int getNumero() { return numero; }
    public int getCapacidad() { return capacidad; }
}

class Proyeccion {
    private Pelicula pelicula;
    private Sala sala;
    private String fechaHora;
    private double precio;
    private int entradasVendidas;

    public Proyeccion(Pelicula pelicula, Sala sala, String fechaHora, double precio) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.fechaHora = fechaHora;
        this.precio = precio;
        this.entradasVendidas = 0;
    }

    public void registrarVenta(int cantidad) {
        if (cantidad <= consultarDisponibilidad()) {
            this.entradasVendidas += cantidad;
        } else {
            System.out.println("Error: No hay suficientes entradas para " + pelicula.getTitulo());
        }
    }

    public int consultarDisponibilidad() {
        return sala.getCapacidad() - entradasVendidas;
    }

    public double calcularRecaudacion() {
        return entradasVendidas * precio;
    }

    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
}


public class Cine {
    private String nombre;
    private List<Sala> salas;
    private List<Pelicula> cartelera;

    public Cine(String nombre) {
        this.nombre = nombre;
        this.salas = new ArrayList<>();
        this.cartelera = new ArrayList<>();
    }

    public static void main(String[] args) {

        Cine cinepolis = new Cine("Cinepolis Centro");
        
        Pelicula dune = new Pelicula("Dune: Parte 2", "Denis Villeneuve", 166, "+13");
        Pelicula oppenheimer = new Pelicula("Oppenheimer", "Christopher Nolan", 180, "+16");
        
        Sala sala1 = new Sala(1, 100);
        Sala sala2 = new Sala(2, 150);

        Proyeccion proyeccion1 = new Proyeccion(dune, sala1, "01/04/2025 18:00", 10.0);
        Proyeccion proyeccion2 = new Proyeccion(oppenheimer, sala2, "02/04/2025 20:00", 12.0);

        proyeccion1.registrarVenta(85);
        proyeccion2.registrarVenta(120);

        System.out.println("CINE: " + cinepolis.nombre);
        
        imprimirEstadoProyeccion(proyeccion1);
        imprimirEstadoProyeccion(proyeccion2);
    }

    // Método auxiliar para mostrar la información solicitada
    public static void imprimirEstadoProyeccion(Proyeccion proyeccion) {
        System.out.println("Pelicula: " + proyeccion.getPelicula().getTitulo());
        System.out.println("Sala: " + proyeccion.getSala().getNumero());
        System.out.println("Disponibilidad: " + proyeccion.consultarDisponibilidad() + " asientos");
        System.out.println("Recaudacion: " + proyeccion.calcularRecaudacion() + "euros");
    }
}