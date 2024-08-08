package service;

import java.time.LocalDateTime;

public interface AuditoriaVehiculoService {
    void auditarVehiculo(String placa, LocalDateTime fechaHora);
}
