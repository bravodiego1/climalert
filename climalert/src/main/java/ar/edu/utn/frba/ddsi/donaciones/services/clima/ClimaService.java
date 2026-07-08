package ar.edu.utn.frba.ddsi.donaciones.services.clima;

import ar.edu.utn.frba.ddsi.donaciones.models.entities.clima.Clima;

import java.util.List;

public interface ClimaService {
    Clima buscarClimaEnTapiales();
    List<Clima> obtenerTodosLosClimas();
    void guardarClima (Clima unClima);
    void verificarYProcesarAlertas();
}
