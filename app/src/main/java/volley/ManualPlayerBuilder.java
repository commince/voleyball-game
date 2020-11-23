package volley;
import static volley.UserInput.userInput;

public class ManualPlayerBuilder extends PlayerBuilder {
    private static int index = 1;

    @Override
    public Player createAPlayer() {
        Player player = new Player();
        player.setPlayerName(userInput.userPlayerName(index));
        System.out.println("Задайте скилы подачи и атаки игрока. Скил защиты будет вычислен автоматически как добавление суммы скилов до 2");
        player.setServeSkill(userInput.userSkills("подачи", index));
        player.setAttackSkill(userInput.userSkills("атаки", index));

        index++;
        if (index > 6) index = 1;

        return player;
    }
}
