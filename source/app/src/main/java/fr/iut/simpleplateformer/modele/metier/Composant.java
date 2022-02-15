package fr.iut.simpleplateformer.modele.metier;

/**
 * Classe abstraite Compoasant
 */
public abstract class Composant {
    private int positionY;
    private int positionX;
    private final HitBox hitBox;

    /**
     * Constructeur composant
     * @param positionX
     * @param positionY
     * @param hitBox
     */
    public Composant(int positionX, int positionY, HitBox hitBox) {
        this.positionY = positionY;
        this.positionX = positionX;
        this.hitBox = hitBox;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

}
