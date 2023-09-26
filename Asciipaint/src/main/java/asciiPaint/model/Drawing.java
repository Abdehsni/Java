package asciiPaint.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Drawing {


    private final List<Shape> shapes;
    private final int height;
    private final int width;


    public Drawing() {
        this(100,100);
    }

    public Drawing(int height, int width) {
        if(height <=0 || width<=0) {
            throw new IllegalArgumentException("Dimension du drawing "+ "incorrecte "+height+ " "+ width);
        }
        this.height = height;
        this.width = width;
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape){
        Objects.requireNonNull(shape,"Shape Absente");
        this.shapes.add(shape);
    }


    public Shape getShapeAt(Point point){
        List<Shape>currents = new ArrayList<>();
        Shape out = null;

        for(Shape shape: shapes){
            if(shape.isInside(point)){
                currents.add(shape);
            }
        }
        if(!currents.isEmpty()){
            out = currents.get(0);
        }
        return out;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public List<Shape> getShapes() {
        return shapes;
    }
}
