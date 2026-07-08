package ar.edu.utn.frba.ddsi.donaciones.services.clima.impl;

import ar.edu.utn.frba.ddsi.donaciones.config.RestWeatherProperties;
import ar.edu.utn.frba.ddsi.donaciones.dto.WeatherResponseDTO;
import ar.edu.utn.frba.ddsi.donaciones.models.entities.clima.Clima;
import ar.edu.utn.frba.ddsi.donaciones.models.entities.email.Email;
import ar.edu.utn.frba.ddsi.donaciones.repositories.clima.ClimaRepository;
import ar.edu.utn.frba.ddsi.donaciones.services.clima.ClimaService;
import ar.edu.utn.frba.ddsi.donaciones.services.email.EmailService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class ClimaServiceImpl implements ClimaService {
    private final RestTemplate restTemplate;
    private final RestWeatherProperties restWeatherProperties;
    private final ClimaRepository climaRepository;
    private final EmailService emailService;

    public ClimaServiceImpl(RestWeatherProperties restWeatherProperties, RestTemplate restTemplate,
                            ClimaRepository climaRepository, EmailService emailService){
        this.restWeatherProperties = restWeatherProperties;
        this.restTemplate = restTemplate;
        this.climaRepository = climaRepository;
        this.emailService = emailService;
    }

    @Override
    public Clima buscarClimaEnTapiales() {
        URI uri = UriComponentsBuilder
                .fromUriString(restWeatherProperties.getBaseUrl())
                .path("/current.json")
                .queryParam("key", restWeatherProperties.getApikey())
                .queryParam("q", "Tapiales")
                .build()
                .toUri();

        WeatherResponseDTO respuesta = restTemplate.getForObject(uri, WeatherResponseDTO.class);

        Clima clima = new Clima();
        clima.setTemp(respuesta.getCurrent().getTemperatura());
        clima.setHumedad(respuesta.getCurrent().getHumedad());
        guardarClima(clima);

        return clima;
    }

    @Override
    public void verificarYProcesarAlertas() {
        List<Clima> todos = obtenerTodosLosClimas();
        if (todos.isEmpty()) return;

        Clima ultimoClima = todos.get(todos.size() - 1);

        if (ultimoClima.getTemp() > 35 && ultimoClima.getHumedad() > 60) {
            Email alertaEmail = new Email();
            alertaEmail.setAsunto("Alerta climática crítica");
            alertaEmail.setMensaje(String.format(
                    "Se detectaron condiciones críticas.\n\nTemperatura: %.1f°C\nHumedad: %d%%",
                    ultimoClima.getTemp(), ultimoClima.getHumedad()
            ));

            emailService.enviarEmail(alertaEmail);
        }
    }

    @Override
    public void guardarClima(Clima unClima) {
        climaRepository.guardarClima(unClima);
    }

    @Override
    public List<Clima> obtenerTodosLosClimas(){
        return climaRepository.buscarTodosLosClimas();
    }
}