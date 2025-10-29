package co.edu.uniquindio.poo.observer6Prioridades;

/**
 * Demostración de Observer con prioridades
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN OBSERVER CON PRIORIDADES ===\n");
        
        SujetoConPrioridades sistema = new SujetoConPrioridades();
        
        // Crear observadores con diferentes prioridades
        // Menor número = Mayor prioridad
        ObservadorConPrioridad critico = new ObservadorConPrioridad(
            "Sistema de Seguridad", 1, "CRÍTICO"
        );
        
        ObservadorConPrioridad alto = new ObservadorConPrioridad(
            "Base de Datos", 2, "ALTO"
        );
        
        ObservadorConPrioridad medio = new ObservadorConPrioridad(
            "Cache Manager", 3, "MEDIO"
        );
        
        ObservadorConPrioridad bajo = new ObservadorConPrioridad(
            "Logger", 4, "BAJO"
        );
        
        ObservadorConPrioridad info = new ObservadorConPrioridad(
            "Monitor de Estadísticas", 5, "INFO"
        );
        
        // Agregar observadores en orden aleatorio
        System.out.println("--- Agregando observadores (orden aleatorio) ---");
        sistema.agregarObservador(medio);
        sistema.agregarObservador(critico);
        sistema.agregarObservador(info);
        sistema.agregarObservador(bajo);
        sistema.agregarObservador(alto);
        
        // Mostrar orden de notificación
        sistema.mostrarOrdenNotificacion();
        
        // Enviar eventos
        sistema.setEstado("Error detectado en el sistema");
        
        System.out.println("\n" + "=".repeat(60));
        
        sistema.setEstado("Conexión establecida exitosamente");
        
        System.out.println("\n" + "=".repeat(60));
        
        // Agregar un nuevo observador con prioridad alta
        System.out.println("\n--- Agregando observador con prioridad alta ---");
        ObservadorConPrioridad nuevoAlto = new ObservadorConPrioridad(
            "Sistema de Respaldo", 2, "ALTO"
        );
        sistema.agregarObservador(nuevoAlto);
        
        sistema.mostrarOrdenNotificacion();
        sistema.setEstado("Iniciando proceso de respaldo");
        
        // ====== CASOS DE USO ======
        System.out.println("\n" + "=".repeat(60));
        System.out.println("CASOS DE USO PARA PRIORIDADES:");
        System.out.println("✓ Sistemas de seguridad (notificación prioritaria)");
        System.out.println("✓ Procesamiento de eventos críticos primero");
        System.out.println("✓ Cachés que deben actualizarse antes que los logs");
        System.out.println("✓ Notificaciones de alerta vs. información");
        System.out.println("=".repeat(60));
    }
}
