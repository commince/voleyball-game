package volley;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class DBQueries {
    static final String DRIVER = "org.postgresql.Driver",
                        url = "jdbc:postgresql://127.0.0.1:5432/volley_teams",
                        user = "postgres",
                        password = "LENIN1988";

    private Statement stmt;
    private Connection conn;

    public ResultSet implementQuery(String queryText) {
        ResultSet result = null;
        try {
            getConnection();
            result = stmt.executeQuery(queryText);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public void executeUpdate(String queryText) {
        try {
            getConnection();
            stmt.executeUpdate(queryText);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void getConnection() throws Exception {
        Exception connectionTrouble = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            connectionTrouble = ex;
            throw connectionTrouble;
        } finally {
            if (!(connectionTrouble == null)) {
                if (conn != null) conn.close();
            }
        }
    }

    private void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
