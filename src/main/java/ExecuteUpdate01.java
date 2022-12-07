import java.sql.*;

public class ExecuteUpdate01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "442500");
        Statement st = con.createStatement();


        //1.Example: Update the number of employees to 16000 if the number of employees is less than the average number of employees

        String sql1="UPDATE companies SET number_of_employees =16000 WHERE number_of_employees <(SELECT AVG(number_of_employees) FROM companies );";
        Integer numberOfRecords = st.executeUpdate(sql1);
        System.out.println("numberOfRecords="+numberOfRecords);

        String sql2="SELECT * FROM companies";
        ResultSet resultSet1=st.executeQuery(sql2);
        while(resultSet1.next()) {
            System.out.println(resultSet1.getInt("company_id")+" "+resultSet1.getString(2)+" "+resultSet1.getInt(3));
        }

        con.close();
        st.close();
    }
}
