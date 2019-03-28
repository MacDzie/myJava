package database;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class ConnectDatabase {
    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");
            if (con!= null) {
                System.out.println("Polaczenie z baza danych nawiazane");
            } else {
                System.out.println("Problem z polaczeniem do bazy danych");
            }
        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace(System.out);
        }
    }
}
