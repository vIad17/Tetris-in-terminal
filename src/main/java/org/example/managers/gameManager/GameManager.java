package org.example.managers.gameManager;

import org.example.components.GameStorage;
import org.example.components.Score;
import org.example.components.gameField.IGameField;
import org.example.entities.IEntity;
import org.example.entities.figure.IFigure;
import org.example.entities.figure.figureBuilders.IFigureBuilder;
import org.example.entities.figure.figureBuilders.RandomFigureBuilder;
import org.example.managers.InputManager.IInputManager;
import org.example.managers.InputManager.InputKeys;
import org.example.managers.gameManager.movementCommands.*;

import java.util.HashMap;
import java.util.Map;

public class GameManager implements IGameManager{
    private IFigure figure;
    private final IGameField gameField;
    private final IInputManager inputManager;
    private final Score score;
    private final Map<String, IMovementCommand> commandMap;

    public GameManager(GameStorage gameStorage, IInputManager inputManager) {
        this.inputManager = inputManager;
        gameField = gameStorage.getGameField();

        IEntity[][] elements = gameField.getAllElements();
        final int startRow = 2;
        final int startColumn = elements[0].length / 2;

        score = new Score();

        IFigureBuilder figureBuilder = new RandomFigureBuilder(startRow, startColumn);
        figureBuilder.build();
        gameStorage.setFigure(figureBuilder.getResult());

        commandMap = new HashMap<>();
        commandMap.put(InputKeys.MOVE_RIGHT, new RightMovementCommand(gameStorage));
        commandMap.put(InputKeys.MOVE_LEFT, new LeftMovementCommand(gameStorage));
        commandMap.put(InputKeys.ROTATE_RIGHT, new RightRotationCommand(gameStorage));
        commandMap.put(InputKeys.ROTATE_LEFT, new LeftRotationCommand(gameStorage));
        commandMap.put(InputKeys.MOVE_DOWN, new DownMovementCommand(gameStorage, figureBuilder));
    }

    @Override
    public void action() {
        commandMap.getOrDefault(inputManager.getState(), commandMap.get(InputKeys.MOVE_DOWN)).execute();
    }

    @Override
    public IFigure getFigure() {
        return figure;
    }

    @Override
    public void setFigure(IFigure figure) {
        this.figure = figure;
    }

    @Override
    public IGameField getGameField() {
        return gameField;
    }

    @Override
    public int getScore() {
        return score.getScore();
    }
}
