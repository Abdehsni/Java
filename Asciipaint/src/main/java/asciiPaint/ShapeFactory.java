package asciiPaint;

import asciiPaint.AsciiPaint;

public class ShapeFactory {

    private String[] command;


    public ShapeFactory(String[] command) {
        this.command = command;
    }

    void constructionShapes(AsciiPaint paint) {
        switch (command[1]) {
            case "circle":
                int x = convertToInt(command[2]);
                int y = convertToInt(command[3]);
                int radius = convertToInt(command[4]);
                char color = convertToChar(command[5]);
                paint.addNewCircle(x, y, radius, color);
                break;
            case "rectangle":
                int xx = convertToInt(command[2]);
                int yy = convertToInt(command[3]);
                int width = convertToInt(command[4]);
                int height = convertToInt(command[5]);
                char colo = convertToChar(command[6]);
                paint.addNewRectangle(xx, yy, width, height, colo);
                break;
            case "square":
                int xxx = convertToInt(command[2]);
                int yyy = convertToInt(command[3]);
                int side = convertToInt(command[4]);
                char couleur = convertToChar(command[5]);
                paint.addNewSquare(xxx, yyy, side, couleur);
                break;
            case "line":
                int x1= convertToInt(command[2]);
                int y1= convertToInt(command[3]);
                int x2= convertToInt(command[4]);
                int y2= convertToInt(command[5]);
                char coloration = convertToChar(command[6]);
                paint.addNewLine(x1,y1,x2,y2,coloration);
                break;
        }
    }


    public void setCommand(String[] command) {
        this.command = command;
    }

    public int convertToInt(String caseCommand) {
        return Integer.parseInt(caseCommand);
    }


    public char convertToChar(String caseCommand) {
        return caseCommand.charAt(0);
    }
}
