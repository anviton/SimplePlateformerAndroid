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

    protected Personnage persoPrincipale;
    protected double ancienPositionX;
    protected double ancienPositionY;
    /**
     * Met à jour l'affichage du Personnage
     */
    public abstract void mettreAjourLAffichageDuPersonnagePrincipal();

    /**
     * Affiche le niveau
     * @param n le niveau à afficher
     * @param imgBloc liste des images correspondant aux blocs
     * @param peso personnage à afficher
     */
    public abstract void afficherLeNiveau(Niveau n, int[] imgBloc, Personnage peso, int[] listeImageBouton);

    /**
     * Met à jour l'affichage du temps
     * @param temps temps à afficher
     */
    public abstract void mettreAJourLAffichageDuTemps(int temps);

}
