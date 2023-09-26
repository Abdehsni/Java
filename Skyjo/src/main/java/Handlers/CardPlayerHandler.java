package Handlers;

import Controller.Controller;
import View.CardUi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 * The type Card player handler.
 */
public class CardPlayerHandler implements EventHandler<ActionEvent> {


    private final Controller controller;


    /**
     * Instantiates a new Card player handler.
     *
     * @param controller the controller
     */
    public CardPlayerHandler(Controller controller) {
        this.controller = controller;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        CardUi cardUi = (CardUi) actionEvent.getSource();
        System.out.println(cardUi.getIdPlayer().getValue());
        int index = cardUi.getIdCardOfPlayer();
        controller.cardPlayerEvent(index);
    }
}
