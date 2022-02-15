package fr.iut.simpleplateformer.modele.metier;

/**
 * Classe Ennemi
 * @author anviton khloichet
 */
public class Ennemi extends Personnage {
    /**
     * Constructeur Ennemi
     * @param nom
     * @param posX
     * @param posY
     * @param collision
     */
    public Ennemi(String nom, int posX, int posY, HitBox collision) {
        super(nom, posX, posY, collision);
    }

    public String toString(){
        return "test";
    }

    public int mourir(){
        setNombreDeVies(getNombreDeVies() - 1);
        return getNombreDeVies();
    }
}
