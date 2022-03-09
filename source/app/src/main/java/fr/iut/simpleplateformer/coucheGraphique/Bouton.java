package fr.iut.simpleplateformer.coucheGraphique;

import android.graphics.Bitmap;

public class Bouton {
    int x, y, h, w;
    Bitmap image;

    public Bouton(int x, int y, int h, int w){
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }

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

    public int getY() {
        return y;
    }

    public void setImage(Bitmap i){ this.image = i; }
}
