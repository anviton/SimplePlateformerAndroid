package fr.iut.simpleplateformer.CoucheGraphique;

import android.net.Uri;
import android.widget.ImageView;

import fr.iut.simpleplateformer.modele.metier.Bloc;

public class BlocGraphique {
    ImageView image;
    Bloc bloc;

    public BlocGraphique(Bloc bloc, String chemin) {
        this.bloc = bloc;
        image.setImageURI(Uri.parse(chemin));
    }

    public ImageView getImage() {
        return image;
    }

    public Bloc getBloc() {
        return bloc;
    }
}
