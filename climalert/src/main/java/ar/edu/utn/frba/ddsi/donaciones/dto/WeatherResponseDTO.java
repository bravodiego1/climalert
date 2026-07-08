package ar.edu.utn.frba.ddsi.donaciones.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDTO {
    @JsonProperty("current")
    private CurrentDTO current;
}