package fr.iut.simpleplateformer.coucheGraphique;

import android.graphics.Bitmap;

import fr.iut.simpleplateformer.modele.metier.Bloc;

public class BlocGraphique {
    Bitmap image;
    Bloc bloc;

    public BlocGraphique(Bloc bloc, Bitmap bitmap) {
        this.bloc = bloc;
        image = bitmap;
    }

    public Bitmap getImage() {
        return image;
    }

    public Bloc getBloc() {
        return bloc;
    }
}
