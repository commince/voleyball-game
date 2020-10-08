package volley;
import java.sql.*;
import java.util.ArrayList;
import static volley.UserInput.userInput;

public class DBTeamBuilder extends TeamBuilder {
    private Team team;

    @Override
    public Team createTeam() {
        team = new Team();
        if (userInput.creationMethod(" по конкретному названию команды").equals("y")) {
            team.setTeamName(userInput.userTeamName());
        } else {
            team.setTeamName(extractTeamName());
        }
        createTeamSquad();
        return team;
    }

    private String extractTeamName() {
        String teamName = "";
        try {
            ResultSet result = new DBQuerries().implementQuerry("SELECT team_name \n" +
                    "FROM Teams \n" +
                    "ORDER BY RANDOM() limit 1;");
            result.next();
            teamName = result.getString(1);
        } catch (Exception e) {
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
