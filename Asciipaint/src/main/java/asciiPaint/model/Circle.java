package asciiPaint.model;

import java.util.Objects;

public class Circle extends ColoredShape {

    private final Point center;
    private final double radius;

    public Circle(char color,Point center,double radius ) {
        super(color);
        this.center=Objects.requireNonNull(center,"centre absent");
        if(radius <=0){
            throw new IllegalArgumentException("Le rayon doit "+
                    "etre strictement positif");
        }
        this.radius=radius;
    }

    @Override
    public boolean isInside(Point point) {
        Objects.requireNonNull(point,"point absent");
        return center.distantTo(point)<=radius;
    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx,dy);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center.toString() +
                ", radius=" + radius +
                ", color=" + this.getColor() +
                '}';
    }
}
