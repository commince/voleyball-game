package kryaskov.app.game;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class DBQueries {
    static final String DRIVER = "org.postgresql.Driver",
                        url = "jdbc:postgresql://127.0.0.1:5432/volley_teams",
                        user = "postgres",
                        password = "Lenin1988";

    private Statement stmt;
    private Connection conn;

    public ResultSet implementQuery(String queryText) {
        getConnection();
        ResultSet result = null;
        try {
            result = stmt.executeQuery(queryText);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public void executeUpdate(String queryText) {
        getConnection();
        try {
            stmt.executeUpdate(queryText);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void getConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
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
