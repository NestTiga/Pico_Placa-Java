package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    private String url = "jdbc:mysql://localhost:3306/db_mardis";
    private String user = "root";
    private String password = "root";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
