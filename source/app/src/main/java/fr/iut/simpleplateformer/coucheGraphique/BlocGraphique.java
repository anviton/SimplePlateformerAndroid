package fr.iut.simpleplateformer.coucheGraphique;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.widget.ImageView;

import fr.iut.simpleplateformer.modele.metier.Bloc;

public class BlocGraphique {
    BitmapDrawable image;
    Bloc bloc;

    public BlocGraphique(Bloc bloc, Context contexte) {
        this.bloc = bloc;
        image = new BitmapDrawable(contexte.getResources());
    }

    public BitmapDrawable getImage() {
        return image;
    }

    public Bloc getBloc() {
        return bloc;
    }
}
