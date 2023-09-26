package g55140.atl.blackjack.view;

import esi.atl.g55140.cards.Card;
import g55140.atl.blackjack.model.Player;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class ConsoleView {

    private Scanner input;

    /**
     * Constructeur Console
     */
    public ConsoleView() {
        input = new Scanner(System.in, StandardCharsets.UTF_8);
    }


    /**
     * Affiche msg de bienvenue
     */
    public void printWelcome() {
        System.out.println(" Bienvenue au blackjack");
    }

    /**
     * Demande si le joueur veut retirer une carte
     * @return vrai si il veut faux dans le cas contraire
     */
    public boolean askHit() {
        System.out.println("Voulez-vous tirer une carte ?  (o/n)");
        String request = input.next();
        return "o".equalsIgnoreCase(request);

    }

    /**
     * Demande au joueur s'il veut arreter de jouer ou pas
     * @return true s'il veut ,false síl veut continuer de jouer
     */
    public boolean askStop() {
        System.out.println("Voulez-vous arreter de jouer?  (o/n)");
        String request2 = input.next();
        return "o".equalsIgnoreCase(request2);
    }

    /**
     * Montre les cartes d'un joueur
     *
     * @param player
     */

    public void printPlayer(Player player) {
        System.out.println("Vos cartes actuellement : ");
        for (Card card : player.getCards()) {
            printACard(card);
        }
    }

    /**
     * Affiche une carte dans la console
     * @param card
     */

    public void printACard(Card card) {

        for (int i = 0; i < 15; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(card.toString() + "  =  " + card.getValue().getScore());
        for (int j = 0; j < 15; j++) {
            System.out.print("-");

        }
        System.out.println();
    }

    /**
     * Demande quelle somme il veut mettre dans son prtefeuille de jeu
     * @return la somme
     */
    public int askWallet() {
        int request3 = lectureRobusteInt("Quel somme d'argent voulez vous jouer (max: 100000e)? ");

        while (request3 <= 0) {

            System.out.println("Soyez serieux svp...entrez un bon nombre: ");
            request3 = input.nextInt();

        }


        while (request3 > 100000) {
            System.out.println("Pensez à votre femme, ne jouez pas si gros , réincérez une somme plus raisonnable :");
            request3 = input.nextInt();
        }
        return request3;
    }

    /**
     * Demande au joueur combien veut-il miser pour la manche
     * @return la mise
     */
    public int askABet() {
        System.out.println();
        int bet = lectureRobusteInt("Combien voulez-vous miser? ");
        while ( bet <= 0) {

            System.out.println("Soyez serieux svp...entrez un bon nombre: ");
            bet = input.nextInt();

        }

        return bet;
    }

    /**
     * Message de fin du jeu
     */

    public void printEnd() {
        System.out.println(" Vous avez décide d'arrêter de jouer , bonne chance à une autre table !!");
    }

    /**
     * Message indiquant le tour de la banque
     */
    public void auTourDeLaBank() {
        System.out.println("Les cartes de la banque ");
    }

    /**
     * message indiquant que le joueur a perdu la manche
     */

    public void msgManchePerdue() {
        System.out.println("Vous avez perdu la manche,la banque gagne!");
    }

    /**
     * Message indiquant que le joueur a gagnée la manche
     */
    public void msgMancheGagnee() {
        System.out.println("Bravo , vous avez remporte la manche");
    }

    /**
     * Lecture robuste d'un entier
     * @param message
     * @return un entier
     */

    public int lectureRobusteInt(String message){
        System.out.println(message);
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Le nombre saisi n' est pas un entier ");
            System.out.println(message);
        }
        return input.nextInt();

    }

    /**
     * Affiche le montant dans le portefeuille du joueur
     * @param player
     */
    public void seeWallet(Player player){
        System.out.println("Votre portefeuille contient :"+player.getWallet()+" euros");
    }



}
