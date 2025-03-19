package org.example.components.gameField;

import org.example.entities.Block;
import org.example.entities.IEntity;
import org.example.entities.Wall;

import java.util.HashMap;
import java.util.Map;

public class GameField implements IGameField {
    private final Map<Integer, Map<Integer, IEntity>> entities;
    private final int columnsCount;
    private final int rowsCount;

    public GameField (int columnsCount, int rowsCount) {
        this.columnsCount = columnsCount;
        this.rowsCount = rowsCount;
        entities = new HashMap<>();
        for (int i = 0; i < columnsCount; i++) {
            entities.put(i, new HashMap<>());
            entities.get(i).put(0, new Wall());
            entities.get(i).put(rowsCount - 1, new Wall());
        }
        for (int i = 1; i < rowsCount - 1; i++) {
            entities.get(columnsCount - 1).put(i, new Wall());
        }
    }

    @Override
    public IEntity getElement(int x, int y) {
        try {
            return entities.get(y).get(x);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public IEntity[][] getAllElements() {
        IEntity[][] entitiesArray = new IEntity[columnsCount][rowsCount];
        for (int y = 0; y < entitiesArray.length; y++) {
            for (int x = 0; x < entitiesArray[x].length; x++) {
                entitiesArray[y][x] = getElement(x, y);
            }
        }
        return entitiesArray;
    }

    @Override
    public void setElement(int x, int y) {
        if (!entities.containsKey(y)) {
            entities.put(y, new HashMap<>());
        }
        if (!entities.get(y).containsKey(x)) {
            entities.get(y).put(x, new Block());
        }
    }

    @Override
    public int getLineSize(int y) {
        if (entities.containsKey(y)) {
            return entities.get(y).size() - 2;
        }
        return 0;
    }

    @Override
    public void clearLine(int y) {
        for (int i = 1; i < rowsCount - 1; i++) {
            entities.get(y).remove(i);
        }
        for (int i = y; i > 0; i--) {
            entities.replace(i, entities.get(i - 1));
        }
    }
}
