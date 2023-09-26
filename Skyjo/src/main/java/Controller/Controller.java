package Controller;

import Model.Card;
import Model.Game;
import Model.GameState;
import View.IdCardOfPlayer;
import View.SkyjoGui;
import javafx.stage.Stage;


/**
 * The type Controller.
 */
public class Controller {

    private final Game game;
    private final SkyjoGui view;


    /**
     * Instantiates a new Controller.
     *
     * @param game the game
     * @param view the view
     */
    public Controller(Game game, SkyjoGui view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Add observer.
     */
    public void addObserver() {
        game.registerObserver(view);
    }


    /**
     * Start stage.
     *
     * @param stage the stage
     * @return the stage
     */
    public Stage start(Stage stage) {
        return view.startView(stage, this);
    }


    /**
     * Play game.
     */
    public void playGame() {
        whoStart();
    }

    /**
     * Show card deck.
     */
    public void showCardDeck() {
        game.lookToCardFromTheDeck();
    }

    /**
     * Show one card of player.
     *
     * @param index the index
     */
    public void showOneCardOfPlayer(int index) {
        game.showCardOfPlayer(index);
    }

    /**
     * State of game game state.
     *
     * @return the game state
     */
    public GameState stateOfGame() {
        return game.getState();
    }


    /**
     * Set state to take card.
     */
    public void setStateTo_Take_Card() {
        game.setState(GameState.TAKE_CARD);
        game.notifyObservers(game);
    }

    /**
     * Set state to deck.
     */
    public void setStateTo_Deck() {
        game.setState(GameState.DECK);
        game.notifyObservers(game);
    }

    /**
     * Set state to defausse.
     */
    public void setStateTo_Defausse() {
        game.setState(GameState.DEFAUSSE);
        game.notifyObservers(game);
    }

    /**
     * Set state to drop.
     */
    public void setStateTo_Drop() {
        game.setState(GameState.DROP);
        game.notifyObservers(game);
    }

    /**
     * Set state to end.
     */
    public void setStateTo_End() {
        game.setState(GameState.END);
        game.notifyObservers(game);
    }


    /**
     * Use deck card.
     *
     * @param index the index
     */
    public void useDeckCard(int index) {
        Card cardOfDeck = game.removeTheCardFromTheDeck();
        game.swapCards(cardOfDeck, index);
    }

    /**
     * Use defausse card.
     *
     * @param index the index
     */
    public void useDefausseCard(int index) {
        Card cardOfDeffausse = game.drawOneCardFromTheDefausse();
        game.swapCards(cardOfDeffausse, index);
    }


    /**
     * Put deck card to defausse.
     */
    public void putDeckCardToDefausse() {
        Card cardOfDeck = game.removeTheCardFromTheDeck();
        game.putCardOnTheDefausse(cardOfDeck);
    }


    /**
     * Who start.
     */
    public void whoStart() {
        game.firstPlayerToBegin();
        setStateTo_Take_Card();
    }


    /**
     * Gets game.
     *
     * @return the game
     */
    public Game getGame() {
        return game;
    }


    private void switchP() {
        game.switchPlayer();
    }


    /**
     * Deck event.
     */
    public void deckEvent() {
        if (stateOfGame().equals(GameState.TAKE_CARD)) {
            showCardDeck();
            setStateTo_Deck();
        }
    }


    /**
     * Defausse event.
     */
    public void defausseEvent() {
        if (stateOfGame().equals(GameState.TAKE_CARD)) {
            setStateTo_Defausse();

        } else if (stateOfGame().equals(GameState.DECK)) {
            putDeckCardToDefausse();
            setStateTo_Drop();
            System.out.println(game.isPlayer1Turn());

        }

    }


    /**
     * Card player event.
     *
     * @param index the index
     */
    public void cardPlayerEvent(int index) {

        switch (stateOfGame()) {
            case DECK:
                useDeckCard(index);
                switchP();
                setStateTo_Take_Card();
                break;
            case DEFAUSSE:
                useDefausseCard(index);
                switchP();
                setStateTo_Take_Card();
                break;
            case DROP:
                showOneCardOfPlayer(index);
                switchP();
                setStateTo_Take_Card();
                break;
        }

        if(game.isOver()){
            game.maybeMalus();
            setStateTo_End();
        }else if(game.turnBeforeIsOver()){
            game.isPlayer1FinishingFirst();
        }
        else if(game.isTurnfinished()){
            game.nextTurn();
        }
    }


    /**
     * Id current player id card of player.
     *
     * @return the id card of player
     */
    public IdCardOfPlayer idCurrentPlayer(){
        if(game.isPlayer1Turn())return game.getPlayer1().getIdOwnerOfCards();
        else return game.getPlayer2().getIdOwnerOfCards();
    }


}