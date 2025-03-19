package org.example.entities.figure.figureBuilders;

import org.example.utils.Vector;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FigureTypes {
    List<List<Vector<Integer, Integer>>> figureTypes;

    public FigureTypes() {
        figureTypes = new LinkedList<>();
        figureTypes.add(Arrays.asList( // I
                new Vector<>(0, -2),
                new Vector<>(0, -1),
                new Vector<>(0, 0),
                new Vector<>(0, 1)
        ));
        figureTypes.add(Arrays.asList( // J
                new Vector<>(0, -2),
                new Vector<>(0, -1),
                new Vector<>(0, 0),
                new Vector<>(-1, 0)
        ));
        figureTypes.add(Arrays.asList( // L
                new Vector<>(0, -2),
                new Vector<>(0, -1),
                new Vector<>(0, 0),
                new Vector<>(1, 0)
        ));
        figureTypes.add(Arrays.asList( // O
                new Vector<>(0, 0),
                new Vector<>(0, 1),
                new Vector<>(1, 1),
                new Vector<>(1, 0)
        ));
        figureTypes.add(Arrays.asList( // S
                new Vector<>(0, -1),
                new Vector<>(0, 0),
                new Vector<>(1, 0),
                new Vector<>(1, 1)
        ));
        figureTypes.add(Arrays.asList( // T
                new Vector<>(0, 0),
                new Vector<>(0, 1),
                new Vector<>(-1, 1),
                new Vector<>(1, 1)
        ));
        figureTypes.add(Arrays.asList( // Z
                new Vector<>(0, -1),
                new Vector<>(0, 0),
                new Vector<>(-1, 0),
                new Vector<>(-1, 1)
        ));
    }
    public List<Vector<Integer, Integer>> get(int n) {
        return figureTypes.get(n);
    }
    public List<List<Vector<Integer, Integer>>> getAll() {
        return figureTypes;
    }

    public int size() {
        return figureTypes.size();
    }
}
