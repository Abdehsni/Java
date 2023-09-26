package BmrFrontEnd;

import javafx.scene.layout.HBox;

public class assistantRoot extends HBox {

    private gridLeft gridL;
    private gridRight gridR;


    public assistantRoot() {
        this.gridL = new gridLeft();
        this.gridR = new gridRight();
        this.getChildren().addAll(gridL, gridR);
    }

    public gridLeft getGridL() {
        return gridL;
    }

    public gridRight getGridR() {
        return gridR;
    }
}
