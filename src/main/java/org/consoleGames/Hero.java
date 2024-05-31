package org.consoleGames;

public class Hero {
    private int x;
    private int y;
    private int size;
    private int hp;

    public Hero(int x, int y, int size, int hp) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.hp = hp;
    }

    public boolean isMoveCorrect(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) return false;
        int dx = Math.abs(this.x - x);
        int dy = Math.abs(this.y - y);
        return dx == 0 && dy == 1 || dx == 1 && dy == 0;
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
