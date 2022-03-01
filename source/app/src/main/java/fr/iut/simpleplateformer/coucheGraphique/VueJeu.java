package fr.iut.simpleplateformer.coucheGraphique;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class VueJeu extends View {

    public VueJeu(Context context) {
        super(context);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(250);
        //super.onDrawForeground(canvas);
        //canvas.drawBitmap(blocGraphique.getImage().getBitmap(), blocGraphique.getBloc().getPositionX(),
                //blocGraphique.getBloc().getPositionY(), null);
        canvas.drawText("Toto", 250 ,250, paint);
    }

}
