package util.validations;

public class Validar {
    public static boolean esPlacaValida(String placa) {
        return placa.matches("[A-Z]{3}-[0-9]{4}");
    }
}
