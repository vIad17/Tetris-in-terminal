package org.example.managers.graphicManager;

import org.example.components.GameStorage;
import org.example.components.gameField.IGameField;
import org.example.components.Score;
import org.example.entities.IEntity;
import org.example.entities.figure.IFigure;
import org.example.utils.Vector;

import java.util.Arrays;
import java.util.Objects;

public class GraphicManager implements IGraphicManager{
    private final IFigure figure;
    private final IGameField gameField;
    private final Score score;
    private final char[][] field;
    private final int columns;
    private final int rows;

    public GraphicManager(GameStorage gameStorage) {
        figure = gameStorage.getFigure();
        gameField = gameStorage.getGameField();
        score = gameStorage.getScore();

        IEntity[][] entities = gameStorage.getGameField().getAllElements();
        columns = entities.length;
        rows = entities[0].length;
        field = new char[columns][rows];
    }

    public void draw() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                IEntity entity = gameField.getElement(y, x);
                if (Objects.nonNull(entity) && Objects.equals(entity.getType(), "WALL")) {
                    field[x][y] = '#';
                } else if (Objects.nonNull(entity) && Objects.equals(entity.getType(), "BLOCK")) {
                    field[x][y] = '@';
                } else {
                    field[x][y] = ' ';
                }
            }
        }
        for (Vector<Integer, Integer> figureElement : figure.getElements()) {
            int x = figureElement.getY();
            int y = figureElement.getX();
            if (x >= 0 && x < columns && y >= 0 && y < rows) {
                field[x][y] = '@';
            }
        }

        System.out.println(score.getScore());
        for (char[] chars : field) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
