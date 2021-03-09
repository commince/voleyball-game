package kryaskov.app.game;

import java.util.ArrayList;
import java.util.List;

public class WebTeamBuilder {
    private Team team = null;

    public Team createTeam(String teamName, List<String> playerNames, List<String> servSkills, List<String> attackSkills) {
        team = new Team();
        team.setTeamName(teamName);
        team.teamSquad = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Player player = new Player();
            player.setPlayerName(playerNames.get(i));
            player.setServeSkill(Double.parseDouble(servSkills.get(i)));
            player.setAttackSkill(Double.parseDouble(attackSkills.get(i)));
            team.teamSquad.add(player);
        }
        return team;
    }

}
