package fr.iut.simpleplateformer.coucheGraphique;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

import java.util.List;


public class VueJeu extends View {

    List<BlocGraphique> listeBlocsGraphiques;
    List<EntiteGraphique> listeEntitesGraphiques;
    List<Bouton> listeBouton;
    Bitmap fond;
    private int DECALAGE = 300;

    public VueJeu(Context context, List<BlocGraphique> listeBlocsGraphiques,
                  List<EntiteGraphique> listeEntitesGraphiques,List<Bouton> listeBouton) {
        super(context);
        this.listeEntitesGraphiques = listeEntitesGraphiques;
        this.listeBlocsGraphiques = listeBlocsGraphiques;
        this.listeBouton = listeBouton;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(250);
        canvas.drawBitmap(fond, 0, 0, paint);
        for (BlocGraphique blocGraphique : listeBlocsGraphiques) {
            Bitmap bitmap = blocGraphique.getImage();
            canvas.drawBitmap(bitmap, DECALAGE + blocGraphique.getBloc().getPositionX() * AfficheurAndroid.tailleElementAffiche,
                    blocGraphique.getBloc().getPositionY() * AfficheurAndroid.tailleElementAffiche, paint);
        }
        for (EntiteGraphique entiteGraphique : listeEntitesGraphiques){
            Bitmap bitmap = entiteGraphique.getImage();
            canvas.drawBitmap(bitmap, DECALAGE + entiteGraphique.getEntite().getPositionX() * AfficheurAndroid.tailleElementAffiche,
                    entiteGraphique.getEntite().getPositionY() * AfficheurAndroid.tailleElementAffiche, paint);
        }
        int i = 0;
        for (Bouton bouton : listeBouton) {
            Bitmap bitmap = bouton.getImage();
            canvas.drawBitmap(bitmap, bouton.getX(), bouton.getY(), paint);
        }

    }

    public void setFond(Bitmap fond) {
        this.fond = fond;
    }
}
