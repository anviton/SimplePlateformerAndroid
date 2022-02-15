package fr.iut.simpleplateformer.modele.logique;



import java.util.List;

import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;

/**
 * Classe abstraite Collisionneur permet de gérer la logique des collisions
 * @author anviton khloichet
 */
public abstract class Collisionneur {

    /**
     * Vérifie les collisions entre le personnage et le niveau à la gauche du personnage
     * @param perso personnage dont les collisions doivent être vérifiées
     * @param niveau niveau dont les collisions doivent être vérifiées
     * @return true s'il y a collision, false sinon
     */
    public abstract boolean verifCollisionAGauche(Personnage perso, Niveau niveau);

    /**
     * Vérifie les collisions entre le personnage et le niveau à la droite du personnage
     * @param perso personnage dont les collisions doivent être vérifiées
     * @param niveau niveau dont les collisions doivent être vérifiées
     * @return true s'il y a collision, false sinon
     */
    public abstract boolean verifCollisionADroite(Personnage perso, Niveau niveau);

    /**
     * Vérifie les collisions entre le personnage et le niveau en dessous du personnage
     * @param perso personnage dont les collisions doivent être vérifiées
     * @param niveau niveau dont les collisions doivent être vérifiées
     * @return true s'il y a collision, false sinon
     */
    public abstract boolean verifCollisionEnDessous(Personnage perso, Niveau niveau);

    /**
     * Vérifie les collisions entre le personnage et le niveau, au dessus du personnage
     * @param perso personnage dont les collisions doivent être vérifiées
     * @param niveau niveau dont les collisions doivent être vérifiées
     * @return une liste de Boolean composée de 4 Boolean pour signifier s'il y a collision sur les 4 blocs
     * au dessus du personnage, cahque Boolean est mis à true s'il y a collision, à false sinon
     */
    public abstract List<Boolean> verifcollisionSaut(Personnage perso, Niveau niveau);
}
