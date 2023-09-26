package esi.atl.g55140.cards;

public class DemoDeck {

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Aucun paramètre entré : entrez un entier");
            System.exit(-1);
        }

        int numberOfCards = 0;

        try{
            numberOfCards = Integer.parseInt(args[0]);
        }catch(Exception exception){
            System.out.println("paramètre incorrect : entrez un entier " + numberOfCards);
            System.exit(-2);
        }

        Deck deck = new Deck() ;

        for (int index = 1; index <= numberOfCards; index++){
            Card card = deck.hit();
            System.out.println("Carte "+ index + " : "+card);
        }


    }




}
