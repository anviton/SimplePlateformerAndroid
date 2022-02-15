package fr.iut.simpleplateformer.modele.logique;



import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.modele.metier.Bloc;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;

/**
 * Classe CollisionneurDeBombe permet de vérifier les collisions avec les bombes
 * @author anviton khloichet
 */
public class CollisionneurDeBombe extends Collisionneur{

    //public static Musique musique = new Musique();

    @Override
    public boolean verifCollisionAGauche(Personnage perso, Niveau niveau){
        boolean collisionBombe = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionX() - 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY()
                    && bloc.getHitBox() != null && bloc.getType() == 2) {
                collisionBombe = false;
                //musique.playSound();
                break;
            }
        }
        return collisionBombe;
    }

    @Override
    public boolean verifCollisionADroite(Personnage perso, Niveau niveau){
        boolean collisionBombe = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionX() + 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY()
                    && bloc.getHitBox() != null && bloc.getType() == 2) {
                collisionBombe = false;
                //musique.playSound();

                break;
            }
        }

        return collisionBombe;
    }

    @Override
    public boolean verifCollisionEnDessous(Personnage perso, Niveau niveau){
        boolean collisionBombe = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionY() + 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() &&
                    bloc.getHitBox() != null && bloc.getType() == 2) {
                collisionBombe = false;
                //musique.playSound();
                break;
            }
        }
        return collisionBombe;
    }

    @Override
    public List<Boolean> verifcollisionSaut(Personnage perso, Niveau niveau){
        List<Boolean> collisionsBombeSaut = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            collisionsBombeSaut.add(true);
        }
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionY() - 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null && bloc.getType() == 2) {
                collisionsBombeSaut.set(0, false);
                collisionsBombeSaut.set(1, false);
                collisionsBombeSaut.set(2, false);
                collisionsBombeSaut.set(3, false);
                //musique.playSound();
            }
            if (perso.getPositionY() - 2 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null && bloc.getType() == 2) {
                collisionsBombeSaut.set(1, false);
                collisionsBombeSaut.set(2, false);
                collisionsBombeSaut.set(3, false);
                //musique.playSound();
            }
            if (perso.getPositionY() - 3 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null && bloc.getType() == 2) {
                collisionsBombeSaut.set(2, false);
                collisionsBombeSaut.set(3, false);
                //musique.playSound();
            }
            if (perso.getPositionY() - 4 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null && bloc.getType() == 2) {
                collisionsBombeSaut.set(3, false);
                //musique.playSound();
            }
        }
        return collisionsBombeSaut;
    }
}
