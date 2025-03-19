package org.example.managers.gameManager.movementCommands;

import org.example.components.GameStorage;
import org.example.components.gameField.IGameField;
import org.example.entities.figure.IFigure;

import java.util.Objects;

public class RightMovementCommand implements IMovementCommand {
    IFigure figure;
    IGameField gameField;

    public RightMovementCommand(GameStorage gameStorage) {
        figure = gameStorage.getFigure();
        gameField = gameStorage.getGameField();
    }

    @Override
    public void execute() {
        figure.moveRight();
        boolean isCollision = false;
        for (org.example.utils.Vector<Integer, Integer> element : figure.getElements()) {
            if (Objects.nonNull(gameField.getElement(element.getX(), element.getY()))) {
                isCollision = true;
                break;
            }
        }
        if (isCollision) {
            figure.moveLeft();
        }
    }
}
