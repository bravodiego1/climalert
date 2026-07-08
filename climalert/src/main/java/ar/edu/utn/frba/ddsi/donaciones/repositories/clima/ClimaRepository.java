package ar.edu.utn.frba.ddsi.donaciones.repositories.clima;

import ar.edu.utn.frba.ddsi.donaciones.models.entities.clima.Clima;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ClimaRepository {
    void guardarClima (Clima clima);
    List<Clima> buscarTodosLosClimas ();
    Optional<Clima> buscarClimaPorID(Long id);
    void eliminarClimaPorID(Long id);
}
