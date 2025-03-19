package org.example.entities.figure;

import org.example.utils.Vector;
import org.example.entities.IEntity;

public class Figure implements IFigure, IEntity {
    private Vector<Integer, Integer>[] figure;
    int mainIndex = 1;

    public Figure(Vector<Integer, Integer>[] elements) {
        figure = elements;
    }

    @Override
    public void moveLeft() {
        for (Vector<Integer, Integer> element : figure) {
            element.setX(element.getX() - 1);
        }
    }

    @Override
    public void moveRight() {
        for (Vector<Integer, Integer> element : figure) {
            element.setX(element.getX() + 1);
        }
    }

    @Override
    public void moveDown() {
        for (Vector<Integer, Integer> element : figure) {
            element.setY(element.getY() + 1);
        }
    }

    @Override
    public void moveUp() {
        for (Vector<Integer, Integer> element : figure) {
            element.setY(element.getY() - 1);
        }
    }

    @Override
    public void rotateLeft() {
        for (Vector<Integer, Integer> element : figure) {
            int xPrev = element.getX();
            int yPrev = element.getY();
            int x = figure[mainIndex].getX();
            int y = figure[mainIndex].getY();
            element.setX(x - y + yPrev);
            element.setY(-xPrev + y + x);
        }
    }


    @Override
    public void rotateRight() {
        for (Vector<Integer, Integer> element : figure) {
            int xPrev = element.getX();
            int yPrev = element.getY();
            int x = figure[mainIndex].getX();
            int y = figure[mainIndex].getY();
            element.setX(x + y - yPrev);
            element.setY(xPrev + y - x);
        }
    }

    @Override
    public Vector<Integer, Integer>[] getElements() {
        return figure;
    }

    @Override
    public void setFigure(Vector<Integer, Integer>[] elements) {
        figure = elements;
    }

    @Override
    public String getType() {
        return "FIGURE";
    }
}
