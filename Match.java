package volley;

class Match { //Отвечает за последовательность и наполнение событий матча
    private static Match match = new Match();

    static GameActions actions = new GameActions();
    static Team team1;
    static Team team2;
    static int team1Point;
    static int team2Point;

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
        System.out.println("Приветствуем на молдавских играх! Сегодня нам предстоит лицезреть очень жаркий волейбольный матч!!");

        team1 = new Team();
        team1.createTeam(1);
        System.out.println("");

        team2 = new Team();
        team2.createTeam(2);
        System.out.println("");

        System.out.println("Встречаются команды: " + team1.getTeamName() + " и " + team2.getTeamName());
        System.out.println("");
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
