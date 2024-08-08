package service.impl;

import dao.AuditoriaVehiculoDAO;
import model.AuditoriaVehiculo;
import service.AuditoriaVehiculoService;
import util.constants.Horarios;
import util.messages.GlobalMessage;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

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
    public void auditarVehiculo(String placa, LocalDateTime fechaHora) {
        String dia = fechaHora.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
        LocalTime hora = fechaHora.toLocalTime();
        String mensaje = "";

        if(dia.equals("sábado") || dia.equals("domingo")){
            mensaje = dia + ": libre circulación";
        } else {
            mensaje = dia + ": " + validarHorario(hora, placa);
        }

        AuditoriaVehiculo insertarAuditoria = AuditoriaVehiculo.builder()
                .placa(placa)
                .fechaCirulacion(fechaHora)
                .mensaje(mensaje)
                .build();
        auditoriaVehiculoDAO.guardarAuditoria(insertarAuditoria);
    }

    public String validarHorario(LocalTime hora, String placa){
        if ((hora.isAfter(Horarios.HORA_MADRUGADA_INICIO) && hora.isBefore(Horarios.HORA_MADRUGADA_FIN)) ||
                (hora.isAfter(Horarios.HORA_TARDE_INICIO) && hora.isBefore(Horarios.HORA_TARDE_FIN))){
            return GlobalMessage.CIRCULACION_DENEGADA.concat(placa);
        } else {
            return GlobalMessage.CIRCULACION_APROBADA.concat(placa);
        }
    }
}
