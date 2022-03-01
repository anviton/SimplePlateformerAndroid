package fr.iut.simpleplateformer.coucheGraphique;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

import java.util.List;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.metier.Bloc;
import fr.iut.simpleplateformer.modele.metier.HitBox;

public class VueJeu extends View {

    List<BlocGraphique> listeBlocsGraphiques;
    public VueJeu(Context context, List<BlocGraphique> listeBlocsGraphiques) {
        super(context);
        this.listeBlocsGraphiques = listeBlocsGraphiques;
    }

    @Override
    public void onDrawForeground(Canvas canvas) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(250);
        for (BlocGraphique blocGraphique: listeBlocsGraphiques) {
            Bitmap bitmap = blocGraphique.getImage().getBitmap();
            canvas.drawBitmap(bitmap, blocGraphique.getBloc().getPositionX(),
                    blocGraphique.getBloc().getPositionY(), paint);
        }
        canvas.drawText("Toto", 250 ,250, paint);
    }
}
