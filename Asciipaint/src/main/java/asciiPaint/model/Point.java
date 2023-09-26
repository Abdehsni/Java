package asciiPaint.model;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        if(x<0||y<0){
            throw new IllegalArgumentException("Le centre doit etre positif ou égal à 0");
        }
        this.x = x;
        this.y = y;
    }

    public Point(Point point){
        this.x= point.x;
        this.y= point.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public double distantTo(Point other){
        return Math.sqrt(Math.pow((this.x-other.x),2)+Math.pow((this.y-other.y),2));
    }


    public void move(double dx, double dy) {
        this.x+=dx;
        this.y+=dy;

    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
