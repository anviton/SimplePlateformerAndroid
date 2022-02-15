package fr.iut.simpleplateformer.modele.logique;

import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;


import java.util.List;

/**
 * Classe abstraite Afficheur permet de gérer la logique d'affichage
 * @author anviton khloichet
 */
public abstract class Afficheur {

    /**
     * Met à jour l'affichage du Personnage
     * @param p personnage dont l'affichage doit être mis à jour
     * @param ancienPositionX ancienne position X du personnage (position X lors de la dernière mise à jour)
     * @param ancienPositionY ancienne position Y du personnage (position Y lors de la dernière mise à jour)
     */
    public abstract void mettreAjourLAffichageDuPersonnagePrincipal(Personnage p, double ancienPositionX, double ancienPositionY);

    /**
     * Affiche le niveau
     * @param n le niveau à afficher
     * @param cheminImagesBlocs liste des images correspondant aux blocs
     * @param peso personnage à afficher
     */
    public abstract void afficherLeNiveau(Niveau n, List<String> cheminImagesBlocs, Personnage peso);

    /**
     * Met à jour l'affichage du temps
     * @param temps temps à afficher
     */
    public abstract void mettreAJourLAffichageDuTemps(int temps);

}
