package dao;

import lombok.RequiredArgsConstructor;
import model.AuditoriaVehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AuditoriaVehiculoDAO {

    private final ConnectionDb databaseConnection;

    public AuditoriaVehiculoDAO() {
        this.databaseConnection = new ConnectionDb();
    }

    public void guardarAuditoria(AuditoriaVehiculo datosAuditoria) {
        String sql = "INSERT INTO auditoria_vehiculos (placa, fecha_hora, mensaje) VALUES (?, ?, ?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, datosAuditoria.getPlaca());
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(datosAuditoria.getFechaCirulacion()));
            statement.setString(3, datosAuditoria.getMensaje());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Auditoría insertada correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar la auditodia: " + e.getMessage());
        }
    }
}
