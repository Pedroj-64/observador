package co.edu.uniquindio.poo.observer4LazyvsEager;

/**
 * Demostración de inicialización Lazy vs Eager
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN OBSERVER: LAZY vs EAGER INITIALIZATION ===\n");
        
        // ====== DEMOSTRACIÓN LAZY ======
        System.out.println("--- LAZY INITIALIZATION ---");
        System.out.println("Antes de obtener instancia Lazy...");
        
        SujetoLazy sujetoLazy = SujetoLazy.getInstancia();
        System.out.println("Instancia Lazy obtenida\n");
        
        ObservadorSimple obs1 = new ObservadorSimple("Lazy-Observer-1");
        ObservadorSimple obs2 = new ObservadorSimple("Lazy-Observer-2");
        
        System.out.println("\nAgregando observadores (aquí se inicializa la lista):");
        sujetoLazy.agregarObservador(obs1);
        sujetoLazy.agregarObservador(obs2);
        
        System.out.println("\nCambiando estado:");
        sujetoLazy.setEstado("Evento Lazy 1");
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // ====== DEMOSTRACIÓN EAGER ======
        System.out.println("--- EAGER INITIALIZATION ---");
        System.out.println("Antes de obtener instancia Eager...");
        System.out.println("(La instancia YA fue creada al cargar la clase)");
        
        SujetoEager sujetoEager = SujetoEager.getInstancia();
        System.out.println("Instancia Eager obtenida\n");
        
        ObservadorSimple obs3 = new ObservadorSimple("Eager-Observer-1");
        ObservadorSimple obs4 = new ObservadorSimple("Eager-Observer-2");
        
        System.out.println("\nAgregando observadores (la lista ya estaba inicializada):");
        sujetoEager.agregarObservador(obs3);
        sujetoEager.agregarObservador(obs4);
        
        System.out.println("\nCambiando estado:");
        sujetoEager.setEstado("Evento Eager 1");
        
        // ====== COMPARACIÓN ======
        System.out.println("\n" + "=".repeat(60));
        System.out.println("--- COMPARACIÓN ---");
        System.out.println("LAZY: Ventaja -> Ahorra memoria si no se usan los recursos");
        System.out.println("LAZY: Desventaja -> Primer acceso más lento");
        System.out.println("EAGER: Ventaja -> Acceso rápido, thread-safe por naturaleza");
        System.out.println("EAGER: Desventaja -> Consume memoria aunque no se use");
    }
}
