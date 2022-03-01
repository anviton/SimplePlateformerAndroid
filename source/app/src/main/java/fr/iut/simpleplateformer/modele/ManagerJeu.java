package fr.iut.simpleplateformer.modele;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

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
    private View vue;

    public ManagerJeu(Niveau niveau, View vue, Context context, Activity activite) {
        this.niveauLance = niveau;
        this.boucle = new Boucle();
        this.vue = vue;
        afficheur = new AfficheurAndroid(vue, context, activite);
    }

    public void initialiserLeJeu(){
        List<String> listeCheminImageBloc = new ArrayList<>();
        listeCheminImageBloc.add("/blocs/bloc_vide.png");
        listeCheminImageBloc.add("/blocs/brique_base.png");
        listeCheminImageBloc.add("/blocs/bombe.png");
        listeCheminImageBloc.add("/blocs/drapeau.png");
        HitBox collision = new HitBox(50, 50);
        //Personnage perso = new Personnage("Joueur", niveauLance.getPositionXDepart(),
                //niveauLance.getPositionYDepart(), collision);
        Personnage perso = new Personnage("Joueur", 10,10, collision);

        afficheur.afficherLeNiveau(niveauLance, listeCheminImageBloc, perso);
        //deplaceur.setNiveau(niveauLance);
        //deplaceur.deplacerPersonnagePrincipal(perso);

    }
}
