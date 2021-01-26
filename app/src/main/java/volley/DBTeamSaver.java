package volley;

import java.util.List;

public class DBTeamSaver {
    public void saveTeam (Team team) {
        saveTeamName(team.getTeamName());
        saveTeamSquad(team.getTeamSquad(), team.getTeamName());
    }

    private void saveTeamName(String teamName) {
        try {
            new DBQueries().executeUpdate("INSERT INTO Teams (team_name)\n" +
                    "VALUES ('" + teamName + "');");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void saveTeamSquad(List<Player> teamSquad, String teamName) {
        Player player;
        DBQueries dbQueries = new DBQueries();

        for (int i = 0; i < teamSquad.size(); i++) {
            player = teamSquad.get(i);
            try {
                dbQueries.executeUpdate("INSERT INTO Players(team_id, player_name, player_serve, player_attack) " +
                        "VALUES((SELECT team_id FROM Teams WHERE team_name = '" + teamName + "'), '" + player.getPlayerName() + "', " + player.getServeSkill() + ", " + player.getAttackSkill() + ");\n");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
