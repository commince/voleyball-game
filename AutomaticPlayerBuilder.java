package volley;

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
        String[] names = {"Путин", "Лавров", "Шойгу", "Собянин", "Лукашенко", "Мутко", "Меркель", "Макрон", "Трамп", "Клинтон", "Обама", "Порошенко"};
        return names[index++];
    }
}
