import dao.AuditoriaVehiculoDAO;
import model.AuditoriaVehiculo;
import model.dto.DatosVehiculoDTO;
import util.PedirDatos;

public class Main {
    public static void main(String[] args) {

        PedirDatos pedirDatos = new PedirDatos();
        DatosVehiculoDTO datosVehiculoDTO = pedirDatos.solicitarDatos();
        AuditoriaVehiculo insertarAuditoria = AuditoriaVehiculo.builder()
                .placa(datosVehiculoDTO.getPlaca())
                .fechaCirulacion(datosVehiculoDTO.getFechaHora())
                .mensaje("Vehiculo no puede circular por pico y placa")
                .build();

        AuditoriaVehiculoDAO objAuditoriaVehiculoDAO = new AuditoriaVehiculoDAO();
        objAuditoriaVehiculoDAO.guardarAuditoria(insertarAuditoria);
    }
}
