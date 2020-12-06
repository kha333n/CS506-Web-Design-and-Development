// File JdbcDmlEx.java
//step 1: import package
import java.sql.*;

public class JdbcDmlEx {

    public static void main(String args[]) {
        try {
//Step 2: load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//Step 3: define the connection URL
            String url = "jdbc:sqlserver://KHA333N\\SQLEXPRESS";
//Step 4: establish the connection
            Connection con = DriverManager.getConnection(url,"jdbc","jdbc");
//Step 5: create Statement
            Statement st = con.createStatement();

// assigning first command line argument value
            String addVar = args[0];
// assigning second command line argument value
            String nameVar = args[1];
// preparing query – nameVar & addVar strings are embedded
// into query within ‘" + string + "’
            String sql = "UPDATE Person SET address = '" + addVar + "'"
                    + " WHERE name = '" + nameVar + "' ";
            System.out.println(sql);
// executing query
            int num = st.executeUpdate(sql);
// Step 7: process the results of the query
// printing number of records affected
            System.out.println(num + " records updated");
//Step 8: close the connection
            con.close();
        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }
    } // end main
} // end class