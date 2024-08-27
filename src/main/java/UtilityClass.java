import java.sql.*;
public class UtilityClass {
	    // JDBC URL, username, and password of MySQL server
	    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bank_management_system";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "rootmein@";

	    // Method to establish a database connection
	    public static Connection getConnection() throws SQLException {
	        try {
	            // Load the JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establish the connection
	            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	            
	            return connection;
	        } catch (ClassNotFoundException e) {
	            // Handle ClassNotFoundException
	            e.printStackTrace();
	            throw new SQLException("Database driver not found", e);
	        }
	    }
	}

		
