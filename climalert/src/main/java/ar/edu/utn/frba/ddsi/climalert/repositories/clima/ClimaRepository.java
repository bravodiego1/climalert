package ar.edu.utn.frba.ddsi.climalert.repositories.clima;

import ar.edu.utn.frba.ddsi.climalert.models.entities.clima.Clima;

import java.util.List;
import java.util.Optional;

public interface ClimaRepository {
    void guardarClima (Clima clima);
    List<Clima> buscarTodosLosClimas ();
    Optional<Clima> buscarClimaPorID(Long id);
    void eliminarClimaPorID(Long id);
}
