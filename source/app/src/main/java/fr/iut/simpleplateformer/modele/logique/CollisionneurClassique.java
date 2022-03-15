package fr.iut.simpleplateformer.modele.logique;



import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.modele.metier.Bloc;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;

/**
 * Classe CollisionneurClassique permet de gérer les collisions avec les blocs en vérifiant les HitBox
 * @author anviton
 */
public class CollisionneurClassique extends Collisionneur{


    @Override
    public boolean verifCollisionAGauche(Personnage perso, Niveau niveau){
        boolean collision = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionX() - 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY()
                    && bloc.getHitBox() != null) {
                collision = false;
                break;
            }
        }
        return collision;
    }

    @Override
    public boolean verifCollisionADroite(Personnage perso, Niveau niveau){
        boolean collision = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionX() + 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY()
                    && bloc.getHitBox() != null) {
                collision = false;
                break;
            }
        }
        return collision;
    }

    @Override
    public boolean verifCollisionEnDessous(Personnage perso, Niveau niveau){
        boolean gravite = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionY() + 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() &&
                    bloc.getHitBox() != null) {
                gravite = false;
                break;
            }
        }
        return gravite;
    }

    @Override
    public List<Boolean> verifcollisionSaut(Personnage perso, Niveau niveau){
        List<Boolean> collisionsSaut = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            collisionsSaut.add(true);
        }
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionY() - 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null) {
                collisionsSaut.set(0, false);
                collisionsSaut.set(1, false);
                collisionsSaut.set(2, false);
                collisionsSaut.set(3, false);
            }
            if (perso.getPositionY() - 2 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null) {
                collisionsSaut.set(1, false);
                collisionsSaut.set(2, false);
                collisionsSaut.set(3, false);
            }
            if (perso.getPositionY() - 3 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null) {
                collisionsSaut.set(2, false);
                collisionsSaut.set(3, false);
            }
            if (perso.getPositionY() - 4 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null) {
                collisionsSaut.set(3, false);
            }
        }
        return collisionsSaut;
    }

}
