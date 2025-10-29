package co.edu.uniquindio.poo.observer1Basic;

public class Suscriptor implements Observador {
    private String nombre;

    public Suscriptor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String tituloVideo) {
        System.out.println(nombre + " fue notificado: Nuevo video '" + tituloVideo + "'");
    }
}

