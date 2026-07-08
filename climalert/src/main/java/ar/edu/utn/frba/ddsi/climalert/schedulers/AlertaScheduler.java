package ar.edu.utn.frba.ddsi.climalert.schedulers;

import ar.edu.utn.frba.ddsi.climalert.services.clima.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertaScheduler {

    private final ClimaService climaService;

    public AlertaScheduler(ClimaService climaService) {
        this.climaService = climaService;
    }

    @Scheduled(fixedRate = 60000) // 60000 ms = 1 minuto
    public void ejecutarProcesamientoAlertas() {
        try {
            climaService.verificarYProcesarAlertas();
        } catch (Exception e) {
            System.out.println("Error al procesar alertas: " + e.getMessage());
        }
    }
}