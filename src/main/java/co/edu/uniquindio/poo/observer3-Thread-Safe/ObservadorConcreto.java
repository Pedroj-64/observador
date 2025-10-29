package co.edu.uniquindio.poo.observer3;

/**
 * Implementación concreta de un observador thread-safe
 */
public class ObservadorConcreto implements Observador {
    private final String nombre;
    private String ultimoMensaje;
    
    public ObservadorConcreto(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public synchronized void actualizar(String mensaje) {
        this.ultimoMensaje = mensaje;
        System.out.println(nombre + " recibió actualización: " + mensaje + 
                         " [Thread: " + Thread.currentThread().getName() + "]");
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    public synchronized String getUltimoMensaje() {
        return ultimoMensaje;
    }
}
