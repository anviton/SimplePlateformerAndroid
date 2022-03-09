package fr.iut.simpleplateformer.modele;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.logique.Afficheur;
import fr.iut.simpleplateformer.coucheGraphique.AfficheurAndroid;
import fr.iut.simpleplateformer.modele.logique.Deplaceur;
import fr.iut.simpleplateformer.modele.metier.HitBox;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;

public class ManagerJeu {
    public BoucleAbstraite boucle;
    private Deplaceur deplaceur;
    private Afficheur afficheur;
    private Niveau niveauLance;


    public ManagerJeu(Niveau niveau, Activity activite) {
        this.niveauLance = niveau;
        this.boucle = new Boucle();
        this.afficheur = new AfficheurAndroid(activite);
    }

    public void initialiserLeJeu(){
        int[] listeCheminImageBloc = new int[4];
        int[] listeCheminImageBouton = new int[3];
        listeCheminImageBloc[0] = R.drawable.bloc_vide;
        listeCheminImageBloc[1] = R.drawable.brique_base;
        listeCheminImageBloc[2] =  R.drawable.bombe;
        listeCheminImageBloc[3] = R.drawable.drapeau;

        listeCheminImageBouton[1] = R.drawable.jump_button;
        listeCheminImageBouton[0] = R.drawable.left_button;
        listeCheminImageBouton[2] =  R.drawable.right_button;


        HitBox collision = new HitBox(50, 50);
        Personnage perso = new Personnage("Joueur", niveauLance.getPositionXDepart(),
                niveauLance.getPositionYDepart(), collision);

        afficheur.afficherLeNiveau(niveauLance, listeCheminImageBloc, perso, listeCheminImageBouton);
        //deplaceur.setNiveau(niveauLance);
        //deplaceur.deplacerPersonnagePrincipal(perso);
    }

    public void lancerLeJeu(){
        boucle.ajouter(afficheur);
        boucle.lancerBoucleDeJeu();
    }
}
