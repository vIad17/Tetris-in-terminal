package org.example.components;

import org.example.entities.figure.IFigure;
import org.example.components.gameField.IGameField;

public class GameStorage {
    private IFigure figure;
    private IGameField gameField;
    private Score score;

    public GameStorage(IFigure figure, IGameField gameField, Score score) {
        this.figure = figure;
        this.gameField = gameField;
        this.score = score;
    }

    public IFigure getFigure() {
        return figure;
    }

    public IGameField getGameField() {
        return gameField;
    }

    public Score getScore() {
        return score;
    }

    public void setFigure(IFigure figure) {
        this.figure = figure;
    }

    public void setGameField(IGameField gameField) {
        this.gameField = gameField;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
