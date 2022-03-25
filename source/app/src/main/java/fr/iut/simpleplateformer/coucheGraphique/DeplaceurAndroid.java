package fr.iut.simpleplateformer.coucheGraphique;

import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.modele.Boucle;
import fr.iut.simpleplateformer.modele.ManagerJeu;
import fr.iut.simpleplateformer.modele.logique.Collisionneur;
import fr.iut.simpleplateformer.modele.logique.CollisionneurClassique;
import fr.iut.simpleplateformer.modele.logique.CollisionneurDeBombe;
import fr.iut.simpleplateformer.modele.logique.Deplaceur;
import fr.iut.simpleplateformer.modele.metier.Personnage;

public class DeplaceurAndroid extends Deplaceur {
    private final List<Collisionneur> collisionneurs;
    private float vitesseChute = 8f;
    private int compt;
    private boolean saut;

    public DeplaceurAndroid(ManagerJeu managerJeu) {
        this.collisionneurs = new ArrayList<>();
        this.collisionneurs.add(new CollisionneurClassique());
        this.collisionneurs.add(new CollisionneurDeBombe());
        this.managerJeu = managerJeu;
    }

    @Override
    public void deplacerPersonnagePrincipal(Personnage perso) {

    }

    @Override
    public void gererLaGravite(Personnage perso) {
        List<Boolean>collisions = new ArrayList<>();
        compt++;
        for(Collisionneur collisionneur : collisionneurs){
            collisions.add(collisionneur.verifCollisionEnDessous(perso, niveau));
        }
        if (collisions.get(1)){
            if (!collisions.get(0)){
                saut = true;
            }
        }
        else {
            perso.setPositionX(niveau.getPositionXDepart());
            perso.setPositionY(niveau.getPositionYDepart());
        }
        if (collisions.get(0)) {
            if(compt >= Boucle.TPSRAFF /vitesseChute) {
                perso.setPositionY(perso.getPositionY() + 1);
                compt = 0;
            }
        }
    }

    /**
     * sauter gère le saut d'un personnage
     * @param perso personnage a regarder pour sauter
     */
    public void sauter(Personnage perso){
        List<Boolean> collisionsSaut = collisionneurs.get(0).verifcollisionSaut(perso, niveau);
        int tailleSaut = 0;
        for (int i = 0; i < 4; i++) {
            if (collisionsSaut.get(i)){
                tailleSaut++;
            }
        }
        if (saut) {
            perso.setPositionY(perso.getPositionY() - tailleSaut);
            saut = false;
        }
    }


    /**
     * seDeplacerAGauche gère le déplacement du perso a gauche
     * @param perso personnage a regarder pour le déplacer a gauche
     */
    public void seDeplacerAGauche(Personnage perso){
        List<Boolean>collisions = new ArrayList<>();
        for(Collisionneur collisionneur : collisionneurs){
            collisions.add(collisionneur.verifCollisionAGauche(perso, niveau));
        }
        if(collisions.get(1)){
            if(collisions.get(0)){
                perso.setPositionX(perso.getPositionX() - 1);
            }
        }
        else {
            perso.setPositionX(niveau.getPositionXDepart());
            perso.setPositionY(niveau.getPositionYDepart());
        }
    }

    /**
     * seDeplacerADroite gère le déplacement du perso a droite
     * @param perso personnage a regarder pour le déplacer a droite
     */

    public void seDeplacerADroite(Personnage perso){
        List<Boolean>collisions = new ArrayList<>();
        for(Collisionneur collisionneur : collisionneurs){
            collisions.add(collisionneur.verifCollisionADroite(perso, niveau));
        }
        if(collisions.get(1)){
            if(collisions.get(0)){
                perso.setPositionX(perso.getPositionX() + 1);
            }
        }
        else {
            perso.setPositionX(niveau.getPositionXDepart());
            perso.setPositionY(niveau.getPositionYDepart());
        }
    }
}
