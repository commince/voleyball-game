package volley;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static volley.Match.*;

public class DBQuerries {
    private Statement stmt;
    private Connection conn;

    public ResultSet implementQuerry(String querryText) {
        getConnection();
        ResultSet result = null;

        try {
            result = stmt.executeQuery(querryText);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public void executeUpdate(String querryText) {
        getConnection();
        try {
            stmt.executeUpdate(querryText);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void getConnection() {
        String url = getUrl();
        String user = getUser();
        String password = getPassword();

        try {
            Class.forName("org.postgresql.Driver");
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

    private String getUrl() {
        return "jdbc:postgresql://127.0.0.1:5432/volley_teams";
    }

    private String getUser() {
        return "postgres";
    }

    private String getPassword() {
        return "LENIN1988";
    }
}
