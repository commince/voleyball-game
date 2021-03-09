package kryaskov.app.game;

public abstract class TeamBuilder {
    public abstract Team createTeam();
    public abstract Team createTeamForWeb();
    public abstract Team createTeamForWeb(String userTeamName);
}
