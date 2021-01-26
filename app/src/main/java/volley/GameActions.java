package volley;

import static volley.ActionEnums.*;
import static volley.UserInput.userInput;
import static volley.Match.*;

public class GameActions {

    public String makeServe() {
        if (team1Point == 0 && team2Point == 0) serveLot(); //Выбор первого подающего по жребию

        if (whoServes == ActionEnums.ServeOrder.TEAM1_SERVES) {
            System.out.println("Подает " + team1.getTeamSquad().get(0).getPlayerName() + " из команды " + team1.getTeamName());
        } else {
            System.out.println("Подает " + team2.getTeamSquad().get(0).getPlayerName() + " из команды " + team2.getTeamName());
        }

        String[] serveType = {"Подача в сеть", "Аут", "Мяч принят", "Эйс"};
        System.out.print("Для подачи ");

        userInput.makeTry(); //Вовлечение юзера в игровой процесс :)
        int index;
        if (whoServes == ActionEnums.ServeOrder.TEAM1_SERVES) { //Чем выше скил подающего, тем больше вероятность подачи (на эйс способны игроки со скилом подачи более 0,5)
            index = (int) Math.round(Math.round(Math.random()*(serveType.length-2)) + team1.getTeamSquad().get(0).getServeSkill());
        } else {
            index = (int) Math.round(Math.round(Math.random()*(serveType.length-2)) + team2.getTeamSquad().get(0).getServeSkill());
        }

        return serveType[index];
    }

    private void serveLot() {
        double lot = Math.random();
        if (lot < 0.5) {
            whoServes = ActionEnums.ServeOrder.TEAM1_SERVES;
        } else {
            whoServes = ActionEnums.ServeOrder.TEAM2_SERVES;
        }
    }

    public String makeAttack() {
        String[] attackType = {"Удар в аут", "Блок", "Защита тащит", "Блок-аут", "3 метра"};

        System.out.print("Для атаки ");
        userInput.makeTry(); //Вовлечение юзера в игровой процесс :)

        int index;
        if (whoAttacks == ActionEnums.AttackOrder.TEAM1_ATTACKS) { //Формула позволяет реализовать логику "чем выше разница скилов атакующего и блокирующих (усредненный скил троих блокирующих), тем выше вероятность реализации атаки"
            index = (int) Math.round(Math.round(Math.random()*(attackType.length-2)) + team1.getTeamSquad().get((int)(Math.random()*2)+1).getAttackSkill() - ((team2.getTeamSquad().get(1).getDefenceSkill() + team2.getTeamSquad().get(2).getDefenceSkill() + team2.getTeamSquad().get(3).getDefenceSkill())/3));
        } else {
            index = (int) Math.round(Math.round(Math.random()*(attackType.length-2)) + team2.getTeamSquad().get((int)(Math.random()*2)+1).getAttackSkill() - ((team1.getTeamSquad().get(1).getDefenceSkill() + team1.getTeamSquad().get(2).getDefenceSkill() + team1.getTeamSquad().get(3).getDefenceSkill())/3));
        }
        if (index < 0) index = 0;

        return attackType[index];
    }

}
