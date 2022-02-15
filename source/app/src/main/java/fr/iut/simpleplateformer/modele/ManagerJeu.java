package fr.iut.simpleplateformer.modele;

import fr.iut.simpleplateformer.modele.logique.Afficheur;
import fr.iut.simpleplateformer.modele.logique.Deplaceur;

public class ManagerJeu {
    public BoucleAbstraite boucle;
    private Deplaceur deplaceur;
    private Afficheur afficheur;


    public ManagerJeu() {
        this.boucle = new Boucle();
    }
}
