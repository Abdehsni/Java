package controller;


import BmrBackend.Bmr;
import BmrBackend.StyleDeVie;
import BmrFrontEnd.Software;
import javafx.application.Application;
import javafx.stage.Stage;

public class Controller{

    private Bmr bmr;
    private Software software;


    public Controller(Bmr bmr, Software software) {
        this.bmr = bmr;
        this.software = software;
    }


    public void addObserver(){
        bmr.registerObserver(software);
    }


    public void collectData(){
        int taille = software.getAssistR().getGridL().getTaille();
        int poid = software.getAssistR().getGridL().getPoid();
        int age = software.getAssistR().getGridL().getAge();
        if(!software.getAssistR().getGridL().isManSelected())bmr.setFemelle(true);
        StyleDeVie lfstl= software.getAssistR().getGridL().checkLifestyle();


        if(taille<0||taille>450){
            throw new IllegalArgumentException("Pas de géants sur cette planète");
        }
        else if(poid<0||poid>300){
            throw new IllegalArgumentException("Pas de baleine sur terre");
        }
        else if(age<0||age>100){
            throw new IllegalArgumentException("Age Impossible");
        }
        else {
            bmr.setTaille(taille);
            bmr.setAge(age);
            bmr.setPoid(poid);
            bmr.setStyledevie(lfstl);
        }
    }

    public void calcul() {
         bmr.calcul();
    }

//    public void calculKcal(){
//         bmr.calcCalorie();
//    }

//    public void showResult(){
//        software.showResultBmr(calculBmr(),calculKcal());
//    }

    public void showError(){
        software.showError();
    }



//    @Override
//    public void start(Stage stage) throws Exception {
//        this.addObserver();
//        software.start(stage);
//        software.addEventHandler();
//    }



}
