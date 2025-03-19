package org.example.managers.gameManager.movementCommands;

import org.example.components.GameStorage;
import org.example.components.gameField.IGameField;
import org.example.components.Score;
import org.example.entities.figure.IFigure;
import org.example.entities.figure.figureBuilders.IFigureBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DownMovementCommand implements IMovementCommand {
    IFigure figure;
    IGameField gameField;
    IFigureBuilder figureBuilder;
    private final Score score;
    private final int rows;

    public DownMovementCommand(GameStorage gameStorage, IFigureBuilder figureBuilder) {
        this.figureBuilder = figureBuilder;
        figure = gameStorage.getFigure();
        gameField = gameStorage.getGameField();
        this.score = gameStorage.getScore();
        this.rows = gameStorage.getGameField().getAllElements()[0].length;
    }

    @Override
    public void execute() {
        figure.moveDown();
        boolean isCollision = false;
        for (org.example.utils.Vector<Integer, Integer> element : figure.getElements()) {
            if (Objects.nonNull(gameField.getElement(element.getX(), element.getY()))) {
                isCollision = true;
                break;
            }
        }
        if (isCollision) {
            figure.moveUp();
            Set<Integer> set = new HashSet();
            for (org.example.utils.Vector<Integer, Integer> element : figure.getElements()) {
                gameField.setElement(element.getX(), element.getY());
                set.add(element.getY());
            }
            figureBuilder.build();
            figure.setFigure(figureBuilder.getResult().getElements());
            for (int y : set) {
                if (gameField.getLineSize(y) >= rows - 2) {
                    gameField.clearLine(y);
                    score.setScore(score.getScore()+100);
                }
            }
        }
    }
}
