package g55140.atl.blackjack.model;

import esi.atl.g55140.cards.Deck;

/**
 * Classe model qui reprend le paquet en jeu, le joueur ,la banque et le tapis(l'endroit où le jeu se passe)
 */

public class Model {

    private Deck deck;
    private Player player;
    private Player bank;
    private Tapis tapis;
    private final int MaxValueBlackJack=21;

    /**
     * Constructeur de Model
     */
    public Model() {
        this.deck=new Deck();
        this.player= new Player(0);
        this.bank=new Player(100000000);
        this.tapis= new Tapis(player.getCards(),bank.getCards());
    }


    /**
     * Vérifie si le joueur ou la banque perd
     * @return vrai si le joueur ou la banque perd
     */

    public boolean isAGameover(){
        return (tapis.valueOfPlayerCards(player.getCards())>MaxValueBlackJack||
                ((tapis.valueOfPlayerCards(bank.getCards())> tapis.valueOfPlayerCards(player.getCards()))&&
                        (tapis.valueOfPlayerCards(player.getCards())<=MaxValueBlackJack)));
    }


    /**
     * getter du player
     * @return le joueur
     */
    public Player getPlayer(){
        return player;
    }

    /**
     * getter de la banque
     * @return la banque
     */
    public Player getBank(){
        return bank;
    }

    /**
     * getter du chiffre maximum que l'on peut atteindre au BlackJack
     *
     * @return le chiffre Max
     */
    public int getMaxValueBlackJack() {
        return MaxValueBlackJack;
    }

    /**
     * getter du deck
     * @return
     */
    public Deck getDeck() {
        return deck;
    }


    /**
     * S'assure que le deck ne s'épuise jamais
     */
    public void deckNeverEmpty(){
        if(deck.isEmpty()){
            deck= new Deck();
        }
    }


    /**
     * show a card and remove it from the deck
     *
     */
    public void hit(){
        deck.hit();
    }


}
