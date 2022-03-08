package fr.iut.simpleplateformer.coucheGraphique;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.List;


public class VueJeu extends View {

    List<BlocGraphique> listeBlocsGraphiques;
    List<EntiteGraphique> listeEntitesGraphiques;
    Bitmap fond;
    private int DECALAGE = 300;

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
    }

    public void setFond(Bitmap fond) {
        this.fond = fond;
    }
}
