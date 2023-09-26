package g55140.atl.blackjack.model;

import esi.atl.g55140.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * classe player
 */
public class Player {

    private List<Card> cards;
    private int wallet;
    private int score;

    /**
     * Contructeur du player avec la somme qu'il veut mettre dans son portefeuille
     *
     * @param wallet
     */
    public Player(int wallet) {
        this.cards = new ArrayList<Card>();
        this.wallet = wallet;
        this.score = 0;
    }

    /**
     * getter du score
     *
     * @return le score
     */
    public int getScore() {
        return score;
    }

    /**
     * setter du score
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * ajoute une carte dans la main du joueur
     *
     * @param card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * setter du portefeuille du joueur
     *
     * @param wallet
     */
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    /**
     * getter du portefeuille du joueur
     *
     * @return le portefueille du joueur
     */
    public int getWallet() {
        return wallet;
    }

    /**
     * getter des cartes du joueur
     *
     * @return ses cartes
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * enleve toutes les cartes du joueur
     */
    public void removeAllCard() {
        cards.clear();
    }

}
