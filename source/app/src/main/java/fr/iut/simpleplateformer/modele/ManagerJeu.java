package fr.iut.simpleplateformer.modele;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.Observateur;
import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.TestDeplacement;
import fr.iut.simpleplateformer.controleurs.SaisieScore;
import fr.iut.simpleplateformer.controleurs.VoirScore;
import fr.iut.simpleplateformer.coucheGraphique.DeplaceurAndroid;
import fr.iut.simpleplateformer.modele.logique.Afficheur;
import fr.iut.simpleplateformer.coucheGraphique.AfficheurAndroid;
import fr.iut.simpleplateformer.modele.logique.Deplaceur;
import fr.iut.simpleplateformer.modele.metier.HitBox;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;

public class ManagerJeu extends Observateur {
    public BoucleAbstraite boucle;
    private DeplaceurAndroid deplaceur;
    private Personnage personnagePrincipal;
    private Afficheur afficheur;
    private Niveau niveauLance;
    private Activity activite;
    private LesScores lesScores;


    public ManagerJeu(Niveau niveau, Activity activite, LesScores lesScores) {
        this.niveauLance = niveau;
        this.boucle = new Boucle();
        this.activite = activite;
        this.lesScores = lesScores;
    }


    public Personnage getPersonnagePrincipal() {
        return personnagePrincipal;
    }

    /**
     * Permet d'initialiser le jeu en créant le personnage et en donnant
     * à l'afficheur et au déplaceur ce qu'ils ont besoin
     */
    public void initialiserLeJeu(){
        int[] listeCheminImageBloc = new int[4];
        miseEnPlaceDesDEplacments();
        listeCheminImageBloc[0] = R.drawable.bloc_vide;
        listeCheminImageBloc[1] = R.drawable.brique_base;
        listeCheminImageBloc[2] =  R.drawable.bombe;
        listeCheminImageBloc[3] = R.drawable.drapeau;

        HitBox collision = new HitBox(50, 50);
         personnagePrincipal = new Personnage("Joueur", niveauLance.getPositionXDepart(),
                niveauLance.getPositionYDepart(), collision);

        afficheur.afficherLeNiveau(niveauLance, listeCheminImageBloc, personnagePrincipal);
    }

    /**
     * Abonne les observateurs à la boucle de jeu
     * Démarre la boucle de jeu
     */
    public void lancerLeJeu(){
        boucle.ajouter(afficheur);
        boucle.ajouter(deplaceur);
        boucle.ajouter(this);
        boucle.lancerBoucleDeJeu();
    }

    /**
     * Création des boutons et mise en place de leur action
     */
    @SuppressLint("ClickableViewAccessibility")
    private void miseEnPlaceDesDEplacments(){
        this.deplaceur = new DeplaceurAndroid(this);
        this.deplaceur.setNiveau(niveauLance);
        List<Button> lesBoutons =  new ArrayList<>();
        for (int i=0; i < 4; i++) {
            lesBoutons.add(new Button(activite));
        }
        lesBoutons.get(0).setText("<");
        lesBoutons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deplaceur.seDeplacerAGauche(personnagePrincipal);
            }
        });
        lesBoutons.get(1).setText("^");
        lesBoutons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deplaceur.sauter(personnagePrincipal);
            }
        });
        lesBoutons.get(2).setText(">");
        lesBoutons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deplaceur.seDeplacerADroite(personnagePrincipal);
            }
        });
        lesBoutons.get(3).setText("^");
        lesBoutons.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deplaceur.sauter(personnagePrincipal);
            }
        });
        this.afficheur = new AfficheurAndroid(activite, lesBoutons);
    }

    /**
     * Vérifie que la position du perso est la même que celle de l'arrivée du niveau
     * @param perso personnage dont la position doit être vérifiée
     * @return true si postion personnage ègale à celle de l'arrivée, false sinon
     */
    private boolean verificationVictoire(Personnage perso){
        return niveauLance.getPositionXArrivee() == perso.getPositionX() &&
                niveauLance.getPositionYArrivee() == perso.getPositionY();
    }

    /**
     * Met à jour le manager en vérifiant la position du personnage principal
     */
    @Override
    public void mettreAJour() {
        if(verificationVictoire(personnagePrincipal)){
            boucle.setJeuEnCours(false);
            Intent monIntent = new Intent(activite, SaisieScore.class);
            monIntent.putExtra("temps", afficheur.recupererLeTemps());
            monIntent.putExtra("lesScores", lesScores);
            activite.startActivity(monIntent);
        }
    }
}
