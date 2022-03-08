package fr.iut.simpleplateformer.modele;

public class Boucle extends BoucleAbstraite{

    private boolean jeuEnCours = true;
    private Thread threadInterne;
    private static final double TPSRAFF = 1000.0/30;


    @Override
    public void run() {
        while (jeuEnCours) {
            try {
                threadInterne.sleep((long)TPSRAFF);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifier();
        }
    }

    public void lancerBoucleDeJeu(){
        threadInterne = new Thread(this);
        threadInterne.start();
    }

    public void setJeuEnCours(boolean jeuEnCours) {
        this.jeuEnCours = jeuEnCours;
    }
}
