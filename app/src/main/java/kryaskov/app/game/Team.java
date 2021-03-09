package kryaskov.app.game;
import java.util.List;

class Team {
    String teamName;
    List<Player> teamSquad;

    public void setTeamName(String gotTeamName) { teamName = gotTeamName; }

    public String getTeamName() {
        return teamName;
    }

    public List<Player> getTeamSquad() {
        return teamSquad;
    }

    public void positioningChange() {
        Player player = teamSquad.get(0);
        teamSquad.remove(0);
        teamSquad.add(player);
    }
}
