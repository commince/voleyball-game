package kryaskov.app.game;

import java.sql.ResultSet;

public class DBPlayerBuilder extends PlayerBuilder {
    private final ResultSet result;

    public DBPlayerBuilder(String teamName) {
        result = extractData(teamName);
    }

    @Override
    public Player createAPlayer() {
        Player player = new Player();

        try {
            result.next();
            player.setPlayerName(result.getString(1));
            player.setServeSkill(result.getDouble(2));
            player.setAttackSkill(result.getDouble(3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return player;
    }

    private ResultSet extractData(String teamName) {
        return new DBQueries().implementQuery("SELECT player_name, player_serve, player_attack\n" +
                "FROM Players, Teams\n" +
                "WHERE Players.team_id = Teams.team_id\n" +
                "AND team_name = '" + teamName + "';");
    }
}
