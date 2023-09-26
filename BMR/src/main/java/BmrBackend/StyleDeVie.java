package BmrBackend;

public enum StyleDeVie {
    SEDENTAIRE(1.2),PEU_ACTIF(1.375),ACTIF(1.55),FORT_ACTIF(1.725),EXTREMEMENT_ACTIF(1.9);

    private final double facteur;

    private StyleDeVie(double indice) {
        facteur=indice;
    }

    public double getFacteur() {
        return facteur;
    }
}
