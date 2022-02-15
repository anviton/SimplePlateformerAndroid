package fr.iut.simpleplateformer.modele.logique;


import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;

public abstract class Deplaceur {
    protected Niveau niveau;

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    /**
     * Deplace le personnage principal
     * @param perso personnage à déplacer
     */
    public abstract void deplacerPersonnagePrincipal(Personnage perso);

    /**
     * Applique la gravité sur un personnage
     * @param perso personnage sur lequel il faut g
     * @return true si le personnage est sur un bloc, false sinon
     */
    public abstract boolean gererLaGravite(Personnage perso);
}
