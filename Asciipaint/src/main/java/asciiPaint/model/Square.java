package asciiPaint.model;

public class Square extends Rectangle {

    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

    @Override
    public String toString() {
        return "Square{" +
                "color=" + color +
                ", upperLeft=" + this.getUpperLeft().toString() +
                ", side=" + this.getWidth() +
                "}";
    }
}
