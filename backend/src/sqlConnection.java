import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class sqlConnection {
    //spring.datasource.url=jdbc:sqlserver://;serverName=uat.ifca.co.id;port=1436;databaseName=test;
     //jdbc:sqlserver://;servername=server_name;encrypt=true;integratedSecurity=true;authenticationScheme=JavaKerberos
    //"jdbc:sqlserver://<server>:<port>;encrypt=true;databaseName=AdventureWorks;user=<user>;password=<password>";
    static final String dburl = "jdbc:sqlserver://uat.ifca.co.id;databaseName=test";
//    static final String dburl = "jdbc:sqlserver://;serverName=uat.ifca.co.id;port=1436;databaseName=test";
    static final String USER = "mgr";
    static final String PASS = "mgr";
    static final String query = "SELECT * FROM mahasiswa";

    public static void main(String[] args) throws ClassNotFoundException {
        // Open a connection
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(dburl,USER,PASS);
            Statement statement = connection.createStatement();
            ResultSet ResultSet = statement.executeQuery(query);
            
            while (ResultSet.next()) {
                // Retrieve by column name
                System.out.println("nama" + ResultSet.getString("nama") );

            }
            
        } catch ( SQLException exception) {
          //  throw new RuntimeException(e);
            exception.printStackTrace();
        }


//        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
////        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String dburl = "jdbc:sqlserver://uat.ifca.co.id;databaseName=test";
//        String user = "mgr";
//        String pass = "mgr";
//
//        Connection connection = DriverManager.getConnection(dburl,user,pass);
//        Statement stat = connection.createStatement();
//        String query = "SELECT * FROM mahasiswa";
//        ResultSet rs = stat.executeQuery(query);
//
//    while (rs.next()) {
//        System.out.println("name: " + rs.getString("nama"));
//    }




    }
}
