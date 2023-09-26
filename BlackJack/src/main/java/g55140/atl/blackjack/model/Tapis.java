package g55140.atl.blackjack.model;

import esi.atl.g55140.cards.Card;

import java.util.List;

/**
 * Classe tapis; là où le jeu se passe
 */
public class Tapis {

    private List<Card> player;
    private List<Card> bank;


    /**
     * Constructeur de Tapis
     *
     * @param player , les cartes du joueur
     * @param bank   , les cartes de la banque
     */
    public Tapis(List<Card> player, List<Card> bank) {
        this.player = player;
        this.bank = bank;
    }

    /**
     * Donne la somme de la valeur des cartes du player
     *
     * @param player
     * @return la somme de ses cartes
     */
    public int valueOfPlayerCards(List<Card> player) {
        int sum = 0;
        for (Card cards : player) {
            sum += cards.getValue().getScore();
        }
        return sum;
    }


    /**
     * Nombre que la banque a décidé de ne pas dépasser .
     * Elle arretera de tirer des cartes quand
     * ce nombre aura été atteint ou dépassé
     *
     * @param sumOfBank
     * @return
     */
    public boolean strategyOfBank(int sumOfBank) {
        return sumOfBank <= 17;
    }


}
