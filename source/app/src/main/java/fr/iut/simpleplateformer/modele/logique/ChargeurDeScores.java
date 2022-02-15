package fr.iut.simpleplateformer.modele.logique;


import java.io.BufferedReader;
import java.io.FileReader;

import fr.iut.simpleplateformer.modele.LesScores;
import fr.iut.simpleplateformer.modele.Score;

/**
 * Classe ChargeurDeScores permet de charger les scores
 */
public class ChargeurDeScores {

    /**
     * Permet de charger les scores
     * @param nomFichier nom du fichier ou sont enregistrés des scores
     * @return les scores chargés
     */
    public LesScores charger(String nomFichier){
        LesScores lesScores = new LesScores();
        try {
            FileReader lecteur = new FileReader(nomFichier);
            BufferedReader lecteurDeScore = new BufferedReader(lecteur);
            String ligne;
            String elementDeSeparation = ",";
            while ((ligne = lecteurDeScore.readLine()) != null) {
                String[] unScore = ligne.split(elementDeSeparation);
                lesScores.ajouterScore(new Score(unScore[0], Integer.parseInt(unScore[1]), Integer.parseInt(unScore[2])));
            }
            lecteurDeScore.close();
            lecteur.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lesScores;
    }
}
