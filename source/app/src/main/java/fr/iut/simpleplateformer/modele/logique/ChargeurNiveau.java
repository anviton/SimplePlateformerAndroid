package fr.iut.simpleplateformer.modele.logique;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.modele.metier.Bloc;
import fr.iut.simpleplateformer.modele.metier.HitBox;
import fr.iut.simpleplateformer.modele.metier.Niveau;

/**
 * Classe ChargeurNiveau permet de charger un niveau
 * @author anviton khloichet
 */
public class ChargeurNiveau {

    /**
     * Charge un Niveau
     * @param chemin chemin du niveau à charger
     * @return le Niveau chargé
     */
    public Niveau chargerNiveau(String chemin){
        Niveau n;
        List<Bloc> listeDeBlocs = new ArrayList<>();
        List<Integer> listePositions = new ArrayList<>();
        int i = 0, j = 0;
        String elementDeSeparation = ",";
        String cheminFond = null;
        try {
            FileReader lecteur = new FileReader(chemin);
            BufferedReader lecteurDeTuile = new BufferedReader(lecteur);
            String ligne;
            cheminFond = lecteurDeTuile.readLine();

            String[] positions = lecteurDeTuile.readLine().split(elementDeSeparation);
            for (String pos : positions){
                listePositions.add(Integer.parseInt(pos));
            }

            while ((ligne = lecteurDeTuile.readLine()) != null){
                String[] tabTuiles = ligne.split(elementDeSeparation);
                for (String tuile : tabTuiles){
                    int type = Integer.parseInt(tuile);
                    if (type == 1 || type == 2) {
                        listeDeBlocs.add(new Bloc(type, i, j, new HitBox(50,50)));
                    }
                    else {
                        listeDeBlocs.add(new Bloc(type, i, j, null));
                    }
                    i++;
                }
                i = 0;
                j++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        n = new Niveau(listePositions, cheminFond, listeDeBlocs);
        if (!listeDeBlocs.isEmpty()) {
            Bloc bloc = listeDeBlocs.get(listeDeBlocs.size() - 1);
            n.setHauteurNiveau(bloc.getPositionY());
            n.setLargeurNiveau(bloc.getPositionX());
        }
        return n;
    }

}
