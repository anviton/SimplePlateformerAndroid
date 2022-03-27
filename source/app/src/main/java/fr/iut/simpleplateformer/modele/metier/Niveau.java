package fr.iut.simpleplateformer.modele.metier;


import java.util.List;

/**
 * @author anviton khloichet
 */
public class Niveau {
    private final int positionXArrivee;
    private final int positionYArrivee;
    private final int positionXDepart;
    private final int positionYDepart;
    private int hauteurNiveau;
    private int largeurNiveau;
    private final List<Bloc> listeBlocs;


    /**
     * Constructeur Niveau
     * @param positions les postions de départ et d'arrivee du niveau
     * @param listeBlocs les bloc du niveau
     */
    public Niveau(List<Integer> positions, List<Bloc> listeBlocs) {
        this.positionXDepart = positions.get(0);
        this.positionYDepart = positions.get(1);
        this.positionXArrivee = positions.get(2);
        this.positionYArrivee = positions.get(3);
        this.listeBlocs = listeBlocs;
    }

    public List<Bloc> getListeBlocs() {
        return listeBlocs;
    }

    public int getHauteurNiveau() {
        return hauteurNiveau;
    }

    public void setHauteurNiveau(int hauteurNiveau) {
        this.hauteurNiveau = hauteurNiveau;
    }

    public int getLargeurNiveau() {
        return largeurNiveau;
    }

    public void setLargeurNiveau(int largeurNiveau) {
        this.largeurNiveau = largeurNiveau;
    }

    public int getPositionXArrivee() {
        return positionXArrivee;
    }

    public int getPositionYArrivee() {
        return positionYArrivee;
    }

    public int getPositionXDepart() {
        return positionXDepart;
    }

    public int getPositionYDepart() {
        return positionYDepart;
    }
}
