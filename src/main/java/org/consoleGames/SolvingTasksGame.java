package org.consoleGames;

import java.util.Scanner;

public class SolvingTasksGame {
    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Привет! Ты готов начать игру? Введи да или нет: ");
        String answer = console.nextLine();
        switch (answer) {
            case "да":
                System.out.println("Тогда погнали!");
                startGame();
            case "нет":
                System.out.println("Жалко :(");
            default:
                System.out.println("Некорректный ввод");
        }
    }

    private static void startGame() {
    }
}