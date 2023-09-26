package BmrFrontEnd;

import BmrBackend.StyleDeVie;
import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import BmrBackend.Bmr;
import pattern.Observable;
import pattern.Observer;

import java.util.List;


public class Software implements Observer {

    private assistantRoot assistR;
    private ButtonValidate buttonV;


    public Software(Stage primaryStage) {
        primaryStage.setTitle("Calcul du BMR");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(300);
        VBox root = new VBox(10);
        this.assistR = new assistantRoot();
        this.buttonV = new ButtonValidate();

        this.assistR = new assistantRoot();
        this.buttonV = new ButtonValidate();

        root.getChildren().addAll(assistR,buttonV);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public assistantRoot getAssistR() {
        return assistR;
    }


    @Override
    public void update(Observable observable,Object arg) {
        List<Double> data= (List<Double>) arg;
        showResultBmr(data.get(0), data.get(1));
    }



    public void addHandlerButton (Controller controller){
        ButtonHandler handler = new ButtonHandler(controller);
        buttonV.setOnAction(handler);
    }


    public void showResultBmr(double bmr,double kcal){
        assistR.getGridR().setTextBMR(bmr);
        assistR.getGridR().setTextcal(kcal);
    }

    public void showError(){
        assistR.getGridR().setError();
    }

}

