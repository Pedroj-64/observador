package co.edu.uniquindio.poo.observer2;

import java.util.ArrayList;
import java.util.List;

public class EstacionMetereologica implements SujetoObservable {

    private List<Observador> observadores;
    private float temperatura;
    private float humedad;
    private float presion;

    public EstacionMetereologica() {
        observadores = new ArrayList<>();
    }

    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar(temperatura, humedad, presion);
        }
    }

    // Método para simular nuevos datos del clima
    public void setDatosClima(float temperatura, float humedad, float presion) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presion = presion;
        System.out.println("\n📡 [Estación] Nuevos datos: " +
                "Temperatura = " + temperatura + "°C, Humedad = " + humedad + "%, Presión = " + presion + " hPa");
        notificarObservadores();
    }
}

