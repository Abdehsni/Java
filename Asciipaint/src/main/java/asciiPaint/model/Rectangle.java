package asciiPaint.model;


import java.util.Objects;

public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private double width;
    private double height;


    public Rectangle(Point upperLeft,double width,double height,char color) {
        super(color);
        this.upperLeft=Objects.requireNonNull(upperLeft,"centre absent");
        if(width<=0||height<=0){
            throw new IllegalArgumentException("Le coté doit "+
                    "etre strictement positif");
        }
        this.width=width;
        this.height=height;
    }


    @Override
    public boolean isInside(Point point) {
        Objects.requireNonNull(point,"point absent");
        double MaxX=upperLeft.getX()+width;
        double MaxY= upperLeft.getY()+height;
        double MinX=upperLeft.getX();
        double MinY= upperLeft.getY();
        if(point.getX()>MaxX || point.getY()>MaxY || point.getX()<MinX||point.getY()<MinY)return false;
        else return true;
    }


    @Override
    public void move(double dx, double dy) { upperLeft.move(dx,dy); }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "color=" + color +
                ", upperLeft=" + upperLeft +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}

