import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "442500");
        Statement st = con.createStatement();
        //1.Example: Select the country names whose region id's are 1
        String sql1 ="SELECT country_name FROM countries WHERE region_id = 1";
        //If you use execute() method, you will get true or false as return. But I want to see the records.
        boolean result1 = st.execute(sql1);
        System.out.println("result1 = " + result1);
        //To see the records we have another method which is "executeQuery()".

        ResultSet resultSet1 = st.executeQuery(sql1);

        while (resultSet1.next()){
            System.out.println (resultSet1.getString("country_name"));
        }

        //2.Example: Select the country_id and country_name whose region_id's are greater than 2
        String sql2 ="SELECT country_id, country_name FROM countries WHERE region_id>2";
        ResultSet resultSet2 = st.executeQuery(sql2);

        while (resultSet2.next()){

            System.out.println(resultSet2.getString("country_id")+"->"+resultSet2.getString("country_name"));

        }

        //3.Example: Select the company whose number_of_employees is the lowest from companies table

        String sql3="SELECT company FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies );";
        ResultSet resultSet3 = st.executeQuery(sql3);
        resultSet3.next();
        System.out.println(resultSet3.getString("company"));
    }
}