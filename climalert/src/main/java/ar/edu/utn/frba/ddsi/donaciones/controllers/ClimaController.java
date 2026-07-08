package ar.edu.utn.frba.ddsi.donaciones.controllers;

import ar.edu.utn.frba.ddsi.donaciones.models.entities.clima.Clima;
import ar.edu.utn.frba.ddsi.donaciones.services.clima.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clima")
public class ClimaController {
    private final ClimaService climaService;

    public ClimaController(ClimaService clima){
        this.climaService = clima;
    }

    @GetMapping("/actual")
    public Clima obtenerClimaActual(){
        return climaService.buscarClimaEnTapiales();
    }

    @GetMapping("/historial")
    public List<Clima> obtenerClimasHistoricosTapiales(){
        return climaService.obtenerTodosLosClimas();
    }
}
