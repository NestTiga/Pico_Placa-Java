package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class AuditoriaVehiculo {
    private String placa;
    private LocalDateTime fechaCirulacion;
    private String mensaje;
}
