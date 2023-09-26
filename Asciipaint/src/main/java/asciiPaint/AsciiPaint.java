package asciiPaint;

import asciiPaint.model.*;

import java.util.List;

public class AsciiPaint {

    private final Drawing drawing;


    public AsciiPaint() {
        this(5,5);
    }


    public AsciiPaint(int height, int width){
        drawing = new Drawing(height,width);

    }


    public void addNewCircle(int x,int y,double radius, char color){
        Point center = new Point(x,y);
        Circle circle = new Circle(color, center, radius);
        drawing.addShape(circle);

    }

    public void addNewRectangle(int x, int y,double width,double height,char color){
        Point upperLeft = new Point(x,y);
        Rectangle rectangle = new Rectangle(upperLeft,width,height,color);
        drawing.addShape(rectangle);
    }


    public void addNewSquare(int x,int y, double side,char color){
        Point upperLeft= new Point(x,y);
        Square square= new Square(upperLeft,side,color);
        drawing.addShape(square);
    }



    public void addNewLine(int x1,int y1,int x2,int y2,char color){
        Point p1 = new Point(x1,y1);
        Point p2 = new Point(x2,y2);
        Line line = new Line(p1,p2,color);
        drawing.addShape(line);
    }

    public void addMove(String[]command){

        int index = Integer.parseInt(command[1]);
        int x = Integer.parseInt(command[2]);
        int y = Integer.parseInt(command[3]);
        move(index,x,y);
    }





    public void move (int indexToCorrect, int x ,int y){
        if((indexToCorrect-1)<0||(indexToCorrect-1)>drawing.getShapes().size()){
            throw new IllegalArgumentException("La forme choisie n'est pas dans la liste");
        }
        drawing.getShapes().get(indexToCorrect-1).move(x,y);
    }


    public String asAscii(){

        StringBuilder builder = new StringBuilder();
        for(int row = 0 ; row<drawing.getHeight(); row++){
            for(int column = 0 ; column < drawing.getWidth();column++){
                Point point = new Point(column,row);
                Shape shape = drawing.getShapeAt(point);
                char color = ' ';

                if(shape != null){
                    color = shape.getColor();
                }
                 builder.append(color);
            }
            builder.append(System.lineSeparator());

        }
        return builder.toString();
    }

    public Drawing getDrawing() {
        return drawing;
    }
}
