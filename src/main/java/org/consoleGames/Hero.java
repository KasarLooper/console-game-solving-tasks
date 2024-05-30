package org.consoleGames;

public class Hero {
    private int x;
    private int y;
    private int hp;

    public Hero(int x, int y, int hp) {
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void decreaseHP() {
        hp--;
    }
}
