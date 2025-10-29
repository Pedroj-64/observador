package co.edu.uniquindio.poo.observer7Generico;

/**
 * Observador genérico que puede observar cualquier tipo
 */
public class ObservadorGenerico<T> implements Observador<T> {
    private final String id;
    
    public ObservadorGenerico(String id) {
        this.id = id;
    }
    
    @Override
    public void actualizar(T dato) {
        System.out.println("  → " + id + " recibió dato: " + dato);
        System.out.println("    Tipo: " + dato.getClass().getSimpleName());
    }
    
    @Override
    public String getId() {
        return id;
    }
}
