import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "442500");
        Statement st = con.createStatement();

        //1.Example: Update the number of employees to 9999 if the company name is IBM by using prepared statement
        //1st step create prepared statement query
        String sql="UPDATE companies SET number_of_employees =? WHERE COMPANY=?;";
        //2nd step create prepared statement object
        PreparedStatement preparedStatement= con.prepareStatement(sql);

        //3rd step  assign the values by using  setInt(),setString()...() methods.
        preparedStatement.setInt(1,9999);
        preparedStatement.setString(2,"IBM");

        //4rd step execute the query

        int numberOfRecordsUpdated=preparedStatement.executeUpdate();
        System.out.println("numberOfRecordsUpdated="+numberOfRecordsUpdated);

        String sql2="SELECT * FROM companies";
        ResultSet resultSet1=st.executeQuery(sql2);
        while(resultSet1.next()){

            System.out.println(resultSet1.getInt(1)+" "+resultSet1.getString(2)+" "+resultSet1.getInt(3));

        }

        //2.Example: Update the number of employees to 5555 if the company name is GOOGLE by using prepared statement
        preparedStatement.setInt(1,5555);
        preparedStatement.setString(2,"GOOGLE");

        int numberOfRecordsUpdated1=preparedStatement.executeUpdate();
        System.out.println("numberOfRecordsUpdated1="+numberOfRecordsUpdated1);

        String sql3="SELECT * FROM companies";
        ResultSet resultSet2=st.executeQuery(sql3);
        while(resultSet2.next()){

            System.out.println(resultSet2.getInt(1)+" "+resultSet2.getString(2)+" "+resultSet2.getInt(3));

        }
        con.close();
        st.close();
        preparedStatement.close();
    }
}
