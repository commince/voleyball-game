package volley;

import static volley.UserInput.userInput;

class Match { //Отвечает за последовательность и наполнение событий матча
    private static final Match match = new Match();

    static GameActions actions = new GameActions();
    static Team team1,
                team2;

    static int team1Point,
               team2Point;

    private TeamBuilder teamBuilder;

    private Match() { }

    public static Match getMatch() {
        return match;
    }

    public void go() {
        startMatch();
        gameAction();
        endOfGame();
    }

    private void startMatch() {
        System.out.println("Приветствуем на олимпийских играх! Сегодня нам предстоит лицезреть очень жаркий волейбольный матч!");

        createTeams();

        System.out.println("Встречаются команды: " + team1.getTeamName() + " и " + team2.getTeamName());
        System.out.println("");
    }

    private void createTeams() {
        team1 = createATeam();
        if(userInput.askForSave() && teamBuilder instanceof ManualTeamBuilder) new DBTeamSaver().saveTeam(team1);
        System.out.println("");

        team2 = createATeam();
        while (team2.getTeamName().equals(team1.getTeamName())) {
            System.out.println("Названия команд не могут быть одинаковыми, пересоздайте 2-ю команду.");
            team2 = createATeam();
        }
        if(userInput.askForSave() && teamBuilder instanceof ManualTeamBuilder) new DBTeamSaver().saveTeam(team2);
        System.out.println("");
    }

    private Team createATeam() {
        teamBuilder = userInput.creationMethod(" команды").equals("y") ? new DBTeamBuilder() : new ManualTeamBuilder();
        return teamBuilder.createTeam();
    }

    private void gameAction() {
        Rules gameRules = new Rules();
        while (team1Point < 15 && team2Point < 15) {
            gameRules.rallyResult(actions.makeServe());
        }
    }

    private void endOfGame() {
        System.out.println("Матч закончен!");
        System.out.print("Со счетом " + team1Point + ":" + team2Point);
        if (team1Point > team2Point) {
            System.out.println(" победила команда " + team1.getTeamName());
        } else {
            System.out.println(" победила команда " + team2.getTeamName());
        }
    }
}
