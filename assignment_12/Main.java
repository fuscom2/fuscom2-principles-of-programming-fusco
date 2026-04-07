import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String url = "jdbc:mariadb://localhost:3306/labwork";
        String username = "javaConnector";
        String password = "password";

        Database db = new Database(url, username, password); // database initializer

        db.connect();

        try {
            String query = "SELECT s.name, s.city, s.commission, SUM(o.purchase_amt) AS sales FROM Salesman s INNER JOIN orders o ON s.salesman_id=o.salesman_id GROUP BY s.salesman_id";

            ResultSet salesPersonData = db.query(query);

            ArrayList<Salesman> salesPersonList = new ArrayList<>(); // creates ArrayList for data

            while (salesPersonData.next()) { // loops for queried data and inserts Sales objects created from query data into ArrayList
                Salesman salesman = new Salesman(salesPersonData.getString("name"), salesPersonData.getString("city"), salesPersonData.getDouble("commission"), salesPersonData.getDouble("sales"));

                salesPersonList.add(salesman);
            }

            db.closeConnection(); // closes connection

            System.out.printf("%-20s", "Name");
            System.out.print("| ");
            System.out.println("Sales");
            System.out.println("---------------------------------");

            salesPersonList.stream().forEach((s) -> {
                System.out.printf("%-20s", s.getName());
                System.out.print("| $");
                System.out.printf("%.2f", s.getSales());
                System.out.println();
            });

            System.out.println();

            System.out.printf("%-20s", "Name");
            System.out.print("| ");
            System.out.println("Commission Earned");
            System.out.println("----------------------------------------");

            salesPersonList.stream().forEach((s) -> {
                System.out.printf("%-20s", s.getName());
                System.out.print("| $");
                System.out.printf("%.2f", s.getSalesCommission());
                System.out.println();
            });

        } catch (SQLException e) {
            System.err.println("Database connection failed:");
            e.printStackTrace();
        }
    }
}