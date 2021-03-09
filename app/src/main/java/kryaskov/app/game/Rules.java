package kryaskov.app.game;

import static kryaskov.app.game.WebMatch.*;


class Rules { //Отвечает за правила игры

    public void rallyResult(String typeOfServe) {
        if (typeOfServe.equals("Эйс")) {
            WebMatch.addLog("<p>Oh my Goodness! What a power! Aaaaace!</p>");
            countScore();
        }
        if (typeOfServe.equals("Подача в сеть")) {
            WebMatch.addLog("<p>Seems like the player hasn't ate before the match. The ball is in the net.</p>");
            ActionEnums.whoServes = ActionEnums.whoServes.opposite();
            ActionEnums.whoServes.getServingTeam().positioningChange();
            countScore();
        }
        if (typeOfServe.equals("Аут")) {
            WebMatch.addLog("<p>The server is slightly out of sight.. it is out</p>");
            ActionEnums.whoServes = ActionEnums.whoServes.opposite();
            ActionEnums.whoServes.getServingTeam().positioningChange();
            countScore();
        }
        if (typeOfServe.equals("Мяч принят")) {
            WebMatch.addLog("<p>Nice reception! Let's see how strong is their attack..</p>");
            ActionEnums.whoAttacks = ActionEnums.whoServes == ActionEnums.ServeOrder.TEAM1_SERVES ? ActionEnums.AttackOrder.TEAM2_ATTACKS : ActionEnums.AttackOrder.TEAM1_ATTACKS;
            attackResult(actions.makeAttack());
        }
    }

    public void attackResult(String typeOfAttack) {
        if (typeOfAttack.equals("Удар в аут")) {
            WebMatch.addLog("<p>The spiker is scared of block. He hits beside the blockers ... but beside the court as well.. the ball is out</p>");
            ActionEnums.whoServes.afterNegativeAttack();
            countScore();
        }
        if (typeOfAttack.equals("Блок")) {
            WebMatch.addLog("<p>The attack is never gonna pass when the block looks like a wall.</p>");
            ActionEnums.whoServes.afterNegativeAttack();
            countScore();
        }
        if (typeOfAttack.equals("Защита тащит")) {
            WebMatch.addLog("<p>Great defence! How will they organize the retaliatory attack..</p>");
            ActionEnums.whoAttacks = ActionEnums.whoAttacks.opposite();
            attackResult(actions.makeAttack());
        }
        if (typeOfAttack.equals("Блок-аут")) {
            WebMatch.addLog("<p>The block was good enough but it couldn't stop such a sly fox. Block-out.</p>");
            ActionEnums.whoServes.afterPositiveAttack();
            countScore();
        }
        if (typeOfAttack.equals("3 метра")) {
            WebMatch.addLog("<p>What a monster attack! A powerful 3rd-meter spike.. and the ball is somewhere under the hall vaults.</p>");
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
        WebMatch.addLog("<br/>");
        WebMatch.addLog("<p> The score is " + team1Point + ":" + team2Point + "</p>");
        WebMatch.addLog("<br/>");
    }
}
