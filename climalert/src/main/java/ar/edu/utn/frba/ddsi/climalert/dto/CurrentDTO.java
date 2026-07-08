package ar.edu.utn.frba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentDTO {

    @JsonProperty("temp_c")
    private Double temperatura;

    @JsonProperty("humidity")
    private Integer humedad;
}

