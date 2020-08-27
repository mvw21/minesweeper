package com.minesweeper.controller;


import com.minesweeper.entity.Matrix;
import com.minesweeper.common.ConstantMessages;

import java.util.Arrays;
import java.util.Scanner;

import static com.minesweeper.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private static int rowsAndCols;
    private static int numberOfMines;
    private static int revealedCellsCounter;
    private static int numOfTotalRevealedCellsOnBoard;
    private static boolean wonGame = false;
    private static boolean lostGame = false;
    private static boolean isBeginningMove = true;
    private static Scanner scanner = new Scanner(System.in);
    private static int rowPositionInput;
    private static int colPositionInput;
    private Matrix startingGrid;
    private Matrix grid;

    public ControllerImpl() {
    }

//    @Override
//    public Matrix createMatrix() {
//        Matrix matrix = fillMatrix(rowPositionInput, colPositionInput);
//        return grid = new Matrix(rowsAndCols, rowsAndCols, numberOfMines, matrix.getGridValues());
//    }

    @Override
    public int[] getParams() {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    @Override
    public int checkAroundCells(int row, int col) {


        int counter = 0;

        if (isTopLeftCorner(row, col)) {
            if (grid.getGridValues()[row][col + 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row + 1][col + 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row + 1][col] == '*') {
                counter++;
            }
            return counter;
        }

        if (isBottomLeftCorner(row, col, grid.getRows())) {
            if (grid.getGridValues()[row][col + 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row - 1][col + 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row - 1][col] == '*') {
                counter++;
            }
            return counter;
        }

        if (isBottomRightCorner(row, col, grid.getRows(), grid.getCols())) {
            if (grid.getGridValues()[row][col - 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row - 1][col - 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row - 1][col] == '*') {
                counter++;
            }
            return counter;
        }

        if (isTopRightCorner(row, col, grid.getRows())) {
            if (grid.getGridValues()[row][col - 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row + 1][col - 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row + 1][col] == '*') {
                counter++;
            }
            return counter;
        }

        if (isOnTopWall(row) && !isTopRightCorner(row, col, grid.getRows())) {
            if (grid.getGridValues()[row][col - 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row][col + 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row + 1][col] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row + 1][col - 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row + 1][col + 1] == '*') {
                counter++;
            }
            return counter;
        }

        if (isOnLeftWall(col) && !isBottomLeftCorner(row, col, grid.getRows())) {
            if (grid.getGridValues()[row][col + 1] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row - 1][col + 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row - 1][col] == '*') {
                counter++;
            }

            if (grid.getGridValues()[row + 1][col + 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row + 1][col] == '*') {
                counter++;
            }
            return counter;
        }

        if (isOnRightWall(col, grid.getRows()) && !isBottomRightCorner(row, col, grid.getRows(), grid.getCols())) {
            if (grid.getGridValues()[row][col - 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row + 1][col] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row + 1][col - 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row - 1][col - 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row - 1][col] == '*') {
                counter++;
            }
            return counter;
        }

        if (isOnBottomWall(row, grid.getRows())) {
            if (grid.getGridValues()[row][col - 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row][col + 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row - 1][col] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row - 1][col - 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row - 1][col + 1] == '*') {
                counter++;
            }
            return counter;
        }

        if (isNotWall(row, col)) {
            if (grid.getGridValues()[row][col - 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row][col + 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row - 1][col - 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row - 1][col] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row - 1][col + 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row + 1][col - 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row + 1][col + 1] == '*') {
                counter++;
            }
            if (grid.getGridValues()[row + 1][col] == '*') {
                counter++;
            }
            return counter;
        }

        return counter;
    }

    public boolean isNotWall(int row, int col) {
        return (row > 0 && row < grid.getRows() - 1) &&
                (col > 0 && col < grid.getCols() - 1);
    }

    public boolean isOnBottomWall(int row, int length) {
        return row == length - 1;
    }

    public boolean isOnRightWall(int col, int width) {
        return col == width - 1;
    }

    public boolean isOnLeftWall(int col) {
        return col - 1 < 0;
    }

    public boolean isOnTopWall(int row) {
        return row - 1 < 0;
    }

    public boolean isTopRightCorner(int row, int col, int length) {

        return row - 1 < 0 && col + 1 == length;
    }

    public boolean isBottomRightCorner(int row, int col, int length, int width) {
        return row + 1 == length && col + 1 == width;
    }

    public boolean isBottomLeftCorner(int row, int col, int length) {
        return row + 1 == length &&
                col == 0;
    }


    public boolean isTopLeftCorner(int row, int col) {
        return row - 1 < 0 && col - 1 < 0;
    }

    @Override
    public void printStartStatus() {

        printResult(grid);
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                if (j == 0) {
                    if (i < 10) {
                        System.out.print(i + " | ");
                    } else {
                        System.out.print(i + "| ");
                    }

                }
                if (grid.getGridValues()[i][j] == '*') {
                    System.out.print('-' + "  ");
                } else {

                    System.out.print(grid.getGridValues()[i][j] + "  ");
                }

            }
            System.out.println();
        }
    }

    private void printResult(Matrix grid) {
        for (int i = 0; i < grid.getRows(); i++) {
            if (i == 0) {
                System.out.print("    ");
            }
            System.out.printf("%-3d", i);


        }

        System.out.println();

        for (int i = 0; i < grid.getCols(); i++) {
            if (i == 0) {
                System.out.print("   ");
            }
            System.out.print("---");
        }

        System.out.println();
    }

    @Override
    public boolean isValid(int row, int col) {
        return (row >= 0 && row < rowsAndCols) && (col >= 0 && col < rowsAndCols);
    }

    @Override
    public void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                System.out.print(matrix.getGridValues()[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void isEmptyCell(int rowPosition, int colPosition) {
        checkNorthCell(rowPosition - 1, colPosition);

        checkSouthCell(rowPosition + 1, colPosition);

        checkEastCell(rowPosition, colPosition + 1);

        checkWestCell(rowPosition, colPosition - 1);

        checkNorthEastCell(rowPosition - 1, colPosition + 1);

        checkNorthWestCell(rowPosition - 1, colPosition - 1);

        checkSouthEastCell(rowPosition + 1, colPosition + 1);

        checkSouthWestCell(rowPosition + 1, colPosition - 1);
    }

    @Override
    public void checkCells(int rowPosition, int colPosition) {

        if (!isValid(rowPosition, colPosition)) {
            return;
        }
        if (grid.getGridValues()[rowPosition][colPosition] == '-') {

            int nMines = checkAroundCells(rowPosition, colPosition);
            if (nMines > 0) {
                String s = String.valueOf(nMines);
                char numberMines = s.charAt(0);
                grid.getGridValues()[rowPosition][colPosition] = numberMines;
                revealedCellsCounter++;
            } else {
                grid.getGridValues()[rowPosition][colPosition] = '0';
                revealedCellsCounter++;
                isEmptyCell(rowPosition, colPosition);

            }
            if (revealedCellsCounter == numOfTotalRevealedCellsOnBoard) {
                wonGame = true;

            }
        }
    }

    @Override
    public void checkNorthCell(int rowPosition, int colPosition) {
        checkCells(rowPosition, colPosition);
    }

    @Override
    public void checkSouthCell(int rowPosition, int colPosition) {
        checkCells(rowPosition, colPosition);
    }

    @Override
    public void checkEastCell(int rowPosition, int colPosition) {
        checkCells(rowPosition, colPosition);
    }

    @Override
    public void checkWestCell(int rowPosition, int colPosition) {
        checkCells(rowPosition, colPosition);
    }

    @Override
    public void checkNorthEastCell(int rowPosition, int colPosition) {
        checkCells(rowPosition, colPosition);
    }

    @Override
    public void checkNorthWestCell(int rowPosition, int colPosition) {
        checkCells(rowPosition, colPosition);
    }

    @Override
    public void checkSouthEastCell(int rowPosition, int colPosition) {
        checkCells(rowPosition, colPosition);
    }

    @Override
    public void checkSouthWestCell(int rowPosition, int colPosition) {
        checkCells(rowPosition, colPosition);
    }

    @Override
    public void printGreetingsInfo() {
        System.out.println(ENTER_DIFFICULTY_LEVEL);
        System.out.println(BEGINNER);
        System.out.println(INTERMEDIATE);
        System.out.println(ADVANCED);
    }

    @Override
    public void getDifficultyLevel() {
        int difficulty = Integer.parseInt(scanner.nextLine());

        if (difficulty == 0) {
            rowsAndCols = 9;
            numberOfMines = 10;
            numOfTotalRevealedCellsOnBoard = 71;
        } else if (difficulty == 1) {
            rowsAndCols = 16;
            numberOfMines = 40;
            numOfTotalRevealedCellsOnBoard = 216;
        } else if (difficulty == 2) {
            rowsAndCols = 24;
            numberOfMines = 99;
            numOfTotalRevealedCellsOnBoard = 477;
        }


    }

    @Override
    public Matrix fillMatrix(int rowPositionInput, int colPositionInput) {
        char[][] initMatrix = new char[rowsAndCols][rowsAndCols];
        Matrix resultMatrix = new Matrix(rowsAndCols, rowsAndCols, numberOfMines, initMatrix);

        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < rowsAndCols; j++) {
                resultMatrix.getGridValues()[i][j] = '-';
            }
        }

        int minesToAdd = numberOfMines;
        while (minesToAdd > 0) {

            int totalElement = resultMatrix.getRows() * resultMatrix.getCols();
            int indexToSelect = (int) (Math.random() * totalElement);
            int xIndex = (int) indexToSelect / resultMatrix.getRows();
            int yIndex = indexToSelect % resultMatrix.getCols();

            if (resultMatrix.getGridValues()[xIndex][yIndex] != '*' && !isBeginningMove && xIndex != rowPositionInput && yIndex != colPositionInput) {
                resultMatrix.getGridValues()[xIndex][yIndex] = '*';
                minesToAdd--;

            } else if (isBeginningMove) {

                isBeginningMove = false;
            }

        }

        return resultMatrix;
    }

    @Override
    public void playTheGame() {

        while (!lostGame || !wonGame) {
            if (!isBeginningMove) {
                System.out.println(CURRENT_STATUS_OF_BOARD);
                printStartStatus();
            }

            System.out.println(ENTER_DATA);
            System.out.println("->");

            int[] params = getParams();
            rowPositionInput = params[0];
            colPositionInput = params[1];

//            System.out.println("Enter Row Position");
//            rowPositionInput = Integer.parseInt(scanner.nextLine());
//            System.out.println("Enter Col Position");
//            colPositionInput = Integer.parseInt(scanner.nextLine());

            if (!isValid(rowPositionInput, colPositionInput)) {
                System.out.println(ENTER_VALID_PARAMETERS);
            }

            if (isBeginningMove) {
                grid = fillMatrix(rowPositionInput, colPositionInput);
                startingGrid = fillMatrix(rowPositionInput, colPositionInput);


            }

            if (grid.getGridValues()[rowPositionInput][colPositionInput] == '*') {
                lostGame = true;
                break;

                //if cell is not a mine
            } else if (grid.getGridValues()[rowPositionInput][colPositionInput] == '-') {
                checkCells(rowPositionInput, colPositionInput);
            }
            if (revealedCellsCounter == numOfTotalRevealedCellsOnBoard) {
                wonGame = true;
                break;
            }

        }

        if (wonGame) {
            System.out.println(YOU_WON);
            printFinalResult();
        } else {
            System.out.println(YOU_LOST);
            printFinalResult();
        }
    }



    @Override
    public void printFinalResult() {

        printResult(startingGrid);
        for (int i = 0; i < startingGrid.getRows(); i++) {
            for (int j = 0; j < startingGrid.getCols(); j++) {
                if (j == 0) {
                    if (i < 10) {
                        System.out.print(i + " | ");
                    } else {
                        System.out.print(i + "| ");
                    }

                }

                System.out.print(startingGrid.getGridValues()[i][j] + "  ");

            }
            System.out.println();
        }
    }
}
