package BmrFrontEnd;

import BmrBackend.StyleDeVie;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class gridLeft extends GridPane {

    private TextField textetaille;
    private TextField textePoid;
    private TextField texteAge;
    private RadioButton femme;
    private RadioButton homme;
    private ChoiceBox lifestyles;


    public gridLeft() {


        Label titleGridLeft = new Label("Données");
        titleGridLeft.setUnderline(true);
        this.add(titleGridLeft,0,0);

        Label asktaille = new Label("Taille (cm)");
        this.textetaille = new TextField();
        this.add(asktaille,0,1);
        this.add (textetaille,1,1,2,1);

        Label askpoid = new Label("Poids (kg)");
        this.textePoid = new TextField();
        this.add(askpoid,0,2);
        this.add (textePoid,1,2,2,1);

        Label askage= new Label("Age (années)");
        this.texteAge = new TextField();
        this.add(askage,0,3);
        this.add (texteAge,1,3,2,1);

        Label asksexe = new Label("Sexe");
        this.femme = new RadioButton("Femme");
        this.homme = new RadioButton("Homme");
        ToggleGroup toggleGroup = new ToggleGroup();
        femme.setToggleGroup(toggleGroup);
        homme.setToggleGroup(toggleGroup);
        this.add(asksexe,0,4);
        this.add(femme,1,4);
        this.add(homme,2,4);

        Label asklifestyle = new Label("Style de vie");
        this.lifestyles = new ChoiceBox();
        lifestyles.getItems().addAll("Sédentaire","Peu actif","Actif","Fort actif","Extremement actif");
        this.add(asklifestyle,0,5);
        this.add (lifestyles,1,5,2,1);

        this.setAlignment(Pos.TOP_LEFT);
        this.setHgap(10);
        this.setVgap(15);


    }

    public int getTaille() {
        return Integer.parseInt(textetaille.getText());
    }
    public int getPoid() {
        return Integer.parseInt(textePoid.getText());
    }

    public int getAge() {
        return Integer.parseInt(texteAge.getText());
    }

    public boolean isManSelected(){
        return homme.isSelected();
    }


    public StyleDeVie checkLifestyle() {
        StyleDeVie lifestyle = null;
        switch((String)lifestyles.getValue()){
            case "Sédentaire":
                lifestyle=StyleDeVie.SEDENTAIRE;
                break;
            case "Peu actif":
                lifestyle=StyleDeVie.FORT_ACTIF;
                break;
            case "Actif":
                lifestyle=StyleDeVie.ACTIF;
                break;
            case "Fort actif":
                lifestyle=StyleDeVie.FORT_ACTIF;
                break;
            case "Extremement actif":
                lifestyle=StyleDeVie.EXTREMEMENT_ACTIF;
                break;
        }
    return lifestyle;
    }



}
