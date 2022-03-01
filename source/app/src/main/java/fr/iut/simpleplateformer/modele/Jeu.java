package fr.iut.simpleplateformer.modele;


import fr.iut.simpleplateformer.modele.logique.Afficheur;
import fr.iut.simpleplateformer.modele.logique.Deplaceur;
import fr.iut.simpleplateformer.modele.metier.HitBox;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Jeu permet de jouer à un niveau
 * @author anviton khloichet
 */

public class Jeu extends BoucleAbstraite implements Runnable{

    private Thread threadInterne;
    private int chrono = 0;
    private boolean jeuEnCours;
    private Deplaceur deplaceur;
    private final Niveau niveauLance;
    private Afficheur afficheur;
    private static final double TPSRAFF = 1000.0/30;

    /**
     * Constructeur de Jeu
     * @param niveauLance niveau qui devra être lancé
     */
    public Jeu(Niveau niveauLance) {
        super();
        this.niveauLance = niveauLance;
    }

    /**
     * Permet de lancer le jeu
     */
    public void lancerBoucleDeJeu(){
        threadInterne = new Thread(this);
        threadInterne.start();
    }


    /**
     * Lance la boucle de jeu
     */
    @Override
    public void run() {
        int compt = 0;
        float vitesseChute = 8f;
        float chronoIndicateur = 0;
        boolean gravite;
        Personnage perso = initialiserLeJeu();
        while (jeuEnCours){
            double positionXAvant = perso.getPositionX();
            double positionYAvant = perso.getPositionY();
            compt++;
            gravite = deplaceur.gererLaGravite(perso);
            if (gravite) {
                if(compt >= TPSRAFF/vitesseChute) {
                    perso.setPositionY(perso.getPositionY() + 1);
                    compt = 0;
                }
            }
            if (chronoIndicateur == 30){
                chrono++;
                chronoIndicateur = 0;
                afficheur.mettreAJourLAffichageDuTemps(chrono);
            }
            chronoIndicateur++;
            try {
                threadInterne.sleep((long)TPSRAFF);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            afficheur.mettreAjourLAffichageDuPersonnagePrincipal();
            jeuEnCours = verificationVictoire(perso);
        }
        //nottifier();
    }

    /**
     * Permet d'initialiser le jeu en créant le personnage et en donnant
     * à l'afficheur et au déplaceur ce qu'ils ont besoin
     * @return le personnage créé
     */
    private Personnage initialiserLeJeu(){
        List<String> listeCheminImageBloc = new ArrayList<>();
        listeCheminImageBloc.add("/blocs/bloc_vide.png");
        listeCheminImageBloc.add("/blocs/brique_base.png");
        listeCheminImageBloc.add("/blocs/bombe.png");
        listeCheminImageBloc.add("/blocs/drapeau.png");
        HitBox collision = new HitBox(50, 50);
        Personnage perso = new Personnage("Joueur", niveauLance.getPositionXDepart(),
                niveauLance.getPositionYDepart(), collision);
        //afficheur.afficherLeNiveau(niveauLance, listeCheminImageBloc, perso);
        deplaceur.setNiveau(niveauLance);
        deplaceur.deplacerPersonnagePrincipal(perso);
        jeuEnCours = true;
        return perso;
    }

    /**
     * Vérifie que la position du perso est la même que celle de l'arrivée du niveau
     * @param perso personnage dont la position doit être vérifiée
     * @return true si postion personnage ègale à celle de l'arrivée, false sinon
     */
    private boolean verificationVictoire(Personnage perso){
        return niveauLance.getPositionXArrivee() != perso.getPositionX() ||
                niveauLance.getPositionYArrivee() != perso.getPositionY();
    }

    /**
     * Getter du chrono
     * @return le chrono (temps mis pour finir le jeu)
     */
    public int getChrono() {
        return chrono;
    }
}
