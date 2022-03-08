package fr.iut.simpleplateformer.coucheGraphique;

import android.graphics.Bitmap;

import fr.iut.simpleplateformer.modele.metier.Entite;

public class EntiteGraphique {
    Entite entite;
    Bitmap image;

    public EntiteGraphique(Entite entite, Bitmap image) {
        this.entite = entite;
        this.image = image;
    }

    public Entite getEntite() {
        return entite;
    }

    public Bitmap getImage() {
        return image;
    }


}
