package BmrFrontEnd;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class gridRight extends GridPane {

    private TextField textBMR;
    private TextField textcal;

    public gridRight() {

        Label titlegridright = new Label("Résultats");
        titlegridright.setUnderline(true);
        this.add(titlegridright,0,0);


        Label textresult = new Label("BMR");
        this.textBMR = new TextField();
        this.add(textresult,0,1);
        this.add (textBMR,1,1);


        Label textcalories = new Label("calories");
        this.textcal = new TextField();
        this.add(textcalories,0,2);
        this.add (textcal,1,2);

        this.setAlignment(Pos.TOP_LEFT);
        this.setHgap(10);
        this.setVgap(15);
    }

    public String getTextBMR() {
        return textBMR.getText();
    }

    public String getTextcal() {
        return textcal.getText();
    }

    public void setTextBMR( double textb) {
        this.textBMR.setText(Double.toString(textb));
    }

    public void setTextcal( double textc) {
        this.textcal.setText(Double.toString(textc));
    }

    public void setError(){
        this.textcal.setText("######ERROR#####");
        this.textcal.setStyle("-fx-text-fill: red;");
        this.textBMR.setText("######ERROR#####");
        this.textBMR.setStyle("-fx-text-fill: red;");
    }

}
