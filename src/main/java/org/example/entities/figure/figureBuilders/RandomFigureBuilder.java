package org.example.entities.figure.figureBuilders;

import org.example.entities.figure.Figure;
import org.example.entities.figure.IFigure;
import org.example.utils.Vector;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomFigureBuilder implements IFigureBuilder {
    private List<Vector<Integer, Integer>> elements;
    private FigureTypes figureTypes;
    private Random rand;
    private int startRow;
    private int startColumn;

    public RandomFigureBuilder(int startRow, int startColumn) {
        elements = new LinkedList<>();
        figureTypes = new FigureTypes();
        rand = new Random();
        this.startRow = startRow;
        this.startColumn = startColumn;
    }

    @Override
    public boolean build() {
        try {
            elements.clear();
            for (Vector<Integer, Integer> relativePosition : figureTypes.get(rand.nextInt(figureTypes.size()))) {
                elements.add(new Vector<>(startColumn + relativePosition.getX(), startRow + relativePosition.getY()));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public IFigure getResult() {
        return new Figure(elements.toArray(Vector[]::new));
    }
}
