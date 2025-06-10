import java.sql.*;
public class DBConnect {
    public static void main(String[] args) {
        // JDBC URL, username and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "madhuri@123";
        // JDBC variables for opening, closing and managing connection
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
            // Execute a query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users");
            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
}