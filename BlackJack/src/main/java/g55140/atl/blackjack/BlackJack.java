package g55140.atl.blackjack;

import g55140.atl.blackjack.controller.Controller;
import g55140.atl.blackjack.model.Model;
import g55140.atl.blackjack.view.ConsoleView;

/**
 * Classe où le jeu est lancé
 */
public class BlackJack {

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {

        Model model = new Model();
        ConsoleView view = new ConsoleView();
        Controller controller = new Controller(model,view);
        controller.start();

    }


}
