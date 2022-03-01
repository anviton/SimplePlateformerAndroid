package fr.iut.simpleplateformer.coucheGraphique;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.metier.Bloc;

public class BlocGraphique {
    BitmapDrawable image;
    Bloc bloc;

    public BlocGraphique(Bloc bloc, Context contexte, int id) {
        this.bloc = bloc;
        Bitmap bitmap = BitmapFactory.decodeResource(contexte.getResources(), R.drawable.brique_base);
        image = new BitmapDrawable(contexte.getResources(), bitmap);
    }

    public BitmapDrawable getImage() {
        return image;
    }

    public Bloc getBloc() {
        return bloc;
    }
}
