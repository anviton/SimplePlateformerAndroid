package fr.iut.simpleplateformer.coucheGraphique;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.logique.Afficheur;
import fr.iut.simpleplateformer.modele.metier.Bloc;
import fr.iut.simpleplateformer.modele.metier.HitBox;
import fr.iut.simpleplateformer.modele.metier.Niveau;
import fr.iut.simpleplateformer.modele.metier.Personnage;
import android.content.Context;

public class AfficheurAndroid extends Afficheur {

    private View vue;
    private VueJeu vueJeu;
    private  Context contexte;
    private Activity activite;

    public AfficheurAndroid(View vue, Context contexte, Activity activite) {
        this.vue = vue;
        this.contexte = contexte;
        this.activite = activite;
    }

    @Override
    public void mettreAjourLAffichageDuPersonnagePrincipal() {
        ancienPositionX = persoPrincipale.getPositionX();
        ancienPositionY = persoPrincipale.getPositionY();
    }

    @Override
    public void afficherLeNiveau(Niveau n, List<String> cheminImagesBlocs, Personnage peso) {
        Canvas canvas = new Canvas();
        Bloc bloc = new Bloc(1,10,10, new HitBox(10,10));
        BlocGraphique blocGraphique = new BlocGraphique(bloc,contexte);
        //View vue = new View(contexte);
        vueJeu = new VueJeu(contexte);
        //vueJeu.onDraw(canvas, blocGraphique);
        //img.setTranslationX(10);
        //img.setTranslationY(10);
        activite.setContentView(vueJeu);

        persoPrincipale = peso;
    }



    @Override
    public void mettreAJourLAffichageDuTemps(int temps) {

    }
}
