package co.edu.uniquindio.poo.observer1Basic;

import java.util.ArrayList;
import java.util.List;

public class CanalYoutube implements Sujeto {
    private List<Observador> suscriptores = new ArrayList<>();
    private String tituloVideo;

    @Override
    public void agregar(Observador o) {
        suscriptores.add(o);
    }

    @Override
    public void eliminar(Observador o) {
        suscriptores.remove(o);
    }

    @Override
    public void notificar() {
        for (Observador o : suscriptores) {
            o.actualizar(tituloVideo);
        }
    }

    public void subirVideo(String titulo) {
        this.tituloVideo = titulo;
        System.out.println(" El canal subió un nuevo video: " + titulo);
        notificar();
    }
}
