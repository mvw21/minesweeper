package com.minesweeper;


import com.minesweeper.controller.Controller;
import com.minesweeper.controller.ControllerImpl;
import com.minesweeper.controller.Engine;
import com.minesweeper.controller.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();

    }
}
