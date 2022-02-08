package fr.iut.simpleplateformer.modele;

public class Score {

    private String nom;
    private int niveau;
    private int temps;

    public Score(String nom, int niveau, int temps) {
        this.nom = nom;
        this.niveau = niveau;
        this.temps = temps;


    }

    public String getNom() {
        return nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getTemps() {
        return temps;
    }
}
