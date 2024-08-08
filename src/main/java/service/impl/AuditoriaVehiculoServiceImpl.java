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
        String dia = fechaHora.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()); //Obtiene el dia de la fecha
        LocalTime hora = fechaHora.toLocalTime(); //Obtiene la hora de la fecha
        String mensaje = ""; //Mensaje que se guardara en la auditoria
        int ultimoDigito = Integer.parseInt(placa.substring(placa.length() - 1)); //Obtiene el ultimo digito de la placa

        switch (dia){
            case "lunes":
                if(ultimoDigito == 1 || ultimoDigito ==2){
                    mensaje = "Lunes: " + validarHorario(hora, placa);
                }else {
                    mensaje= "Lunes: " + GlobalMessage.SIN_PICO_PLACA;
                }
                break;
            case "martes":
                if(ultimoDigito == 3 || ultimoDigito == 4){
                    mensaje = "Martes: " + validarHorario(hora, placa);
                }else {
                    mensaje= "Martes: " + GlobalMessage.SIN_PICO_PLACA;
                }
                break;
            case "miércoles":
                if(ultimoDigito == 5 || ultimoDigito == 6){
                    mensaje = "Miércoles: " + validarHorario(hora, placa);
                }else {
                    mensaje= "Miércoles: " + GlobalMessage.SIN_PICO_PLACA;
                }
                break;
            case "jueves":
                if(ultimoDigito == 7 || ultimoDigito == 8){
                    mensaje = "Jueves: " + validarHorario(hora, placa);
                }else {
                    mensaje= "Jueves: " + GlobalMessage.SIN_PICO_PLACA;
                }
                break;
            case "viernes":
                if(ultimoDigito == 9 || ultimoDigito == 0){
                    mensaje = "Viernes: " + validarHorario(hora, placa);
                }else {
                    mensaje= "Viernes: " + GlobalMessage.SIN_PICO_PLACA;
                }
                break;
            case "sábado":
                mensaje = "Sábado: libre circulación";
                break;
            case "domingo":
                mensaje = "Domingo: libre circulación";
                break;
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
