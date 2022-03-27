package fr.iut.simpleplateformer.coucheGraphique;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.logique.Afficheur;
import fr.iut.simpleplateformer.modele.metier.Bloc;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;


public class AfficheurAndroid extends Afficheur {

    private VueJeu vueJeu;
    private Activity activite;
    private DisplayMetrics tailleEcran;
    private int tailleElementAffiche;
    private final int decalage;
    private FrameLayout vueFenetreJeu;
    private int compteurTemps;
    private static final int MULTIPLICATEURBOUTON = 7;
    private List<Button> lesBoutons;

    public AfficheurAndroid(Activity activite, List<Button> lesBoutons) {
        this.activite = activite;
        tailleEcran =  activite.getResources().getDisplayMetrics();
        tailleElementAffiche = (tailleEcran.heightPixels - 250) /26;
        decalage = (tailleEcran.widthPixels - tailleElementAffiche*38) / 2;
        this.lesBoutons = lesBoutons;
    }


    public int getTailleElementAffiche() {
        return tailleElementAffiche;
    }

    public int getDecalage() {
        return decalage;
    }

    @Override
    public void mettreAjourLAffichageDuPersonnagePrincipal() {
        vueJeu.postInvalidate();
    }

    @Override
    public void afficherLeNiveau(Niveau n, int[] imgBloc, Personnage perso) {
        List<BlocGraphique> listeBlocsGraphiques = new ArrayList<>();
        List<EntiteGraphique> listeEntiteGraphiques = new ArrayList<>();
        List<Bitmap> listeBitmap = new ArrayList<>();
        vueFenetreJeu = new FrameLayout(activite);
        for (int image : imgBloc) {
            listeBitmap.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                    activite.getApplicationContext().getResources(),
                    image), tailleElementAffiche, tailleElementAffiche, false));
        }
        for (Bloc bloc: n.getListeBlocs()) {
            listeBlocsGraphiques.add(new BlocGraphique(bloc, listeBitmap.get(bloc.getType())
            ));
        }
        listeEntiteGraphiques.add(new EntiteGraphique(perso, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(activite.getApplicationContext().getResources(),
                        R.drawable.personnage), tailleElementAffiche, tailleElementAffiche, false)));
        vueJeu = new VueJeu(activite.getApplicationContext(), listeBlocsGraphiques,
                listeEntiteGraphiques, this);
        Bitmap fond = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(activite.getResources(),
                R.drawable.fond_niv),tailleEcran.widthPixels,tailleEcran.heightPixels, false);
        vueFenetreJeu.addView(vueJeu);
        activite.setContentView(vueFenetreJeu);
        mettreEnPlaceLAffichageDesBoutons();
        vueJeu.setFond(fond);

        compteurTemps = 0;
    }

    private void mettreEnPlaceLAffichageDesBoutons(){
        lesBoutons.get(0).setX(0);
        lesBoutons.get(1).setX(0);
        lesBoutons.get(0).setY(tailleEcran.heightPixels-tailleElementAffiche*MULTIPLICATEURBOUTON*2);
        lesBoutons.get(1).setY(0);
        lesBoutons.get(2).setX(tailleEcran.widthPixels-tailleElementAffiche*MULTIPLICATEURBOUTON);
        lesBoutons.get(3).setX(tailleEcran.widthPixels-tailleElementAffiche*MULTIPLICATEURBOUTON);
        lesBoutons.get(2).setY(tailleEcran.heightPixels-tailleElementAffiche*MULTIPLICATEURBOUTON*2);
        lesBoutons.get(3).setY(0);
        for (Button bouton: lesBoutons) {
            vueFenetreJeu.addView(bouton, new FrameLayout.LayoutParams(
                    tailleElementAffiche*MULTIPLICATEURBOUTON,
                    tailleElementAffiche*MULTIPLICATEURBOUTON));
        }
    }



    @Override
    public void mettreAJourLAffichageDuTemps() {
        if (compteurTemps == 30){
            vueJeu.augmenterTemps();
            compteurTemps = 0;
        }
        compteurTemps++;
    }

    @Override
    public int recupererLeTemps() {
        return vueJeu.getTemps();
    }

    /**
     * Appelle la mise à jour de l'affichage du temps et du perso
     */
    @Override
    public void mettreAJour(){
        mettreAjourLAffichageDuPersonnagePrincipal();
        mettreAJourLAffichageDuTemps();
    }
}
