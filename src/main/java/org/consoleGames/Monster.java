package org.consoleGames;

import java.util.Random;
import java.util.Scanner;

public class Monster {
    private final int x;
    private final int y;
    private final int difficultLevel;
    private final String icon = "Мм";
    private final Random rd = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public Monster(int x, int y, int difficultLevel) {
        this.x = x;
        this.y = y;
        this.difficultLevel = difficultLevel;
    }

    public boolean task(int difficult) {
        int x = rd.nextInt(100);
        int y = rd.nextInt(100);
        String task = "";
        int writeAnswer;
        if (rd.nextBoolean()) {
            task = "Решите пример: %d + %d: ";
            writeAnswer = x + y;
        } else {
            task = "Решите пример: %d - %d: ";
            writeAnswer = x - y;
        }
        System.out.printf(task, x, y);
        int userAnswer = scanner.nextInt();
        return userAnswer == writeAnswer;
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
