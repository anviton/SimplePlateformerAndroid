package fr.iut.simpleplateformer.coucheGraphique;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;


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
    public static int tailleElementAffiche;
    private static int hBouton;
    private static int wBouton;

    public AfficheurAndroid(Activity activite) {
        this.activite = activite;
        tailleEcran =  activite.getResources().getDisplayMetrics();
        wBouton = 50;
        hBouton = tailleEcran.widthPixels / 3;
        tailleEcran.heightPixels -= hBouton;
        tailleElementAffiche = (tailleEcran.heightPixels - 250) /26;
    }

    @Override
    public void mettreAjourLAffichageDuPersonnagePrincipal() {
        vueJeu.postInvalidate();
    }

    @Override
    public void afficherLeNiveau(Niveau n, int[] imgBloc, Personnage perso, int[] listeImageBouton) {
        List<BlocGraphique> listeBlocsGraphiques = new ArrayList<>();
        List<EntiteGraphique> listeEntiteGraphiques = new ArrayList<>();
        List<Bitmap> listeBitmap = new ArrayList<>();
        List<ImageButton> listeBouton = new ArrayList<>();
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
        for (int image : listeImageBouton) {
            ImageButton bouton = new ImageButton(activite.getApplicationContext());
            bouton.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                    activite.getApplicationContext().getResources(),
                    image), tailleElementAffiche, tailleElementAffiche, false));
            listeBouton.add(bouton);

        }
//        vueJeu = new VueJeu(activite.getApplicationContext(), listeBlocsGraphiques,
//                listeEntiteGraphiques);
        vueJeu = new VueJeu(activite.getApplicationContext(), listeBlocsGraphiques,
                listeEntiteGraphiques, listeBouton);
        Bitmap fond = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(activite.getResources(),
                R.drawable.fond_niv),tailleEcran.widthPixels,tailleEcran.heightPixels, false);
        activite.setContentView(vueJeu);
        vueJeu.setFond(fond);
        //Log.d("Taille view", String.valueOf(activite.getResources().getDisplayMetrics().widthPixels));
    }



    @Override
    public void mettreAJourLAffichageDuTemps(int temps) {

    }

    @Override
    public void mettreAJour(){
        mettreAjourLAffichageDuPersonnagePrincipal();
    }
}
