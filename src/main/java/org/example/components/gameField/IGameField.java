package org.example.components.gameField;

import org.example.entities.IEntity;

public interface IGameField {
    IEntity getElement(int x, int y);
    IEntity[][] getAllElements();
    void setElement(int x, int y);

    int getLineSize(int y);
    void clearLine(int y);
}
