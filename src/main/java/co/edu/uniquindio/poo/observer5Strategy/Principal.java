package co.edu.uniquindio.poo.observer5Strategy;

/**
 * Demostración de Observer con composición de estrategias
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN OBSERVER + STRATEGY (COMPOSICIÓN) ===\n");
        
        // Crear observadores
        ObservadorConfigurable obs1 = new ObservadorConfigurable("Usuario-Premium");
        ObservadorConfigurable obs2 = new ObservadorConfigurable("Usuario-Básico");
        ObservadorConfigurable obs3 = new ObservadorConfigurable("Usuario-VIP");
        
        // ====== ESTRATEGIA 1: NOTIFICACIÓN INMEDIATA ======
        System.out.println("┌" + "─".repeat(58) + "┐");
        System.out.println("│ ESTRATEGIA 1: Notificación Inmediata                    │");
        System.out.println("└" + "─".repeat(58) + "┘");
        
        SujetoConEstrategia sujeto = new SujetoConEstrategia(new NotificacionInmediata());
        sujeto.agregarObservador(obs1);
        sujeto.agregarObservador(obs2);
        sujeto.agregarObservador(obs3);
        
        sujeto.setEstado("Nuevo mensaje disponible");
        
        // ====== ESTRATEGIA 2: NOTIFICACIÓN RETRASADA ======
        System.out.println("\n┌" + "─".repeat(58) + "┐");
        System.out.println("│ ESTRATEGIA 2: Notificación Retrasada                    │");
        System.out.println("└" + "─".repeat(58) + "┘");
        
        sujeto.setEstrategia(new NotificacionRetrasada(500));
        sujeto.setEstado("Actualización importante");
        
        // ====== ESTRATEGIA 3: NOTIFICACIÓN POR LOTES ======
        System.out.println("\n┌" + "─".repeat(58) + "┐");
        System.out.println("│ ESTRATEGIA 3: Notificación por Lotes                    │");
        System.out.println("└" + "─".repeat(58) + "┘");
        
        NotificacionPorLotes estrategiaLotes = new NotificacionPorLotes(3);
        sujeto.setEstrategia(estrategiaLotes);
        
        sujeto.setEstado("Mensaje 1");
        sujeto.setEstado("Mensaje 2");
        sujeto.setEstado("Mensaje 3"); // Aquí se envía el lote
        sujeto.setEstado("Mensaje 4");
        
        // Forzar envío de mensajes pendientes
        estrategiaLotes.enviarPendientes();
        
        // ====== ESTRATEGIA 4: NOTIFICACIÓN CONDICIONAL ======
        System.out.println("\n┌" + "─".repeat(58) + "┐");
        System.out.println("│ ESTRATEGIA 4: Notificación Condicional                  │");
        System.out.println("└" + "─".repeat(58) + "┘");
        
        sujeto.setEstrategia(new NotificacionCondicional());
        
        System.out.println("\nDesactivando Usuario-Básico:");
        obs2.setActivo(false);
        
        System.out.println();
        sujeto.setEstado("Oferta exclusiva");
        
        System.out.println("\nReactivando Usuario-Básico:");
        obs2.setActivo(true);
        
        System.out.println();
        sujeto.setEstado("Nueva funcionalidad");
        
        // ====== RESUMEN ======
        System.out.println("\n" + "=".repeat(60));
        System.out.println("VENTAJAS DE LA COMPOSICIÓN OBSERVER + STRATEGY:");
        System.out.println("✓ Cambio de comportamiento en tiempo de ejecución");
        System.out.println("✓ Mayor flexibilidad y extensibilidad");
        System.out.println("✓ Código más limpio y mantenible");
        System.out.println("✓ Cumple con el principio Open/Closed");
        System.out.println("=".repeat(60));
    }
}
