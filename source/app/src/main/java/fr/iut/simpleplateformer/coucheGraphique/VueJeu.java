package fr.iut.simpleplateformer.coucheGraphique;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;


public class VueJeu extends View {

    List<BlocGraphique> listeBlocsGraphiques;
    List<EntiteGraphique> listeEntitesGraphiques;
    List<ImageButton> listeBouton;
    Bitmap fond;
    private int DECALAGE = 300;

    public VueJeu(Context context, List<BlocGraphique> listeBlocsGraphiques,
                  List<EntiteGraphique> listeEntitesGraphiques, List<ImageButton> listeBouton) {
        super(context);
        this.listeEntitesGraphiques = listeEntitesGraphiques;
        this.listeBlocsGraphiques = listeBlocsGraphiques;
        this.listeBouton = listeBouton;
    }
    public VueJeu(Context context, List<BlocGraphique> listeBlocsGraphiques,
                  List<EntiteGraphique> listeEntitesGraphiques) {
        super(context);
        this.listeEntitesGraphiques = listeEntitesGraphiques;
        this.listeBlocsGraphiques = listeBlocsGraphiques;
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
        for (ImageButton bouton : listeBouton) {
            Drawable drawable = bouton.getDrawable();
            drawable.setBounds(500,500,500,500);
            drawable.draw(canvas);
//            canvas.drawBitmap(bitmap, bouton.getX(), bouton.getY(), paint);
        }

    }

    public void setFond(Bitmap fond) {
        this.fond = fond;
    }
}
