package model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class DatosVehiculoDTO {
    private String placa;
    private LocalDateTime fechaHora;
}
