package ar.edu.utn.frba.ddsi.climalert.models.entities.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private Long id;
    private String asunto;
    private String mensaje;
    private String cuenta;
}
