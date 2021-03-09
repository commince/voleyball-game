package kryaskov.app.game;
import java.util.ArrayList;

public class ManualTeamBuilder extends TeamBuilder {
    private Team team = null;

    private PlayerBuilder builder;

    private static int index = 1;

    @Override
    public Team createTeam() {
        team = new Team();
        team.setTeamName(UserInput.userInput.userTeamName(index));
        createTeamSquad();
        return team;
    }

    @Override
    public Team createTeamForWeb(String userTeamName) {
        team = new Team();
        team.setTeamName(userTeamName);
        createTeamSquad();
        return team;
    }

    @Override
    public Team createTeamForWeb() {
        return team;
    }


    private void createTeamSquad() {
        builder = new AutomaticPlayerBuilder();
        team.teamSquad = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            team.teamSquad.add(builder.createAPlayer());
        }
    }
}
