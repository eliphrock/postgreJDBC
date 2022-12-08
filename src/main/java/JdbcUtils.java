import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

    private  static Connection connection;
    public static Connection  connectToDataBase(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "442500");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
