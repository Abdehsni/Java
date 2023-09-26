package asciiPaint;

import asciiPaint.model.Shape;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class View {

    private final Scanner input;

    public View() {
        input = new Scanner(System.in, StandardCharsets.UTF_8);
    }

    public void welcome() {
        System.out.println("Bienvenue dans AsciiPaint");
    }

    public void presentFormat() {
        System.out.println("quel action voudrais tu effectuer?");
        System.out.println("Pour afficher le dessin:  show ");
        System.out.println("Pour afficher la liste des formes sur le dessin: list");
        System.out.println("Pour créer une forme: add puis circle/rectangle/square/line puis x puis y puis radius/(width,height)/side/(x2,y2) puis color(un caractère) ");
        System.out.println("Pour déplacer une forme : move puis i(=numéro d'une forme de la liste) puis dx puis dy");
    }

    public String[] receiveCommand() {

        String commande = input.nextLine();
        String[] list = commande.split("\\s+");

        if (list[0].equalsIgnoreCase("show") || list[0].equalsIgnoreCase("list")) {
            if (list.length != 1) {
                System.out.println("ta commande n'existe pas , un show ou list s'emploie tout seul ,réessaye");
                presentFormat();
                list = receiveCommand();
            }
            return list;
        } else if (list[0].equalsIgnoreCase("add")) {
            if (list[1].equalsIgnoreCase("circle") || list[1].equalsIgnoreCase("square")) {
                if (list.length != 6) {
                    System.out.println("respecte le format ,réessaye :");
                    presentFormat();
                    list = receiveCommand();

                }
                return list;
            } else if (list[1].equalsIgnoreCase("rectangle") ||list[1].equalsIgnoreCase("line")) {
                if (list.length != 7) {
                    System.out.println("respecte le format ,réessaye :");
                    presentFormat();
                    list = receiveCommand();

                }
                return list;

            } else {
                System.out.println(" respecte le format ,réessaye :");
                presentFormat();
                list = receiveCommand();
                return list;
            }

        } else if (list[0].equalsIgnoreCase("move")) {
            if (list.length != 4) {
                System.out.println("respecte le format ,réessaye :");
                presentFormat();
                list = receiveCommand();
            }
            return list;
        } else {
            System.out.println("ta commande n'existe pas , respecte le format ,réessaye :");
            presentFormat();
            list = receiveCommand();
            return list;
        }

    }

    public boolean terminerPaint() {

        System.out.println(" Avez-vous terminé (o/n) ?");
        String reponse = input.next();
        char rep = reponse.charAt(0);

        while (rep != 'o' && rep != 'n') {
            System.out.println("Entrez une réponse valable :");
            reponse = input.next();
            rep = reponse.charAt(0);
        }
        if (rep == 'o') return true;
        else return false;
    }

    public void msgByeBye() {
        System.out.println("Merci d'avoir utilisé l'appli , Aurevoir");
    }

    public void showListForm(List<Shape> shapes) {
        System.out.println("List of shapes :");
        int i = 1;
        for (Shape shape : shapes) {
            System.out.println(i + ") " + shape.toString());
            i++;
        }
    }


}