package database;

import web.servlets.AllUsersServlet;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

public class SelectDB {

    public void select(){
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");

            stmt = con.createStatement();
            result = stmt.executeQuery("SELECT Username FROM users");

            while(result.next()){
                result.getString("Username");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
