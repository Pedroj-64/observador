package co.edu.uniquindio.poo.observer1;

public interface Sujeto {
    void agregar(Observador o);
    void eliminar(Observador o);
    void notificar();
}
