package fr.iut.simpleplateformer.modele;

import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.Observateur;

/**
 * Classe BoucleAbstraite
 * @author anviton flgaugirard
 */
public abstract class BoucleAbstraite implements Runnable{
    private List<Observateur> listeObservateurs = new ArrayList<>();
    protected boolean jeuEnCours = true;

    /**
     * notifie tous les observateurs qui se sont abonnés à la boucle
     */
    public void notifier(){
        for(Observateur observateur : listeObservateurs){
            observateur.mettreAJour();
        }
    }

    /**
     * démarre la boucle de jeu
     */
    public abstract void lancerBoucleDeJeu();

    /**
     * ajouter un observateur
     * @param o observateur à ajouter
     */
    public void ajouter(Observateur o){
        listeObservateurs.add((o));
    }

    /**
     * désabonner un observateur de la boucle
     * @param o observateur à supprimer
     */
    public void retirer(Observateur o){
        listeObservateurs.remove(o);
    }
    public void setJeuEnCours(boolean jeuEnCours) {
        this.jeuEnCours = jeuEnCours;
    }
}
