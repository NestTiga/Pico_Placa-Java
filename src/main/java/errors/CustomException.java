package errors;

import lombok.Getter;

@Getter
public class CustomException extends Exception{
    private String codigo;
    public CustomException(String mensaje, String codigo) {
        super(mensaje);
        this.codigo = codigo;
    }
}
