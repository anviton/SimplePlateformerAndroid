package fr.iut.simpleplateformer.modele.logique;



import java.io.BufferedWriter;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

import fr.iut.simpleplateformer.modele.LesScores;
import fr.iut.simpleplateformer.modele.Score;

/**
 * Classe SauveurDeScores permet la sauvegarde des scores
 * @author anviton khloichet
 */
public class SauveurDeScores {

    /**
     * Sauvegarde les scores
     * @param lesScores scores à sauvegarder
     * @param fichier fichier dans lequel les scores vont être sauvegardés
     */
    public void sauver(LesScores lesScores, OutputStream fichier){
        try {
            OutputStreamWriter auteur = new OutputStreamWriter(fichier);
            BufferedWriter auteurDeScores = new BufferedWriter(auteur);
            for (Score score : lesScores.getListeScores()) {
                auteurDeScores.write(score.getNom() + ",");
                auteurDeScores.write(score.getNiveau() + ",");
                auteurDeScores.write(score.getTemps() + "");
                auteurDeScores.newLine();
            }
            auteurDeScores.close();
            auteur.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
