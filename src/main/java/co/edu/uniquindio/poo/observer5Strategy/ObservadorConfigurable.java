package co.edu.uniquindio.poo.observer5Strategy;

/**
 * Observador con estado activo/inactivo
 */
public class ObservadorConfigurable implements Observador {
    private final String nombre;
    private boolean activo = true;
    
    public ObservadorConfigurable(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void actualizar(String mensaje) {
        System.out.println("  ✓ " + nombre + " procesó: " + mensaje);
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public boolean estaActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
        System.out.println(nombre + " ahora está " + (activo ? "ACTIVO" : "INACTIVO"));
    }
}
