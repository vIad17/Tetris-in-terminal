package org.example;

import org.example.components.GameStorage;
import org.example.components.Score;
import org.example.components.gameField.GameField;
import org.example.components.gameField.IGameField;
import org.example.managers.InputManager.IInputManager;
import org.example.managers.InputManager.InputManager;
import org.example.entities.figure.IFigure;
import org.example.entities.figure.figureBuilders.IFigureBuilder;
import org.example.entities.figure.figureBuilders.RandomFigureBuilder;
import org.example.managers.gameManager.GameManager;
import org.example.managers.gameManager.IGameManager;
import org.example.managers.graphicManager.GraphicManager;
import org.example.managers.graphicManager.IGraphicManager;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int rows = 18;
        final int columns = 10;

        IFigureBuilder figureBuilder = new RandomFigureBuilder(2, columns/2);
        figureBuilder.build();
        IFigure figure = figureBuilder.getResult();

        IGameField gameField = new GameField(rows, columns);
        Score score = new Score();
        GameStorage gameStorage = new GameStorage(figure, gameField, score);

        IInputManager inputManager = new InputManager();
        inputManager.listen();
        IGameManager gameManager = new GameManager(gameStorage, inputManager);
        IGraphicManager graphicManager = new GraphicManager(gameStorage);

        int i = 0;
        boolean gameOver = false;

        while (!gameOver) {
            TimeUnit.MILLISECONDS.sleep(1);
            i++;

            if (Objects.nonNull(inputManager.getState()) || i == 1000) {
                gameManager.action();
                graphicManager.draw();
            }
            if (i > 1000) {
                i = 0;
            }
            if (gameManager.getGameField().getLineSize(0) > 0) {
                gameOver = true;
            }
            inputManager.clear();
        }
    }
}