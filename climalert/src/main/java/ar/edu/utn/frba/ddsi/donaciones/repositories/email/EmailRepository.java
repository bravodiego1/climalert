package ar.edu.utn.frba.ddsi.donaciones.repositories.email;

import ar.edu.utn.frba.ddsi.donaciones.models.entities.email.Email;

import java.util.List;
import java.util.Optional;

public interface EmailRepository {
    List<Email> buscarTodosLosEmails();
    Optional<Email> obtenerEmailPorID(Long id);
    void guardarEmail(Email unEmail);
    void eliminarEmailPorID(Long id);
}
