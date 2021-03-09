package kryaskov.app.game;

import static kryaskov.app.game.WebMatch.team2;
import static kryaskov.app.game.WebMatch.team1;

public class ActionEnums {
    enum ServeOrder {
        TEAM1_SERVES, TEAM2_SERVES;
        public ServeOrder opposite() { return this == TEAM1_SERVES ? TEAM2_SERVES : TEAM1_SERVES; }

        public Team getServingTeam() { return this == TEAM1_SERVES ? team1 : team2; }

        public void afterNegativeAttack() {
            if (whoServes.equals(TEAM1_SERVES) && whoAttacks.equals(AttackOrder.TEAM1_ATTACKS)) team2.positioningChange();
            if (whoServes.equals(TEAM2_SERVES) && whoAttacks.equals(AttackOrder.TEAM2_ATTACKS)) team1.positioningChange();

            whoServes = whoAttacks == AttackOrder.TEAM1_ATTACKS ? ServeOrder.TEAM2_SERVES : ServeOrder.TEAM1_SERVES;
        }

        public void afterPositiveAttack() {
            if (whoServes.equals(TEAM1_SERVES) && whoAttacks.equals(AttackOrder.TEAM2_ATTACKS)) team2.positioningChange();
            if (whoServes.equals(TEAM2_SERVES) && whoAttacks.equals(AttackOrder.TEAM1_ATTACKS)) team1.positioningChange();

            whoServes = whoAttacks.equals(AttackOrder.TEAM1_ATTACKS) ? ServeOrder.TEAM1_SERVES : ServeOrder.TEAM2_SERVES;
        }
    }

    enum AttackOrder {
        TEAM1_ATTACKS, TEAM2_ATTACKS;
        public AttackOrder opposite() { return this.equals(TEAM1_ATTACKS) ? TEAM2_ATTACKS : TEAM1_ATTACKS; }
    }

    static ServeOrder whoServes;
    static AttackOrder whoAttacks;
}
