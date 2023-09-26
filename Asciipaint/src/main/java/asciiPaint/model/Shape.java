package asciiPaint.model;

import asciiPaint.model.Point;

public interface Shape {

    boolean isInside(Point point);
    void move(double dx,double dy);
    char getColor();
}
