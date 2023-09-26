package asciiPaint.model;

public abstract class ColoredShape implements Shape {

    protected char color;

    public ColoredShape(char color) {
        this.color = color;
    }

    @Override
    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return  String.valueOf(color);
    }
}
