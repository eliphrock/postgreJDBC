import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "442500");
        Statement st = con.createStatement();

       //1.Example: Select the country names whose region id's are 1
       String sql1="SELECT country_name FROM countries WHERE region_id= 1;";
       // if you use execute() method you will get true or false as return but I want to see the records

       boolean sqlResult1=st.execute(sql1);
        System.out.println("sqlResult1="+sqlResult1);

        //to see the records we have another methodwhich is "executeQuery()"

        ResultSet resultSet=st.executeQuery(sql1);
        while(resultSet.next()){
            System.out.println(resultSet.getString("country_name"));

        }

    }
}
