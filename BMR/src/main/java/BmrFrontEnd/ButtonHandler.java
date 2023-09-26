package BmrFrontEnd;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonHandler implements EventHandler<ActionEvent> {

    private Controller controller;

    public ButtonHandler(Controller controller) {
        this.controller = controller;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            controller.collectData();
            controller.calcul();


        }
        catch(Exception e){
            controller.showError();
            }
    }
}
