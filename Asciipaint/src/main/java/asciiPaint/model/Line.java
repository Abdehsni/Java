package asciiPaint.model;


import java.util.Objects;
public class Line extends ColoredShape{

    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2,char color) {
        super(color);
        this.p1 = Objects.requireNonNull(p1,"je peux pas faire une ligne avec un point qui n'existe pas");
        this.p2 = Objects.requireNonNull(p2, "je ne peux pas faire une ligne avec le deuxieme point qui n'existe pas");
    }

    @Override
    public boolean isInside(Point point) {

        double x1= p1.getX();
        double x2= p2.getX();
        double y1= p1.getY();
        double y2= p2.getY();
        double x = point.getX();
        double y = point.getY();

        double result = (((y1-y2)*x+(x2-x1)*y)/Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)));
        return result==0?true:false;
    }

    @Override
    public void move(double dx, double dy) {
        p1.move(dx,dy);
        p2.move(dx,dy);
    }

    @Override
    public String toString() {
        return "Line{" +
                "color=" + color +
                ", p1=" + p1.toString() +
                ", p2=" + p2.toString() +
                '}';
    }
}
