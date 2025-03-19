package org.example.entities.figure;

import org.example.utils.Vector;

public interface IFigure {
    void moveLeft();
    void moveRight();
    void moveDown();
    void moveUp();
    void rotateLeft();
    void rotateRight();
    Vector<Integer, Integer>[] getElements();
    void setFigure(Vector<Integer, Integer>[] elements);
}
