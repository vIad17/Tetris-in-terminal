package org.example.entities.figure.figureBuilders;

import org.example.entities.figure.IFigure;

public interface IFigureBuilder {
    boolean build();
    IFigure getResult();
}
