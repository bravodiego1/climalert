package ar.edu.utn.frba.ddsi.climalert.services.clima;

import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.Clima;

import java.util.List;

public interface ClimaService {
    Clima buscarClimaEnTapiales();
    List<Clima> obtenerTodosLosClimas();
    void guardarClima (Clima unClima);
    void verificarYProcesarAlertas();
}
