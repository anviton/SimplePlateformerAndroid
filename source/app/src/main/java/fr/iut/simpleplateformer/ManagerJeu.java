package fr.iut.simpleplateformer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.Observateur;
import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.activites.SaisieScore;
import fr.iut.simpleplateformer.coucheGraphique.DeplaceurAndroid;
import fr.iut.simpleplateformer.modele.Boucle;
import fr.iut.simpleplateformer.modele.LesScores;
import fr.iut.simpleplateformer.modele.logique.Afficheur;
import fr.iut.simpleplateformer.coucheGraphique.AfficheurAndroid;

import fr.iut.simpleplateformer.modele.logique.Deplaceur;
import fr.iut.simpleplateformer.modele.metier.HitBox;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;

/**
 * Classe ManagerJeu permet de gérer le déroulement d'un niveau
 * @author anviton flgaugirard
 */
public class ManagerJeu extends Observateur {
    private Deplaceur deplaceur;
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
        miseEnPlaceDesDeplacments();
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
    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
    private void miseEnPlaceDesDeplacments(){
        this.deplaceur = new DeplaceurAndroid(this);
        this.deplaceur.setNiveau(niveauLance);
        List<Button> lesBoutons =  new ArrayList<>();
        for (int i=0; i < 4; i++) {
            lesBoutons.add(new Button(activite));
        }
        //lesBoutons.get(0).setText("<");
        lesBoutons.get(0).setBackground(activite.getResources().getDrawable(R.drawable.left_button));
        lesBoutons.get(0).setOnClickListener(view -> deplaceur.seDeplacerAGauche(personnagePrincipal));
        //lesBoutons.get(1).setText("^");
        lesBoutons.get(1).setBackground(activite.getResources().getDrawable(R.drawable.jump_button));
        lesBoutons.get(1).setOnClickListener(view -> deplaceur.sauter(personnagePrincipal));
        //lesBoutons.get(2).setText(">");
        lesBoutons.get(2).setBackground(activite.getResources().getDrawable(R.drawable.right_button));
        lesBoutons.get(2).setOnClickListener(view -> deplaceur.seDeplacerADroite(personnagePrincipal));
        //lesBoutons.get(3).setText("^");
        lesBoutons.get(3).setBackground(activite.getResources().getDrawable(R.drawable.jump_button));
        lesBoutons.get(3).setOnClickListener(view -> deplaceur.sauter(personnagePrincipal));
        this.afficheur = new AfficheurAndroid(activite, lesBoutons);
    }

    /**
     * Vérifie que la position du perso est la même que celle de l'arrivée du niveau
     * @return true si postion personnage ègale à celle de l'arrivée, false sinon
     */
    private boolean verificationVictoire(){
        return niveauLance.getPositionXArrivee() == personnagePrincipal.getPositionX() &&
                niveauLance.getPositionYArrivee() == personnagePrincipal.getPositionY();
    }

    /**
     * Met à jour le manager en vérifiant la position du personnage principal
     */
    @Override
    public void mettreAJour() {
        if(verificationVictoire()){
            boucle.setJeuEnCours(false);
            Intent monIntent = new Intent(activite, SaisieScore.class);
            monIntent.putExtra("temps", afficheur.recupererLeTemps());
            monIntent.putExtra("lesScores", lesScores);
            activite.startActivity(monIntent);
        }
    }
}
