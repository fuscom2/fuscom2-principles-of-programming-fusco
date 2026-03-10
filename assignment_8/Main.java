//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a language: ");
        String language = s.nextLine();

        String url = "jdbc:mariadb://localhost:3306/nation";
        String user = "fusco";
        String password = "happinen";

        Database database = new Database(url, user, password);

        String query = "SELECT c.name AS Country FROM countries c INNER JOIN country_languages cl ON c.country_id=cl.country_id INNER JOIN languages l ON cl.language_id=l.language_id WHERE l.language='" + language + "'";

        database.connect();

        try {
            ResultSet rs = database.query(query);

            while (rs.next()) {
                System.out.println(rs.getString("Country"));
            }
        } catch (SQLException e) {
            System.err.println("Database connection failed:");
            e.printStackTrace();
        }

        database.closeConnection();

        /*
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String query = "SELECT c.name AS Country FROM countries c INNER JOIN country_languages cl ON c.country_id=cl.country_id INNER JOIN languages l ON cl.language_id=l.language_id WHERE l.language='" + language + "'";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("Country"));
            }

        } catch (SQLException e) {
            System.err.println("Database connection failed:");
            e.printStackTrace();
        }*/
    }
}