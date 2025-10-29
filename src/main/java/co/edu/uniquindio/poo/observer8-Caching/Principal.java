package co.edu.uniquindio.poo.observer8;

/**
 * Demostración de Observer con Caching
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN OBSERVER CON CACHING ===\n");
        
        SujetoConCache sistema = new SujetoConCache();
        
        ObservadorConContador obs1 = new ObservadorConContador("Display-A");
        ObservadorConContador obs2 = new ObservadorConContador("Display-B");
        ObservadorConContador obs3 = new ObservadorConContador("Logger");
        
        sistema.agregarObservador(obs1);
        sistema.agregarObservador(obs2);
        sistema.agregarObservador(obs3);
        
        // ====== DEMOSTRACIÓN CON CACHE ======
        System.out.println("\n" + "═".repeat(60));
        System.out.println("PRUEBA 1: Cache Habilitado (evita duplicados)");
        System.out.println("═".repeat(60));
        
        sistema.setEstado("Estado-A");
        sistema.setEstado("Estado-A"); // Mismo estado - no notifica
        sistema.setEstado("Estado-A"); // Mismo estado - no notifica
        
        sistema.setEstado("Estado-B"); // Nuevo estado - sí notifica
        sistema.setEstado("Estado-B"); // Mismo estado - no notifica
        
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Observador 1 recibió: " + obs1.getContadorActualizaciones() + " notificaciones");
        System.out.println("Observador 2 recibió: " + obs2.getContadorActualizaciones() + " notificaciones");
        System.out.println("Observador 3 recibió: " + obs3.getContadorActualizaciones() + " notificaciones");
        System.out.println("Notificaciones evitadas por cache: " + sistema.getNotificacionesEvitadas());
        
        // ====== DEMOSTRACIÓN SIN CACHE ======
        System.out.println("\n" + "═".repeat(60));
        System.out.println("PRUEBA 2: Cache Deshabilitado (notifica siempre)");
        System.out.println("═".repeat(60));
        
        sistema.limpiarCache();
        sistema.habilitarCache(false);
        
        int notificacionesAntes1 = obs1.getContadorActualizaciones();
        
        sistema.setEstado("Estado-C");
        sistema.setEstado("Estado-C"); // Ahora SÍ notifica (cache deshabilitado)
        sistema.setEstado("Estado-C"); // Ahora SÍ notifica (cache deshabilitado)
        
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Observador 1 recibió: " + 
                         (obs1.getContadorActualizaciones() - notificacionesAntes1) + 
                         " notificaciones adicionales");
        
        // ====== LIMPIEZA DE CACHE ======
        System.out.println("\n" + "═".repeat(60));
        System.out.println("PRUEBA 3: Limpieza de Cache");
        System.out.println("═".repeat(60));
        
        sistema.habilitarCache(true);
        sistema.setEstado("Estado-D");
        sistema.setEstado("Estado-D"); // No notifica (cacheado)
        
        System.out.println("\nLimpiando cache...");
        sistema.limpiarCache();
        
        sistema.setEstado("Estado-D"); // Ahora SÍ notifica (cache limpiado)
        
        // ====== RESUMEN ======
        System.out.println("\n" + "═".repeat(60));
        System.out.println("VENTAJAS DEL CACHING:");
        System.out.println("✓ Evita notificaciones innecesarias");
        System.out.println("✓ Mejora el rendimiento del sistema");
        System.out.println("✓ Reduce carga de procesamiento");
        System.out.println("✓ Ahorra recursos de red/CPU");
        System.out.println("═".repeat(60));
    }
}
