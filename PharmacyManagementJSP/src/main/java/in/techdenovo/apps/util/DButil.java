package in.techdenovo.apps.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

    public Connection getConnection() {

        String url = "jdbc:mysql://p1.techdenovo.in:3309/darshana_pharmacydb";
        String user = "darshana11022";
        String password = "N^0tbd0H6w0w";

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }
 }


