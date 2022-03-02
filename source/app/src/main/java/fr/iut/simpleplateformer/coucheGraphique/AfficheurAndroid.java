package fr.iut.simpleplateformer.coucheGraphique;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.logique.Afficheur;
import fr.iut.simpleplateformer.modele.metier.Bloc;
import fr.iut.simpleplateformer.modele.metier.HitBox;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;
import android.content.Context;

public class AfficheurAndroid extends Afficheur {

    private VueJeu vueJeu;
    private Activity activite;

    public AfficheurAndroid(Activity activite) {
        this.activite = activite;
    }

    @Override
    public void mettreAjourLAffichageDuPersonnagePrincipal() {
        activite.setContentView(vueJeu);
        ancienPositionX = persoPrincipale.getPositionX();
        ancienPositionY = persoPrincipale.getPositionY();
    }

    @Override
    public void afficherLeNiveau(Niveau n, int[] imgBloc, Personnage peso) {
        List<BlocGraphique> listeBlocsGraphiques = new ArrayList<>();
        List<Bitmap> listeBitmap = new ArrayList<>();
        for (int j : imgBloc) {
            listeBitmap.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                    activite.getApplicationContext().getResources(),
                    j), 50, 50, false));
        }
        for (Bloc bloc: n.getListeBlocs()) {
            listeBlocsGraphiques.add(new BlocGraphique(bloc,
                    activite.getApplicationContext(), listeBitmap.get(bloc.getType())
            ));
        }
        vueJeu = new VueJeu(activite.getApplicationContext(), listeBlocsGraphiques);

        activite.setContentView(vueJeu);

        persoPrincipale = peso;
    }



    @Override
    public void mettreAJourLAffichageDuTemps(int temps) {

    }

    @Override
    public void mettreAJour(){
        mettreAjourLAffichageDuPersonnagePrincipal();
    }
}
