package app;

import controller.AuditoriaVehiculoController;
import lombok.NoArgsConstructor;
import model.dto.DatosVehiculoDTO;
import service.AuditoriaVehiculoService;
import service.impl.AuditoriaVehiculoServiceImpl;
import util.PedirDatos;

@NoArgsConstructor
public class EjecutarApp {

    public static void ejecutar() {
        PedirDatos pedirDatos = new PedirDatos(); // Clase que se encarga de pedir los datos
        DatosVehiculoDTO datosVehiculoDTO = pedirDatos.solicitarDatos(); // Se piden los datos al usuario y retorna un objeto DatosVehiculoDTO
        AuditoriaVehiculoService auditoriaVehiculoService = new AuditoriaVehiculoServiceImpl(); // Se crea una instancia de AuditoriaVehiculoService
        AuditoriaVehiculoController auditoriaVehiculoController = new AuditoriaVehiculoController(auditoriaVehiculoService); // Se crea una instancia de AuditoriaVehiculoController y se le pasa el servicio
        auditoriaVehiculoController.auditarVehiculo(datosVehiculoDTO); // Se llama al metodo auditarVehiculo de AuditoriaVehiculoController y se le pasa el objeto DatosVehiculoDTO
    }
}
