package volley;

import java.util.List;

public class DBTeamSaver {
    public void saveTeam (Team team) {
        saveTeamName(team.getTeamName());
        saveTeamSquad(team.getTeamSquad(), team.getTeamName());
    }

    private void saveTeamName(String teamName) {
        try {
            new DBQuerries().executeUpdate("INSERT INTO Teams (team_name)\n" +
                    "VALUES ('" + teamName + "');");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void saveTeamSquad(List teamSquad, String teamName) {
        Player player;
        DBQuerries dbQuerries = new DBQuerries();

        for (int i = 0; i < teamSquad.size(); i++) {
            player = (Player) teamSquad.get(i);
            try {
                dbQuerries.executeUpdate("INSERT INTO Players(team_id, player_name, player_serve, player_attack)\n" +
                        "VALUES((SELECT team_id FROM Teams WHERE team_name = '" + teamName + "'), '" + player.getPlayerName() + "', " + player.getServeSkill() + ", " + player.getAttackSkill() + ");\n");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
