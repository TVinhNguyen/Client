package DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	    private static final String URL = "jdbc:mysql://localhost:3306/net";
	    private static final String USER = "root"; // MySQL username
	    private static final String PASSWORD = ""; // MySQL password

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
}
