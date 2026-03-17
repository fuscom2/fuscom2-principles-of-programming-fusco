import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
    private String url;
    private String user;
    private String password;

    private Connection conn;

    /*
        Stores database information in class
     */
    public Database(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /*
        Creates and stores database connection
     */
    public void connect() {
        try {
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Connect failed:");
            e.printStackTrace();
        }
    }

    /*
        Closes database connection
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Database connection failed:");
            e.printStackTrace();
        }
    }

    /*
        Queries and returns data
     */
    public ResultSet query(String query) {
        try {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException e) {
            System.err.println("Query failed:");
            e.printStackTrace();
        }

        return null;
    }
}
