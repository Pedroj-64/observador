package co.edu.uniquindio.poo.observer2;

public interface SujetoObservable {
    void agregarObservador(Observador o);
    void eliminarObservador(Observador o);
    void notificarObservadores();
}

