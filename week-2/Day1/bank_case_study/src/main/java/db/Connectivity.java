package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class Connectivity {
    private final Connection connection;

    public Connectivity() throws SQLException {
        new Driver();

        connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/week1_case_study_db",
                "root",
                "password"
        );
        connection.setAutoCommit(false);
        System.out.println("----Connected to MYSQL Successfully");
    }

    public Connection getconnection() {
        return connection;
    }
}
