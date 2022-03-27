package fr.iut.simpleplateformer.modele.logique;


import fr.iut.simpleplateformer.Observateur;
import fr.iut.simpleplateformer.ManagerJeu;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;

/**
 * Classe Déplaceur sert à déplacer le personnage
 */
public abstract class Deplaceur extends Observateur {
    protected Niveau niveau;
    protected ManagerJeu managerJeu;

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    /**
     * Applique la gravité sur un personnage
     * @param perso personnage auquel la gravité doit être applliqué
     */
    public abstract void gererLaGravite(Personnage perso);

    /**
     * sauter gère le saut d'un personnage
     * @param perso personnage a regarder pour sauter
     */
    public abstract void sauter(Personnage perso);

    /**
     * seDeplacerAGauche gère le déplacement du perso a gauche
     * @param perso personnage a regarder pour le déplacer a gauche
     */
    public abstract void seDeplacerAGauche(Personnage perso);

    /**
     * seDeplacerADroite gère le déplacement du perso a droite
     * @param perso personnage a regarder pour le déplacer a droite
     */
    public abstract void seDeplacerADroite(Personnage perso);

    @Override
    public void mettreAJour() {
        gererLaGravite(managerJeu.getPersonnagePrincipal());
    }
}
