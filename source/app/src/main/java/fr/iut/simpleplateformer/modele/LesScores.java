package fr.iut.simpleplateformer.modele;

import java.util.ArrayList;
import java.util.List;

public class LesScores {
    private List<Score> listeScores;


    public LesScores() {
        this.listeScores = new ArrayList<>();
    }

    public void ajouterScore(Score score){
        listeScores.add(score);
    }

    public List<Score> getListeScores() {
        return listeScores;
    }
}
