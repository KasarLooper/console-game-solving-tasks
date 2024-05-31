package org.consoleGames;

import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster {
    private final String icon = "Бм";
    private final Random rd = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public BigMonster(int x, int y, int difficultLevel) {
        super(x, y, difficultLevel);
    }

    @Override
    public boolean task(int difficult) {
        int bound = 10 * difficult;
        int x = rd.nextInt(bound);
        int y = rd.nextInt(bound);
        int z = rd.nextInt(bound);
        int op = rd.nextInt(4);
        String task = "";
        int writeAnswer = 0;
        switch (op) {
            case 0:
                task = "Решите пример %d + %d - %d: ";
                writeAnswer = x + y - z;
            case 1:
                task = "Решите пример %d + (%d - %d): ";
                writeAnswer = x + y - z;
            case 2:
                task = "Решите пример %d - (%d + %d): ";
                writeAnswer = x - (y + z);
            case 3:
                task = "Решите пример %d - (%d - %d): ";
                writeAnswer = x - (y - z);
        }
        System.out.printf(task, x, y, z);
        int userAnswer = scanner.nextInt();
        return writeAnswer == userAnswer;
    }

    @Override
    public String getIcon() {
        return icon;
    }
}
