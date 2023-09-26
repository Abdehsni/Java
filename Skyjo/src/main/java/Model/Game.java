package Model;

import Observable_Observer.Observable;
import View.IdCardOfPlayer;

/**
 * The type Game.
 */
public class Game extends Observable {

    private final Player player1;
    private final Player player2;
    private final DeckCards deck;
    private final DefausseCards defausse;
    private boolean player1Turn = false;
    private GameState state;
    private boolean turnfinished=false;
    private boolean player1FinishedFirst;
    private int scoreOfFirstToFinish;


    /**
     * Instantiates a new Game.
     */
    public Game() {
        player1 = new Player(IdCardOfPlayer.CARD_OF_P1);
        player2 = new Player(IdCardOfPlayer.CARD_OF_P2);
        deck = new DeckCards();
        defausse = new DefausseCards(deck);
        state = GameState.START;
        player1.initialise(deck);
        player2.initialise(deck);
        updateScores();
    }


    /**
     * Gets player 1.
     *
     * @return the player 1
     */
    public Player getPlayer1() {
        return new Player(player1);
    }

    /**
     * Gets player 2.
     *
     * @return the player 2
     */
    public Player getPlayer2() {
        return new Player(player2);
    }

    /**
     * Gets deck.
     *
     * @return the deck
     */
    public DeckCards getDeck() {
        return new DeckCards(deck);
    }

    /**
     * Gets defausse.
     *
     * @return the defausse
     */
    public DefausseCards getDefausse() {
        return new DefausseCards(defausse);
    }


    /**
     * Remove the card from the deck card.
     *
     * @return the card
     */
    public Card removeTheCardFromTheDeck() {
        return deck.drawACard();
    }


    /**
     * Look to card from the deck.
     */
    public void lookToCardFromTheDeck() {
        deck.beforeDrawingACard();

    }


    /**
     * Show card of player.
     *
     * @param index the index
     */
    public void showCardOfPlayer(int index) {

        if(isPlayer1Turn()){
            player1.showAHiddenCard(index);
        }else{
            player2.showAHiddenCard(index);
        }
        updateScores();
    }


    /**
     * Draw one card from the defausse card.
     *
     * @return the card
     */
    public Card drawOneCardFromTheDefausse() {
        Card card = defausse.getCardOfDefausse();
        defausse.removeCardFromDefausse();
        return card;
    }


    /**
     * Put card on the defausse.
     *
     * @param card the card
     */
    public void putCardOnTheDefausse(Card card) {
        defausse.addToDefausse(card);
    }


    /**
     * Swap cards.
     *
     * @param deckOrDefausse      the deck or defausse
     * @param indexOfCardSelected the index of card selected
     */
    public void swapCards(Card deckOrDefausse, int indexOfCardSelected) {
        Card intermediate;
        if (player1Turn) {
            intermediate = player1.getListCards().get(indexOfCardSelected);
            player1.setOneCard(indexOfCardSelected, deckOrDefausse);
        } else {
            intermediate = player2.getListCards().get(indexOfCardSelected);
            player2.setOneCard(indexOfCardSelected, deckOrDefausse);
        }
        putCardOnTheDefausse(intermediate);
        updateScores();
    }


    /**
     * Is over boolean.
     *
     * @return the boolean
     */
    public Boolean isOver() {
        return (turnfinished &&(player1.allCardsShowed()|| player2.allCardsShowed()));
    }

    /**
     * Update scores.
     */
    public void updateScores() {
        player1.updateScore();
        player2.updateScore();
    }

    /**
     * First player to begin.
     */
    public void firstPlayerToBegin() {
        int min = 1;
        int max = 2;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;

        player1Turn = player1.getScore() > player2.getScore() || ((rand == 1) && (player1.getScore() == player2.getScore()));
        System.out.println(player1Turn);

    }

    /**
     * Is player 1 turn boolean.
     *
     * @return the boolean
     */
    public boolean isPlayer1Turn() {
        return player1Turn;
    }


    /**
     * Switch player.
     */
    public void switchPlayer(){

        if(player1Turn){
            played(player1);
            player1Turn=false;
        }

        else {
            played(player2);
            player1Turn=true;
        }


        if (player1.isPlayed()&&player2.isPlayed()){
            turnfinished=true;
        }

    }


    /**
     * Next turn.
     */
    public void nextTurn(){
            unPlay(player1);
            unPlay(player2);
            turnfinished = false;
    }

    /**
     * Is turnfinished boolean.
     *
     * @return the boolean
     */
    public boolean isTurnfinished() {
        return turnfinished;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public GameState getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(GameState state) {
        this.state = state;
    }

    /**
     * Played.
     *
     * @param p the p
     */
    public void played(Player p){
        p.setPlayed();
    }

    /**
     * Un play.
     *
     * @param p the p
     */
    public void unPlay(Player p){
        p.setUnPlayed();
    }


    /**
     * Turn before is over boolean.
     *
     * @return the boolean
     */
    public boolean turnBeforeIsOver(){
        return ((!turnfinished)&&(player1.allCardsShowed()|| player2.allCardsShowed()));
    }


    /**
     * Is player 1 finishing first.
     */
    public void isPlayer1FinishingFirst(){
        if(player1.allCardsShowed()){
            scoreOfFirstToFinish=player1.getScore();
            player1FinishedFirst =true;
        }else{
            scoreOfFirstToFinish=player2.getScore();
            player1FinishedFirst =false;
        }

    }

    /**
     * Maybe malus.
     */
    public void maybeMalus(){
        if(player1FinishedFirst){
            int scoreP1=player1.getScore();
            if(scoreP1>player2.getScore()){
                player1.setScore(scoreP1*2);
            }
        }else{
            int scoreP2=player2.getScore();
            if(scoreP2>player1.getScore()){
                player2.setScore(scoreP2*2);
            }
        }
        notifyObservers(this);
    }


    /**
     * Winner player.
     *
     * @return the player
     */
    public Player winner(){
        if(player1.getScore()>player2.getScore()){
            return player2;
        }else{
            return player1;
        }
    }


}
