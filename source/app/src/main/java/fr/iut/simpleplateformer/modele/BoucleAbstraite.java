package fr.iut.simpleplateformer.modele;

import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.Observateur;

public abstract class BoucleAbstraite implements Runnable{
    private List<Observateur> listeObservateurs = new ArrayList<>();
    protected boolean jeuEnCours = true;


    public void notifier(){
        for(Observateur observateur : listeObservateurs){
            observateur.mettreAJour();
        }
    }
    public abstract void lancerBoucleDeJeu();
    public void ajouter(Observateur o){
        listeObservateurs.add((o));
    }
    public void retirer(Observateur o){
        listeObservateurs.remove(o);
    }
    public void setJeuEnCours(boolean jeuEnCours) {
        this.jeuEnCours = jeuEnCours;
    }
}
