package kryaskov.app.game;

public class AutomaticPlayerBuilder extends PlayerBuilder {
    private static int index = 0;

    @Override
    public Player createAPlayer() {
        Player player = new Player();
        player.setPlayerName(playerNaming());
        player.setServeSkill(Math.random());
        player.setAttackSkill(Math.random());
        return player;
    }

    private String playerNaming() {
        if (index == 12) index = 0;
        String[] names = {"F. Kirkorov", "A. Einstein", "N. Tesla", "J. Belushi", "A.S. Pushkin", "A. Schwarzenegger",
                    "Peter I", "V. Tsoy", "Papa Karlo", "Kolobok", "Batman", "Lomonosov"};
        return names[index++];
    }
}
