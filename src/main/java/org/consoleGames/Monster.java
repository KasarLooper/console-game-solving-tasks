package org.consoleGames;

public class Monster {
    private final int x;
    private final int y;
    private final int difficultLevel;
    private final String icon = "Мм";

    public Monster(int x, int y, int difficultLevel) {
        this.x = x;
        this.y = y;
        this.difficultLevel = difficultLevel;
    }

    public boolean task(int difficult) {
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getIcon() {
        return icon;
    }
}
