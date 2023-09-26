package Handlers;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The type Card defausse handler.
 */
public class CardDefausseHandler implements EventHandler<ActionEvent> {

    private final Controller controller;


    /**
     * Instantiates a new Card defausse handler.
     *
     * @param controller the controller
     */
    public CardDefausseHandler(Controller controller) {
        this.controller = controller;
    }




    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println(controller.getGame().getState());
        controller.defausseEvent();
    }
}
