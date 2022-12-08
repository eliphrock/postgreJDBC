import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {

        //1. Step: Registration to the driver
        //2. Step: Create connection with database
        JdbcUtils.connectToDatabase("localhost","postgres","postgres","442500");

        //3. Step: Create statement
        JdbcUtils.createStatement();

        //4. Step: Execute the query
        JdbcUtils.createTable("Students","name VARCHAR(20)","id INT","address VARCHAR(50)","tel BIGINT");

        JdbcUtils.insertDataIntoTable("Students","name 'John'");

        JdbcUtils.dropTable("Students");

        //5. Step: Close the connection and statement
        JdbcUtils.closeConnectionAndStatement();



    }
}