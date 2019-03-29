package database;

import java.sql.*;

public class TableExistOrNot {

    public boolean tableExist(Connection conn, String tableName) throws SQLException {
        boolean tExists = false;
        DatabaseMetaData dbm = conn.getMetaData();
        try(ResultSet rs = dbm.getTables(null, null, tableName, null)){

            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");
                System.out.println(tName);
                if (tName != null && tName.equals(tableName)) {
                    tExists = true;
                    break;
                }
            }
        }
        return tExists;
    }
}