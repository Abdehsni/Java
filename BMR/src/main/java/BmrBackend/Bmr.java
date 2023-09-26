package BmrBackend;

import pattern.Observable;
import pattern.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bmr  extends Observable {
    private int Taille;
    private int Poid;
    private int Age;
    private boolean Femelle;
    private StyleDeVie styledevie;
    private double resultBmr;
    private double resultKcal;

    public Bmr() {
    }

//    public Bmr(int taille, int poid, int age, boolean femelle, StyleDeVie styledevie) {
//        Objects.requireNonNull(taille);
//        Objects.requireNonNull(age);
//        Objects.requireNonNull(femelle);
//        Objects.requireNonNull(poid);
//        Objects.requireNonNull(styledevie);
//        requirePositif(taille);
//        requirePositif(poid);
//        requirePositif(age);
//        Taille = taille;
//        Poid = poid;
//        Age = age;
//        Femelle = femelle;
//        this.styledevie = styledevie;
//
//    }

    public static void requirePositif(int number) {
        if (number < 0) throw new IllegalArgumentException("Cannot Be negative");
    }


    public int getTaille() {
        return Taille;
    }

    public int getPoid() {
        return Poid;
    }

    public int getAge() {
        return Age;
    }

    public boolean isFemelle() {
        return Femelle;
    }

    public StyleDeVie getStyledevie() {
        return styledevie;
    }


    public void calcBMR() {
        if (Femelle) resultBmr = ((9.6 * Poid) + (1.8 * Taille) - (4.7 * Age) + 655);
        else  resultBmr=(((13.7 * Poid) + (5 * Taille) - (6.8 * Age) + 66));
    }

    public void calcCalorie() {
        resultKcal = resultBmr * (styledevie.getFacteur());
    }

    public void calcul(){
        calcBMR();
        calcCalorie();
        List<Double>datas= new ArrayList<>();
        datas.add(resultBmr);
        datas.add(resultKcal);
        notifyObservers(datas);
    }

    public void setTaille(int taille) {
        Taille = taille;
    }

    public void setPoid(int poid) {
        Poid = poid;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setFemelle(boolean femelle) {
        Femelle = femelle;
    }

    public void setStyledevie(StyleDeVie styledevie) {
        this.styledevie = styledevie;
    }

//    public void calcBMR(double taille, double poid, double age, boolean male, StyleDeVie style) {
//      //  if (isFemelle()) return ((9.6 * getPoid()) + (1.8 * getTaille()) - (4.7 * getAge()) + 655);
//      //  else return ((13.7 * getPoid()) + (5 * getTaille()) - (6.8 * getAge()) + 66);
//        double bmr= 728;
//        notifyObservers(bmr);
//    }
}
