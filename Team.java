package volley;
import java.util.ArrayList;
import java.util.List;
import static volley.UserInput.userInput;

class Team {
    private String teamName;
    private List<Player> teamSquad;
    private PlayerBuilder builder;

    public void createTeam(int numOfTeam) {
        setTeamName(userInput.userTeamName(numOfTeam));
        createTeamSquad();
    }

    public void setTeamName(String gotUserTeamName) { teamName = gotUserTeamName; }

    public String getTeamName() {
        return teamName;
    }

    public void createTeamSquad() {
        creationMethod();
        teamSquad = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            teamSquad.add(builder.createAPlayer());
        }
    }

    private void creationMethod() {
        String howToCreate = userInput.getUserInput("Для автоматического создания игроков введите '0' и нажмите Enter:");
        if (howToCreate.equals("0")) {
            builder = new AutomaticPlayerBuilder();
        } else {
            builder = new ManualPlayerBuilder();
        }
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
