package service.impl;

import dao.AuditoriaVehiculoDAO;
import model.AuditoriaVehiculo;
import service.AuditoriaVehiculoService;

import java.time.LocalDateTime;

public class AuditoriaVehiculoServiceImpl implements AuditoriaVehiculoService {

    private final AuditoriaVehiculoDAO auditoriaVehiculoDAO;

    public AuditoriaVehiculoServiceImpl() {
        this.auditoriaVehiculoDAO = new AuditoriaVehiculoDAO();;
    }

    /**
     * Metodo que se encarga de auditar un vehiculo y guardar la auditoria segun la placa y la fecha
     * @param placa
     * @param fechaHora
     * @return
     */
    @Override
    public boolean auditarVehiculo(String placa, LocalDateTime fechaHora) {

        AuditoriaVehiculo insertarAuditoria = AuditoriaVehiculo.builder()
                .placa(placa)
                .fechaCirulacion(fechaHora)
                .mensaje("Tal vez si funcione")
                .build();

        auditoriaVehiculoDAO.guardarAuditoria(insertarAuditoria);

        return false;
    }
}
