package kryaskov.app.game;

import static kryaskov.app.game.Match.*;


class Rules { //Отвечает за правила игры

    public void rallyResult(String typeOfServe) {
        if (typeOfServe.equals("Эйс")) {
            System.out.println("С приемом беда, это ээээээйс!");
            countScore();
        }
        if (typeOfServe.equals("Подача в сеть")) {
            System.out.println("Кажется, у кого-то упадок сил, мяч не долетел до противоположной половины площадки и угодил в сеть");
            ActionEnums.whoServes = ActionEnums.whoServes.opposite();
            ActionEnums.whoServes.getServingTeam().positioningChange();
            countScore();
        }
        if (typeOfServe.equals("Аут")) {
            System.out.println("У подающего слегка сбит прицел, мяч в ауте");
            ActionEnums.whoServes = ActionEnums.whoServes.opposite();
            ActionEnums.whoServes.getServingTeam().positioningChange();
            countScore();
        }
        if (typeOfServe.equals("Мяч принят")) {
            System.out.println("Отличный прием, посмотрим, удастся ли реализовать атаку..");
            ActionEnums.whoAttacks = ActionEnums.whoServes == ActionEnums.ServeOrder.TEAM1_SERVES ? ActionEnums.AttackOrder.TEAM2_ATTACKS : ActionEnums.AttackOrder.TEAM1_ATTACKS;
            attackResult(actions.makeAttack());
        }
    }

    public void attackResult(String typeOfAttack) {
        if (typeOfAttack.equals("Удар в аут")) {
            System.out.println("Нападающий испугался блока, пробил мимо него... но и мимо площадки.. мяч в ауте");
            ActionEnums.whoServes.afterNegativeAttack();
            countScore();
        }
        if (typeOfAttack.equals("Блок")) {
            System.out.println("Блокирующие установили стену");
            ActionEnums.whoServes.afterNegativeAttack();
            countScore();
        }
        if (typeOfAttack.equals("Защита тащит")) {
            System.out.println("Защита сработала на ура, посмотрим на ответную атаку..");
            ActionEnums.whoAttacks = ActionEnums.whoAttacks.opposite();
            attackResult(actions.makeAttack());
        }
        if (typeOfAttack.equals("Блок-аут")) {
            System.out.println("Блокирующие хороши, но такого хитрого лиса попробуй останови - отыгрался от блока как семачку скушал");
            ActionEnums.whoServes.afterPositiveAttack();
            countScore();
        }
        if (typeOfAttack.equals("3 метра")) {
            System.out.println("Баааауууу! Мощный удар в 3-й метр.. мяч где-то под потолком");
            ActionEnums.whoServes.afterPositiveAttack();
            countScore();
        }
    }

    public void countScore() {
        if (ActionEnums.whoServes == ActionEnums.ServeOrder.TEAM1_SERVES) {
            team1Point++;
        } else {
            team2Point++;
        }
        System.out.println(" ");
        System.out.println("Счет: " + team1Point + ":" + team2Point);
        System.out.println(" ");
    }
}
