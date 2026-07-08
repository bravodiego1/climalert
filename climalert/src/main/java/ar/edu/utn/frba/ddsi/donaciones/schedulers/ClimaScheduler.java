package ar.edu.utn.frba.ddsi.donaciones.schedulers;

import ar.edu.utn.frba.ddsi.donaciones.services.clima.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {

    private final ClimaService climaService;

    public ClimaScheduler(ClimaService climaService) {
        this.climaService = climaService;
    }

    @Scheduled(fixedRate = 300000) // 300000 ms = 5 minutos
    public void ejecutarConsultaClima() {
        try {
            climaService.buscarClimaEnTapiales();
        } catch (Exception e) {
            System.out.println("Error al consultar el clima: " + e.getMessage());
        }
    }
}