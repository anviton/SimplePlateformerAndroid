package fr.iut.simpleplateformer.coucheGraphique;

import android.graphics.Bitmap;

public class Bouton {
    int x, y, h, w;
    Bitmap image;

    public Bouton(int x, int y, int h, int w, Bitmap image){
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public float getY() {
        return (float) y;
    }
}
