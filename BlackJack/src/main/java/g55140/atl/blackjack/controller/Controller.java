package g55140.atl.blackjack.controller;

import esi.atl.g55140.cards.Card;
import g55140.atl.blackjack.model.Model;

import g55140.atl.blackjack.model.Player;
import g55140.atl.blackjack.model.Tapis;
import g55140.atl.blackjack.view.ConsoleView;

import java.util.Objects;

public class Controller {

    private Model model;
    private ConsoleView view;

    /**
     * Constucteur de Controller
     * @param model
     * @param view
     */
    public Controller(Model model, ConsoleView view) {

        this.model = Objects.requireNonNull(model, "Modèle absent");
        this.view = Objects.requireNonNull(view, "Vue absente");
    }

    /**
     * Déroulement du jeu
     */

    public void start() {
        view.printWelcome();
        int wallet = view.askWallet();
        Player player = model.getPlayer();
        Player bank = model.getBank();
        player.setWallet(wallet);
        int bet;
        boolean hit = true;

        do {
            bet = view.askABet();
            while (bet > wallet) {
                System.out.println("vous n' avez pas cette somme dans le portefeuille !");
                bet = view.askABet();
            }

            for (int i = 0; i < 2; i++) {
                givingCard(player);
            }
            Tapis tapis = new Tapis(player.getCards(), bank.getCards());
            view.printPlayer(player);
            while (!model.isAGameover() && hit) {

                hit = view.askHit();
                if (hit) {
                    Card cardForPlayer = model.getDeck().showTheCard();
                    view.printACard(cardForPlayer);
                    givingCard(player);
                    model.deckNeverEmpty();

                }

                while (tapis.strategyOfBank(tapis.valueOfPlayerCards(bank.getCards())) && !hit) {
                    view.auTourDeLaBank();
                    Card cardForBank = model.getDeck().showTheCard();
                    view.printACard(cardForBank);
                    givingCard(bank);
                    model.deckNeverEmpty();
                }

                model.deckNeverEmpty();
            }
            int resultPlayer = tapis.valueOfPlayerCards(player.getCards());
            int resultBank = tapis.valueOfPlayerCards(bank.getCards());
            if (resultPlayer > resultBank && resultPlayer < model.getMaxValueBlackJack() ||
                    resultBank > model.getMaxValueBlackJack() && resultPlayer < model.getMaxValueBlackJack()) {
                view.msgMancheGagnee();
                player.setWallet(wallet + bet);
                player.setScore(player.getScore() + 1);

            } else {
                view.msgManchePerdue();
                player.setWallet(wallet - bet);
                bank.setScore(bank.getScore() + 1);
                view.seeWallet(player);
            }
            player.removeAllCard();
            bank.removeAllCard();
        } while (!view.askStop() || player.getWallet() == 0);
        view.seeWallet(player);
        System.out.println("Vous avez remporte " + player.getScore() + " manches et la banque :" + bank.getScore());
        view.printEnd();

    }


    /**
     * Donne une carte à un joueur
     * @param player
     */
    private void givingCard(Player player) {
        player.addCard(model.getDeck().showTheCard());
        model.hit();
    }
}
