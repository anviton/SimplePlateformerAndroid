package fr.iut.simpleplateformer.modele.logique;

import fr.iut.simpleplateformer.Observateur;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;


import java.util.List;

/**
 * Classe abstraite Afficheur permet de gérer la logique d'affichage
 * @author anviton khloichet
 */
public abstract class Afficheur extends Observateur {

    /**
     * Met à jour l'affichage du Personnage
     */
    public abstract void mettreAjourLAffichageDuPersonnagePrincipal();

    /**
     * Affiche le niveau
     * @param n le niveau à afficher
     * @param imgBloc tableau des images correspondantes aux blocs
     * @param peso personnage à afficher
     */
    public abstract void afficherLeNiveau(Niveau n, int[] imgBloc, Personnage peso);

    /**
     * Met à jour l'affichage du temps
     */
    public abstract void mettreAJourLAffichageDuTemps();

    /**
     * Retourne le temps
     */
    public abstract int recupererLeTemps();
}
