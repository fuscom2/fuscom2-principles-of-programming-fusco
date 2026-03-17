import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String url = args[0];
        String username = args[1];
        String password = args[2];

        Database db = new Database(url, username, password); // database initializer

        db.connect(); // connect to database

        try {
            String query = "SELECT o.order_no AS orderNumber, c.customer_name AS customerName, " +
                    "   c.city AS customerCity, s.name AS salesmanName, o.purchase_amt AS amount, " +
                    "s.commission AS commissionAmount FROM orders o INNER JOIN customer c ON o.customer_id=c.customer_id " +
                    "INNER JOIN salesman s ON o.salesman_id=s.salesman_id"; // query string

            ResultSet orders = db.query(query); // calls query method and passes query string which returns darta

            ArrayList<Sales> sales = new ArrayList<>(); // creates ArrayList for data

            while (orders.next()) { // loops for queried data and inserts Sales objects created from query data into ArrayList
                Sales sale = new Sales(orders.getInt("orderNumber"), orders.getString("customerName"), orders.getString("customerCity"), orders.getString("salesmanName"), orders.getFloat("amount"), orders.getFloat("commissionAmount"));

                sales.add(sale);
            }

            db.closeConnection(); // closes connection
        } catch (SQLException e) {
            System.err.println("Database connection failed:");
            e.printStackTrace();
        }
    }
}