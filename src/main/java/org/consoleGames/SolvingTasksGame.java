package org.consoleGames;

import java.util.Random;
import java.util.Scanner;

public class SolvingTasksGame {
    private static Scanner console = new Scanner(System.in);
    private static final Random rd = new Random();

    public static void main(String[] args) {
        System.out.print("Привет! Ты готов начать игру? Введи да или нет: ");
        String answer = console.nextLine();
        switch (answer) {
            case "да" -> {
                System.out.println("Тогда погнали!");
                startGame();
            }
            case "нет" -> System.out.println("Жалко :(");
            default -> System.out.println("Некорректный ввод");
        }
    }

    private static void startGame() {
        System.out.print("Выбери уровень сложности от 1 до 5: ");
        int difficultGame = console.nextInt();
        int size = 5;

        String[][] board = new String[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = "  ";

        int heroX = rd.nextInt(size);
        int heroY = size - 1;
        Hero hero = new Hero(heroX, heroY, size, 3);
        int castleX = rd.nextInt(size);
        int castleY = 0;
        String heroString = "Гг";
        board[heroY][heroX] = heroString;
        board[castleY][castleX] = "З ";

        int countMonsters = size * size - 2 - 10 + 2 * difficultGame;
        Monster[] monsters = new Monster[countMonsters];
        while (countMonsters > 0) {
            int monsterX = rd.nextInt(size);
            int monsterY = rd.nextInt(size);
            if (monsterX == heroX && monsterY == heroY)
                continue;
            if (monsterX == castleX && monsterY == castleY)
                continue;
            boolean isContinue = false;
            for (Monster monster : monsters)
                if (monster != null && monsterX == monster.getX() && monsterY == monster.getY()) {
                    isContinue = true;
                    break;
                }
            if (isContinue) continue;
            countMonsters--;
            Monster currentMonster;
            if (rd.nextBoolean())
                currentMonster = new Monster(monsterX, monsterY, difficultGame);
            else currentMonster = new BigMonster(monsterX, monsterY, difficultGame);
            monsters[countMonsters] = currentMonster;
            board[monsterY][monsterX] = currentMonster.getIcon();
        }

        while (true) {
            printBoard(board, hero.getHp());
            System.out.print("Введи координаты, куда ты хочешь шагнуть: ");
            console = new Scanner(System.in);
            String[] xy = console.nextLine().split(" ");
            int newHeroX = Integer.parseInt(xy[0]) - 1;
            int newHeroY = Integer.parseInt(xy[1]) - 1;
            if (hero.isMoveCorrect(newHeroX, newHeroY)) {
                if (newHeroX == castleX && newHeroY == castleY) {
                    System.out.println("Вы достигли замка. Вы выиграли!");
                    break;
                }

                boolean conflictMonster = false;
                for (Monster monster : monsters)
                    if (monster.getX() == newHeroX && monster.getY() == newHeroY && monster.isAlive()) {
                        conflictMonster = true;
                        if (monster.task(difficultGame)) {
                            monster.kill();
                            board[monster.getY()][monster.getX()] = heroString;

                            hero.move(newHeroX, newHeroY);
                            board[heroY][heroX] = "  ";
                            board[newHeroY][newHeroX] = heroString;
                            heroX = newHeroX;
                            heroY = newHeroY;

                            System.out.println("Правильно! Ты победил монстра");
                        } else {
                            hero.decreaseHP();
                            System.out.println("Неправильно!");
                        }
                        break;
                    }

                if (!conflictMonster) {
                    hero.move(newHeroX, newHeroY);
                    board[heroY][heroX] = "  ";
                    board[newHeroY][newHeroX] = heroString;
                    heroX = newHeroX;
                    heroY = newHeroY;
                }

                if (hero.isDead()) {
                    System.out.println("Ты проиграл!");
                    break;
                }
            } else System.out.println("Невозможный ход");
        }
    }

    private static void printBoard(String[][] board, int hp) {
        printRowSeparate(board[0].length);
        for (String[] row : board) {
            System.out.print("|");
            for (String s : row)
                System.out.print(s + "|");
            System.out.println();
            printRowSeparate(board[0].length);
        }
        System.out.println("Жизни: " + hp);
    }

    private static void printRowSeparate(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("+--");
        System.out.println("+");
    }
}