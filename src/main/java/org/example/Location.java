package org.example;

public class Location {
    private int row;
    private int column;
    private Cell cell;
    Location(int row, int column, Cell cell) {
        this.row = row;
        this.column = column;
        this.cell = cell;
    }
}
