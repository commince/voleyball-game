package volley;

class Player {
    private double serveSkill;
    private double attackSkill;
    private String playerName;

    public void setPlayerName(String gotUserName) {
        playerName = gotUserName;
    }

    public String getPlayerName() { return playerName; }

    public void setServeSkill(double gotServeSkill) { serveSkill = gotServeSkill; }

    public double getServeSkill() {
        return serveSkill;
    }

    public void setAttackSkill(double gotAttackSkill) {
        attackSkill = gotAttackSkill;
    }

    public double getAttackSkill() {
        return attackSkill;
    }

    public double getDefenceSkill() {
        return (2 - this.serveSkill - this.attackSkill);
    }
}
