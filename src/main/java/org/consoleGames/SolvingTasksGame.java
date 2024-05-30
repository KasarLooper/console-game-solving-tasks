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
        System.out.print("Выбери уровень сложности от 1 до 5: ");
        int difficultGame = console.nextInt();
    }

    private static void printBoard(String[][] board, int hp) {
        printRowSeparate(board[0].length);
        for (String[] row : board) {
            for (String s : row)
                System.out.print(s + "|");
            System.out.println("|");
            printRowSeparate(board[0].length);
        }
    }

    private static void printRowSeparate(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("+--");
        System.out.println("+");
    }
}