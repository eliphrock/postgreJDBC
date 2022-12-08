import java.sql.*;

public class CallableStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "442500");
        Statement st = con.createStatement();

        //1.Example: Create a function which uses 2 parameters and return the sum of the parameters
        //1st step: type code to create function
        String sql1="CREATE OR REPLACE FUNCTION additionF(x NUMERIC, y NUMERIC) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN RETURN x + y; END $$";

        //2nd step: execute the function
        st.execute(sql1);

        //3rd step: call the function

        CallableStatement cst1=con.prepareCall("{?=call additionF(?,?)}");

        //4th step: Use registerOutParameter() method to get result container,use set() method for parameters

        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,6);
        cst1.setInt(3,4);

        // 5th step: execute the callable statement/use execute () method to get result for the specific values

        cst1.execute();

        //6th step: to see the results on console  use "sout"
        System.out.println(cst1.getObject(1));



        //2.Example: Create a function which calculates the value of cone

        //1st step: type code to create function
        String sql2="CREATE OR REPLACE FUNCTION volumeOfConeFunction(r NUMERIC, h NUMERIC) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN RETURN 3.14*r*r*h/3; END $$";

        //2nd step: execute the function
        st.execute(sql2);

        //3rd step: call the function

        CallableStatement cst2=con.prepareCall("{?=call volumeOfConeFunction(?,?)}");

        //4th step: Use registerOutParameter() method to get result container,use set() method for parameters

        cst2.registerOutParameter(1,Types.NUMERIC);
        cst2.setInt(2,2);
        cst2.setInt(3,5);

        // 5th step: execute the callable statement/use execute () method to get result for the specific values

        cst2.execute();

        //6th step: to see the results on console  use "sout"
        System.out.printf("%.2f",cst2.getObject(1));

        con.close();
        st.close();
        cst1.close();
        cst2.close();

    }
}
