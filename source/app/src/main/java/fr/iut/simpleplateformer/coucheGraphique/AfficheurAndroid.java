package fr.iut.simpleplateformer.coucheGraphique;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
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

    public AfficheurAndroid(Activity activite) {
        this.activite = activite;
        tailleEcran =  activite.getResources().getDisplayMetrics();
        tailleElementAffiche = (tailleEcran.heightPixels - 250) /26;
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
                listeEntiteGraphiques);
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
