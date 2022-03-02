package fr.iut.simpleplateformer.coucheGraphique;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.List;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.metier.Bloc;
import fr.iut.simpleplateformer.modele.metier.HitBox;

public class VueJeu extends View {

    List<BlocGraphique> listeBlocsGraphiques;
    int i;
    public VueJeu(Context context, List<BlocGraphique> listeBlocsGraphiques) {
        super(context);
        i=0;
        this.listeBlocsGraphiques = listeBlocsGraphiques;
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(250);
        if(i==0) {
            for (BlocGraphique blocGraphique : listeBlocsGraphiques) {
                Bitmap bitmap = blocGraphique.getImage();
                canvas.drawBitmap(bitmap, blocGraphique.getBloc().getPositionX() * 50,
                        blocGraphique.getBloc().getPositionY() * 50, paint);
            }
        }
        canvas.drawText(String.valueOf(i), 250 ,250, paint);
        i++;
    }

}
