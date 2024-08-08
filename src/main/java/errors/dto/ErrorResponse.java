package errors.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor // genera un constructor con todos los atributos de la clase
public class ErrorResponse {
    private String codigo;
    private String mensaje;

    @Override
    public String toString() {
        return "Error{" +
                "\ncodigo: " + codigo + ","  +
                "\nmensaje: " + mensaje +
                "\n}";
    }
}
