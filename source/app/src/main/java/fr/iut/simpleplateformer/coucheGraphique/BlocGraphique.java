package fr.iut.simpleplateformer.coucheGraphique;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.widget.ImageView;

import fr.iut.simpleplateformer.modele.metier.Bloc;

public class BlocGraphique {
    Bitmap image;
    Bloc bloc;

    public BlocGraphique(Bloc bloc, Context contexte,  Bitmap bitmap) {
        this.bloc = bloc;
        /*Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(contexte.getResources(),
                id), 50,50, false);
        image = new BitmapDrawable(contexte.getResources(), bitmap);*/
        image = bitmap;
    }

    public Bitmap getImage() {
        return image;
    }

    public Bloc getBloc() {
        return bloc;
    }
}
