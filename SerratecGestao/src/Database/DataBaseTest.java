package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseTest {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://ep-sparkling-fire-adja05zj-pooler.c-2.us-east-1.aws.neon.tech/neondb?sslmode=require";
        String user = "neondb_owner";
        String password = "npg_fbQuxR50aIng";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("✅ Conectado ao banco com sucesso!");

            ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                System.out.println("Clientes: \n" + rs.getString("id_cliente") + " | " + rs.getString("nome") + " | " + rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	}
