package org.example.managers.gameManager;

import org.example.components.gameField.IGameField;
import org.example.entities.figure.IFigure;

public interface IGameManager {
    void action();

    IFigure getFigure();
    void setFigure(IFigure figure);

    IGameField getGameField();

    int getScore();
}
