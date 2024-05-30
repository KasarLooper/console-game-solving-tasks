package org.consoleGames;

public class Monster {
    private int x;
    private int y;
    private String item;

    public Monster(int x, int y) {
        this.x = x;
        this.y = y;
        item = "Мм";
    }

    public boolean task(int difficult) {
        return true;
    }
}
