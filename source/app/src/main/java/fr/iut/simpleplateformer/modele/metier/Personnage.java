package fr.iut.simpleplateformer.modele.metier;

/**
 * Classe Personnage stocke les informations d'un personnage
 * @author anviton, khloichet
 */
public class Personnage extends Entite {
    private final String nom;
    private int nombreDeVies;

    public Personnage(String nom, int posX, int posY, HitBox hitbox) {
        super(posX, posY, hitbox);
        this.nom=nom;
        this.nombreDeVies = 3;
    }

    public String getNom() { return nom; }

    public int getNombreDeVies() {
        return nombreDeVies;
    }

    public void setNombreDeVies(int nombreDeVies) {
        this.nombreDeVies = nombreDeVies;
    }


    @Override
    public String toString() {
        StringBuilder message;
        message = new StringBuilder("Personnage{" + super.toString() +
                ", nom=" + nom +
                ", nombre de vies=" + nombreDeVies);
        return message.toString();
    }

    /**
     * décrémente le nombre de vie et retourne le nombre de vies restantes
     * @return
     */
    public int mourir(){
        setNombreDeVies(this.nombreDeVies - 1);
        return nombreDeVies;
    }

}
