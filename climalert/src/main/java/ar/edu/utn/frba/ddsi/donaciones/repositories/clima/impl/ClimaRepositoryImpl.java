package ar.edu.utn.frba.ddsi.donaciones.repositories.clima.impl;

import ar.edu.utn.frba.ddsi.donaciones.models.entities.clima.Clima;
import ar.edu.utn.frba.ddsi.donaciones.repositories.clima.ClimaRepository;
import ar.edu.utn.frba.ddsi.donaciones.repositories.utils.GeneradorID;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClimaRepositoryImpl implements ClimaRepository {
    private final List<Clima> climas = new ArrayList<>();
    private GeneradorID generadorID = new GeneradorID(1L);

    @Override
    public void guardarClima(Clima unClima) {
        if (unClima.getId() == null) {
            unClima.setId(generadorID.siguiente());
            climas.add(unClima);
        }
        eliminarClimaPorID(unClima.getId());
        climas.add(unClima);
    }

    @Override
    public List<Clima> buscarTodosLosClimas() {
        return new ArrayList<>(climas);
    }

    @Override
    public Optional<Clima> buscarClimaPorID(Long id) {
        return climas
                .stream()
                .filter(unClima -> unClima.getId().equals(id))
                .findFirst();
    }

    @Override
    public void eliminarClimaPorID(Long id) {
        climas.removeIf(unClima -> unClima.getId().equals(id));
    }
}
