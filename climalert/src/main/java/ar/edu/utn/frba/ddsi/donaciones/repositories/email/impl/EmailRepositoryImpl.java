package ar.edu.utn.frba.ddsi.donaciones.repositories.email.impl;

import ar.edu.utn.frba.ddsi.donaciones.models.entities.email.Email;
import ar.edu.utn.frba.ddsi.donaciones.repositories.email.EmailRepository;
import ar.edu.utn.frba.ddsi.donaciones.repositories.utils.GeneradorID;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmailRepositoryImpl implements EmailRepository {
    private final List<Email> emails = new ArrayList<>();
    private final GeneradorID generadorID = new GeneradorID(1L);

    @Override
    public List<Email> buscarTodosLosEmails() {
        return new ArrayList<>(emails);
    }

    @Override
    public Optional<Email> obtenerEmailPorID(Long id) {
        return emails
                .stream()
                .filter(unEmail -> unEmail.getId().equals(id))
                .findFirst();
    }

    @Override
    public void guardarEmail(Email unEmail) {
        if (unEmail.getId() == null){
            unEmail.setId(generadorID.siguiente());
            emails.add(unEmail);
        }
        eliminarEmailPorID(unEmail.getId());
        emails.add(unEmail);
    }

    @Override
    public void eliminarEmailPorID(Long id) {
        emails.removeIf(unEmail -> unEmail.getId().equals(id));
    }
}
