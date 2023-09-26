package Handlers;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The type Card deck handler.
 */
public class CardDeckHandler implements EventHandler<ActionEvent> {

    private final Controller controller;


    /**
     * Instantiates a new Card deck handler.
     *
     * @param controller the controller
     */
    public CardDeckHandler(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println(controller.getGame().getState());
        controller.deckEvent();
    }
}
