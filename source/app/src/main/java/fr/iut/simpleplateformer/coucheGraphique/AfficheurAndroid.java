package fr.iut.simpleplateformer.coucheGraphique;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;


import androidx.drawerlayout.widget.DrawerLayout;

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
    private int decalage;
    private FrameLayout vueFenetreJeu;
    private int compteurTemps;
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
        mettreAJourLAffichageDuTemps();
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
        /*Button bouton = new Button(activite);
        bouton.setText("<");
        bouton.setOnTouchListener((view, motionEvent) -> {
            perso.setPositionX(perso.getPositionX() + 1);
            return false;
        });
        bouton.setX(0);
        bouton.setY(tailleEcran.heightPixels-200*2);
        //bouton.setBackgroundColor(Color.blue(1));
        vueFenetreJeu.addView(bouton, new FrameLayout.LayoutParams(tailleElementAffiche*4,tailleElementAffiche*4));
      //activite.getLayoutInflater().inflate(R.layout.gamepad, vueFenetreJeu);*/
        vueJeu.setFond(fond);

        compteurTemps = 0;
    }

    public void mettreEnPlaceLAffichageDesBoutons(){
        lesBoutons.get(0).setX(0);
        lesBoutons.get(1).setX(0);
        lesBoutons.get(0).setY(tailleEcran.heightPixels-tailleElementAffiche*4*3);
        lesBoutons.get(1).setY(0);
        lesBoutons.get(2).setX(tailleEcran.widthPixels-tailleElementAffiche*4);
        lesBoutons.get(3).setX(tailleEcran.widthPixels-tailleElementAffiche*4);
        lesBoutons.get(2).setY(tailleEcran.heightPixels-tailleElementAffiche*4*3);
        lesBoutons.get(3).setY(0);
        for (Button bouton: lesBoutons) {
            vueFenetreJeu.addView(bouton, new FrameLayout.LayoutParams(tailleElementAffiche*4,
                    tailleElementAffiche*4));
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
    public void mettreAJour(){
        mettreAjourLAffichageDuPersonnagePrincipal();
    }
}
