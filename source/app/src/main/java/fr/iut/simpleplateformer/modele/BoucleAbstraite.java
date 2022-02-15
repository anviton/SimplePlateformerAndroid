package fr.iut.simpleplateformer.modele;

import java.util.List;

import fr.iut.simpleplateformer.Observateur;

public abstract class BoucleAbstraite {
    private List<Observateur> listeObservateurs;

    public void notifier(){
        for(Observateur observateur : listeObservateurs){
            observateur.mettreAJour();
        }
    }

    public void ajouter(Observateur o){
        listeObservateurs.add((o));
    }
    public void retire(Observateur o){
        listeObservateurs.remove(o);
    }
}
