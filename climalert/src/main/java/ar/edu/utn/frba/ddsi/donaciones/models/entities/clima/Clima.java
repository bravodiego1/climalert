package ar.edu.utn.frba.ddsi.donaciones.models.entities.clima;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clima {
    private Long id;
    private Double temp;
    private Integer humedad;
}
