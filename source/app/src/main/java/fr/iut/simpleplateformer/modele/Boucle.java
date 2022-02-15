package fr.iut.simpleplateformer.modele;

public class Boucle extends BoucleAbstraite implements Runnable {

    private boolean jeuEnCours;
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

    public void setJeuEnCours(boolean jeuEnCours) {
        this.jeuEnCours = jeuEnCours;
    }
}
