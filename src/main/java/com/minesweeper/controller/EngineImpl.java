package com.minesweeper.controller;

import java.util.Scanner;

public class EngineImpl implements Engine {

    private final Controller controller;
    private final Scanner scanner = new Scanner(System.in);

    public EngineImpl(Controller controller) {
        this.controller = controller;

    }


    @Override
    public void run() {
        this.controller.printGreetingsInfo();
        this.controller.getDifficultyLevel();
        this.controller.playTheGame();


    }
}
