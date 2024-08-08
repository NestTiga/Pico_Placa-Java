package util;

import errors.CustomException;
import errors.dto.ErrorResponse;
import lombok.NoArgsConstructor;
import model.dto.DatosVehiculoDTO;
import util.validations.Validar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Clase para pedir datos al usuario del sistema para la auditoria de vehiculos
 */
@NoArgsConstructor
public class PedirDatos {
    private final Scanner sc= new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


    public DatosVehiculoDTO solicitarDatos() {
        try {
            DatosVehiculoDTO datos= DatosVehiculoDTO.builder()
                    .placa(solicitarPlaca())
                    .fechaHora(LocalDateTime.parse(solicitarFecha()+"T"+solicitarHora(), formatter))
                    .build();
            return datos;
        }catch (CustomException e) {
            ErrorResponse errorResponse= new ErrorResponse(e.getCodigo(), e.getMessage());
            System.out.println(errorResponse);
            return solicitarDatos();
        }

    }

    private String solicitarPlaca() throws CustomException {
        System.out.println("Ingrese la placa del vehiculo");
        System.out.println("Ejemplo: ABC-1234");
        String placa = sc.nextLine();
        if (Validar.esPlacaValida(placa))
            return placa;
        else {
            throw new CustomException("La placa ingresada no es valida", "400");
        }
    }

    private String solicitarFecha(){
        System.out.println("Ingrese la fecha de circulacion del vehiculo en formato año-mes-dia");
        System.out.println("Ejemplos: 2024-12-31 o 2024-08-09");
        String fecha = sc.nextLine();
        return fecha;
    }

    private String solicitarHora(){
        System.out.println("Ingrese la hora de circulacion del vehiculo en formato hora:minutos:segundos");
        System.out.println("Ejemplos: 13:30:00 o 08:05:20");
        String hora = sc.nextLine();
        return hora;
    }

}
