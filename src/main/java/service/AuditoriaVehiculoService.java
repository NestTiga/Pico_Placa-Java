package service;

import java.time.LocalDateTime;

public interface AuditoriaVehiculoService {
    boolean auditarVehiculo(String placa, LocalDateTime fechaHora);
}
