package fr.iut.simpleplateformer.modele;

import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.Observateur;

public abstract class BoucleAbstraite implements Runnable{
    private List<Observateur> listeObservateurs = new ArrayList<>();
    //public int i;

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
