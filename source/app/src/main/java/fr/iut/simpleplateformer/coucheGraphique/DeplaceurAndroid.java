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

/**
 * DeplaceurAndroid permet de gérer le déplacement d'un personnage
 * @author anviton flgaugirard
 */
public class DeplaceurAndroid extends Deplaceur {
    private final List<Collisionneur> collisionneurs;
    private int compt;
    private boolean saut;

    public DeplaceurAndroid(ManagerJeu managerJeu) {
        this.collisionneurs = new ArrayList<>();
        this.collisionneurs.add(new CollisionneurClassique());
        this.collisionneurs.add(new CollisionneurDeBombe());
        this.managerJeu = managerJeu;
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
            float vitesseChute = 8f;
            if(compt >= Boucle.TPSRAFF / vitesseChute) {
                perso.setPositionY(perso.getPositionY() + 1);
                compt = 0;
            }
        }
    }

    @Override
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

    @Override
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

    @Override
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
