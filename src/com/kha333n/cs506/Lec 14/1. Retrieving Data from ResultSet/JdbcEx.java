// File JdbcEx.java
//step 1: import package

import java.sql.*;

public class JdbcEx {

    //Command to link class and run
    //java -cp .;mssql.jar JdbcEx

    public static void main(String args[]) {
        try {
//Step 2: load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//Step 3: define the connection URL
            String url = "jdbc:sqlserver://cs506db.database.windows.net:1433;database=personinfo;user=jdbc@cs506db;password=DB.for.Java;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//Step 4: establish the connection
            Connection con = DriverManager.getConnection(url);
//Step 5: create Statement
            Statement st = con.createStatement();
//Step 6: preapare & execute the query
            String sql = "SELECT * FROM Person";
            ResultSet rs = st.executeQuery(sql);
//Step 7: process the results
            while (rs.next()) {
// The row name is "name" in database "PersonInfo,
// hence specified in the getString() method.
                String name = rs.getString("name");
                String add = rs.getString("address");
                String pNum = rs.getString("phoneNum");
                System.out.println(name + " " + add + " " + pNum);
            }
//Step 8: close the connection
            con.close();
        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }
    } // end main
} // end class