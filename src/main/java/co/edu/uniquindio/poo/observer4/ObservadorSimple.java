package co.edu.uniquindio.poo.observer4;

/**
 * Implementación simple de observador
 */
public class ObservadorSimple implements Observador {
    private final String id;
    
    public ObservadorSimple(String id) {
        this.id = id;
    }
    
    @Override
    public void actualizar(String evento) {
        System.out.println("  → " + id + " recibió: " + evento);
    }
    
    @Override
    public String getId() {
        return id;
    }
}
