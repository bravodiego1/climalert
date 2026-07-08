package ar.edu.utn.frba.ddsi.donaciones.services.email;

import ar.edu.utn.frba.ddsi.donaciones.models.entities.email.Email;

import java.util.List;
import java.util.Optional;

public interface EmailService {
    List<Email> obtenerTodosLosEmails();
    Optional<Email> obtenerEmailPorID(Long id);
    void enviarEmail(Email unEmail);
    void eliminarEmailPorID(Long id);
}
