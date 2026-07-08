package ar.edu.utn.frba.ddsi.climalert.services.email.impl;

import ar.edu.utn.frba.ddsi.climalert.models.entities.email.Email;
import ar.edu.utn.frba.ddsi.climalert.repositories.email.EmailRepository;
import ar.edu.utn.frba.ddsi.climalert.services.email.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;

    private static final String[] DESTINATARIOS = {
            "admin@clima.com",
            "emergencias@clima.com",
            "meteorologia@clima.com"
    };

    public EmailServiceImpl (EmailRepository emailRepository, JavaMailSender mailSender){
        this.emailRepository = emailRepository;
        this.mailSender = mailSender;
    }

    @Override
    public List<Email> obtenerTodosLosEmails() {
        return emailRepository.buscarTodosLosEmails();
    }

    @Override
    public Optional<Email> obtenerEmailPorID(Long id) {
        return emailRepository.obtenerEmailPorID(id);
    }

    @Override
    public void enviarEmail(Email unEmail) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(DESTINATARIOS);
        email.setSubject(unEmail.getAsunto());
        email.setText(unEmail.getMensaje());

        emailRepository.guardarEmail(unEmail);
        mailSender.send(email);
    }

    @Override
    public void eliminarEmailPorID(Long id) {
        emailRepository.eliminarEmailPorID(id);
    }
}