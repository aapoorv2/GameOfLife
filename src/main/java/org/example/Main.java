package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        int rows = InputOutput.instance().getRowInputFromTheUser();
        int cols = InputOutput.instance().getColumnInputFromTheUser();
        int fillPercent = InputOutput.instance().getFillPercentageFromTheUser();
        Game game = new Game(rows, cols, fillPercent);
        game.start();
    }
}