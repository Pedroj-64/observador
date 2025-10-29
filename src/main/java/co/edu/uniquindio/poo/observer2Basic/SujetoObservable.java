package co.edu.uniquindio.poo.observer2Basic;

public interface SujetoObservable {
    void agregarObservador(Observador o);
    void eliminarObservador(Observador o);
    void notificarObservadores();
}

