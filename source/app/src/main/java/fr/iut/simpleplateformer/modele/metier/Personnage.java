package fr.iut.simpleplateformer.modele.metier;

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

    public int mourir(){
        setNombreDeVies(this.nombreDeVies - 1);
        return nombreDeVies;
    }

}
