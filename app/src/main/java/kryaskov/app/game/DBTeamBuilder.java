package kryaskov.app.game;
import java.sql.*;
import java.util.ArrayList;

public class DBTeamBuilder extends TeamBuilder {
    private Team team;

    @Override
    public Team createTeam() {
        team = new Team();
        if (UserInput.userInput.creationMethod(" по конкретному названию команды").equals("y")) {
            team.setTeamName(UserInput.userInput.userTeamName());
        } else {
            team.setTeamName(extractTeamName());
        }
        createTeamSquad();
        return team;
    }

    private String extractTeamName() {
        String teamName = "";

        ResultSet result = new DBQueries().implementQuery("SELECT team_name \n" +
                "FROM Teams \n" +
                "ORDER BY RANDOM() limit 1;");
        try {
            result.next();

            teamName = result.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teamName;
    }

    public void createTeamSquad() {
        DBPlayerBuilder playerBuilder = new DBPlayerBuilder(team.getTeamName());
        team.teamSquad = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            team.teamSquad.add(playerBuilder.createAPlayer());
        }
    }
}
