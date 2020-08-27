package com.minesweeper.entity;

public class Matrix {
    private int rows;
    private int cols;
    private int numberOfMines;
    private char[][] gridValues;

    public Matrix() {
    }

    public Matrix(int rows, int cols, int numberOfMines, char[][] gridValues) {
        this.rows = rows;
        this.cols = cols;
        this.numberOfMines = numberOfMines;
        this.gridValues = gridValues;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public char[][] getGridValues() {
        return gridValues;
    }

    public void setGridValues(char[][] gridValues) {
        this.gridValues = gridValues;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }
}
