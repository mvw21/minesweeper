package com.minesweeper.controller;

import com.minesweeper.entity.Matrix;

public interface Controller {

    int[] getParams();

    int checkAroundCells(int row, int col);

    boolean isNotWall(int row, int col);

    boolean isOnBottomWall(int row, int length);

    boolean isOnRightWall(int col, int width);

    boolean isOnLeftWall(int col);

    boolean isOnTopWall(int row);

    boolean isTopRightCorner(int row, int col, int length);

    boolean isBottomRightCorner(int row, int col, int length, int width);

    boolean isBottomLeftCorner(int row, int col, int length);

    boolean isTopLeftCorner(int row, int col);

    void printStartStatus();

    boolean isValid(int row, int col);

    void printMatrix(Matrix matrix);

    void isEmptyCell(int row, int col);

    void checkCells(int row, int col);

    void checkNorthCell(int row, int col);

    void checkSouthCell(int row, int col);

    void checkEastCell(int row, int col);

    void checkWestCell(int row, int col);

    void checkNorthEastCell(int row, int col);

    void checkNorthWestCell(int row, int col);

    void checkSouthEastCell(int row, int col);

    void checkSouthWestCell(int row, int col);

    void printGreetingsInfo();

    void getDifficultyLevel();

    Matrix fillMatrix(int rowPosition, int colPosition);

    void playTheGame();

    void printFinalResult();
}
