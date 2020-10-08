package volley;
import java.util.ArrayList;
import static volley.UserInput.userInput;

public class ManualTeamBuilder extends TeamBuilder {
    private Team team;

    private PlayerBuilder builder;

    private static int index = 1;

    @Override
    public Team createTeam() {
        team = new Team();
        team.setTeamName(userInput.userTeamName(index));
        createTeamSquad();
        return team;
    }

    public void createTeamSquad() {
        builder = userInput.creationMethod(" игроков").equals("y") ? new AutomaticPlayerBuilder() : new ManualPlayerBuilder();
        team.teamSquad = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            team.teamSquad.add(builder.createAPlayer());
        }
    }
}
