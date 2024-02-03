package org.example;

import java.util.Scanner;

public class InputOutput {
    private static final InputOutput INSTANCE = new InputOutput();
    Scanner scanner = new Scanner(System.in);
    public static InputOutput instance() {
        return INSTANCE;
    }
    int getRowInputFromTheUser() {
        System.out.println("Enter the number of Rows");
        return scanner.nextInt();
    }
    int getColumnInputFromTheUser() {
        System.out.println("Enter the number of Columns");
        return scanner.nextInt();
    }
    int getFillPercentageFromTheUser() {
        System.out.println("Enter the percentage of the board to populate");
        return scanner.nextInt();
    }

    void printBoard(Cell[][] cells, int rows, int columns, int generation) {
        System.out.println("Generation " + generation + ":");
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                if (cells[i][j].isAlive()){
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
