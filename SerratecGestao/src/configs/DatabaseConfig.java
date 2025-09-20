package configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL = "jdbc:postgresql://ep-sparkling-fire-adja05zj-pooler.c-2.us-east-1.aws.neon.tech/neondb?sslmode=require";
    private static final String USER = "neondb_owner";
    private static final String PASSWORD = "npg_fbQuxR50aIng";

    static {
        try {
            Class.forName("org.postgresql.Driver"); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Driver PostgreSQL não encontrado!");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
