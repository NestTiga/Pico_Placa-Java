package controller;

import model.dto.DatosVehiculoDTO;
import service.AuditoriaVehiculoService;

public class AuditoriaVehiculoController {

    private final AuditoriaVehiculoService auditoriaVehiculoService;

    public AuditoriaVehiculoController(AuditoriaVehiculoService auditoriaVehiculoService) {
        this.auditoriaVehiculoService = auditoriaVehiculoService;
    }

    /**
     * Metodo que se encarga de auditar un vehiculo
     * @param datosVehiculoDTO objeto que contiene la placa y la fecha
     */
    public void auditarVehiculo(DatosVehiculoDTO datosVehiculoDTO) {
        auditoriaVehiculoService.auditarVehiculo(datosVehiculoDTO.getPlaca(), datosVehiculoDTO.getFechaHora());
    }
}
