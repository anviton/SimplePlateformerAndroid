package fr.iut.simpleplateformer.modele.metier;

/**
 * Classe Bloc
 * @author anviton khloichet
 */
public class Bloc extends Composant {

    private final int type;

    /**
     * constructeur de Bloc
     * @param type
     * @param positionX
     * @param positionY
     * @param hitBox
     */
    public Bloc(int type, int positionX, int positionY, HitBox hitBox) {
        super(positionX, positionY, hitBox);
        this.type = type;
    }

    public int getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Bloc{" +
                "type=" + type +
                ", positionY=" + this.getPositionY() +
                ", positionX=" + this.getPositionX() +
                ", hitBox=" + this.getHitBox() +
                '}';
    }
}
