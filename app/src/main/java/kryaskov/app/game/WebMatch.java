package kryaskov.app.game;

import java.util.List;

public class WebMatch {
    static Team team1,
            team2;

    private static final WebMatch webMatch = new WebMatch();

    static final GameActions actions = new GameActions();

    static int team1Point,
            team2Point;

    private static String matchLog = "";

    private TeamBuilder teamBuilder;

    private WebMatch() { }

    public static WebMatch getWebMatch() {
        return webMatch;
    }

    public static String getMatchLog() {
        return matchLog;
    }

    public static void addLog(String textToAdd) {
        matchLog += textToAdd;
    }

    public static void clearLogs() {
        matchLog = "Hi everybody!";
    }



    public void createTeamsAutomatically() {
        teamBuilder = new DBTeamBuilder();
        team1 = teamBuilder.createTeamForWeb();
        team2 = teamBuilder.createTeamForWeb();
        while (team2.getTeamName().equals(team1.getTeamName())) {
            team2 = teamBuilder.createTeamForWeb();
        }
        System.out.println(team1.getTeamSquad().get(0).getPlayerName());
        System.out.println(team2.getTeamSquad().get(0).getPlayerName());

    }

    public void createTeamsAutomatically(String team1Name, String team2Name) {
        teamBuilder = new DBTeamBuilder();
        team1 = teamBuilder.createTeamForWeb(team1Name);
        team2 = teamBuilder.createTeamForWeb(team2Name);
        while (team2.getTeamName().equals(team1.getTeamName())) {
            team2 = teamBuilder.createTeamForWeb();
        }
    }

    public void createTeamsSemiAutomatically(String team1Name, String team2Name) {
        teamBuilder = new ManualTeamBuilder();
        team1 = teamBuilder.createTeamForWeb(team1Name);
        team2 = teamBuilder.createTeamForWeb(team2Name);
    }

    public void createTeamsManually(String team1Name, boolean saveTeam1, String team2Name, boolean saveTeam2,
                                    List<String> playerNames,
                                    List<String> serveSkills,
                                    List<String> attackSkills) {
        WebTeamBuilder webTeamBuilder = new WebTeamBuilder();
        team1 = webTeamBuilder.createTeam(team1Name, playerNames.subList(0, 6), serveSkills.subList(0, 6), attackSkills.subList(0, 6));
        team2 = webTeamBuilder.createTeam(team2Name, playerNames.subList(6, 12), serveSkills.subList(6, 12), attackSkills.subList(6, 12));
        if (saveTeam1) new DBTeamSaver().saveTeam(team1);
        if (saveTeam2) new DBTeamSaver().saveTeam(team2);
    }



    public void go() {
        startMatch();
        gameAction();
        endOfGame();
    }

    public void startMatch() {
        addLog("<p>Welcome to Olympic Games! Today we have a hot volleyball match!</p>");
        addLog("<p>It's a battle between: " + team1.getTeamName() + " and " + team2.getTeamName() + "</p>");
        addLog("<hr/>");
    }

    private void gameAction() {
        Rules gameRules = new Rules();
        while (team1Point < 15 && team2Point < 15) {
            gameRules.rallyResult(actions.makeServe());
        }
    }

    private void endOfGame() {
        addLog("<h3 style=\"color: brown\">That's it! Yeah.. what a match have we seen today! ");
        addLog("With the score " + team1Point + ":" + team2Point);
        if (team1Point > team2Point) {
            addLog(" the winner is " + team1.getTeamName() + "</h3>");
        } else {
            addLog(" the winner is " + team2.getTeamName() + "</h3>");
        }
        team1Point = 0;
        team2Point = 0;
    }
}
