package asciiPaint;


import asciiPaint.model.Shape;

import java.util.List;

public class Application {

    private static AsciiPaint paint = new AsciiPaint();
    private static final View view = new View();


    public static void start() {
        view.welcome();
        boolean finish = false;
        String[] command =null;
        ShapeFactory shapeFactory = new ShapeFactory(command);
        List<Shape> listOfShapes;
        while (!finish) {
            view.presentFormat();
            command = view.receiveCommand();
            shapeFactory.setCommand(command);
            listOfShapes = paint.getDrawing().getShapes();
//            if (command[0].equals("show")) {
//                System.out.println(paint.asAscii());
//                finish = view.terminerPaint();
//            } else if (command[0].equals("add")) {
//                shapeFactory.constructionShapes(paint);
//            } else if

            switch(command[0]){
                case "show":
                    System.out.println(paint.asAscii());
                    finish = view.terminerPaint();
                    break;
                case "add":
                    shapeFactory.constructionShapes(paint);
                    break;
                case "list":
                    view.showListForm(listOfShapes);
                    break;
                case "move":
                    try{
                        paint.addMove(command);
                    }catch (IllegalStateException e){
                    }
                    break;
            }

        }
        view.msgByeBye();
    }


    public static void main(String[] args) {
        start();
    }

}
