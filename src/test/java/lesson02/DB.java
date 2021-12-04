package lesson02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private static String dbUrl = "jdbc:mysql://remotemysql.com:3306/HgcKGz4q8T";
    private static String username = "HgcKGz4q8T";
    private static String password = "7hcxrXoHQZ";
    private static ResultSet rs;
    private static Connection con;
    private static Statement stmt;

    public static void initSQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, username, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
    }

    public static List<String> getCredentials() {
        List<String> credentials = new ArrayList<String>();
        try {
            rs = stmt.executeQuery("SELECT user_name,password FROM Users WHERE user_name='admin'");
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        } catch (SQLException e) {
            System.out.println("Error Occured While Printing Table Data, See Details: " + e);
        }
        return credentials;
    }

    public static void closeDBCon() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error Occured While Closing JDBC, See Details: " + e);
        }
    }


}
