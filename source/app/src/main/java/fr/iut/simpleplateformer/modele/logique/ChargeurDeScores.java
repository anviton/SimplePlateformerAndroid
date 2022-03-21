package fr.iut.simpleplateformer.modele.logique;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import fr.iut.simpleplateformer.modele.LesScores;
import fr.iut.simpleplateformer.modele.Score;

/**
 * Classe ChargeurDeScores permet de charger les scores
 */
public class ChargeurDeScores {

    /**
     * Permet de charger les scores
     * @param fichier nom du fichier ou sont enregistrés des scores
     * @return les scores chargés
     */
    public LesScores charger(InputStream fichier){
        LesScores lesScores = new LesScores();
        try {
            InputStreamReader lecteur = new InputStreamReader(fichier);
            BufferedReader lecteurDeScores = new BufferedReader(lecteur);
            String ligne;
            String elementDeSeparation = ",";
            while ((ligne = lecteurDeScores.readLine()) != null) {
                String[] unScore = ligne.split(elementDeSeparation);
                lesScores.ajouterScore(new Score(unScore[0], Integer.parseInt(unScore[1]), Integer.parseInt(unScore[2])));
            }
            lecteurDeScores.close();
            lecteur.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lesScores;
    }
}
