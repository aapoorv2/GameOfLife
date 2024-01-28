package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Rows");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of Columns");
        int cols = scanner.nextInt();
        System.out.println("Enter the percentage of the board with alive cells");
        int fillPercent = scanner.nextInt();
        Game game = new Game(rows, cols, fillPercent);
        game.start();
    }
}