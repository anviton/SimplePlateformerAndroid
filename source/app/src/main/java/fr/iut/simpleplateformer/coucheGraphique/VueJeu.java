package fr.iut.simpleplateformer.coucheGraphique;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;


public class VueJeu extends View {

    List<BlocGraphique> listeBlocsGraphiques;
    List<EntiteGraphique> listeEntitesGraphiques;
    Bitmap fond;
    AfficheurAndroid afficheurAndroid;

    public VueJeu(Context context, List<BlocGraphique> listeBlocsGraphiques,
                  List<EntiteGraphique> listeEntitesGraphiques, AfficheurAndroid afficheur) {
        super(context);
        this.afficheurAndroid = afficheur;
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
            canvas.drawBitmap(bitmap, afficheurAndroid.getDecalage() + blocGraphique.getBloc().getPositionX() * afficheurAndroid.getTailleElementAffiche(),
                    blocGraphique.getBloc().getPositionY() * afficheurAndroid.getTailleElementAffiche(), paint);
        }
        for (EntiteGraphique entiteGraphique : listeEntitesGraphiques){
            Bitmap bitmap = entiteGraphique.getImage();
            canvas.drawBitmap(bitmap, afficheurAndroid.getDecalage() + entiteGraphique.getEntite().getPositionX() * afficheurAndroid.getTailleElementAffiche(),
                    entiteGraphique.getEntite().getPositionY() * afficheurAndroid.getTailleElementAffiche(), paint);
        }
        //test();
    }

    private  void test(){
        ArrayList<View> liste = new ArrayList<>();
        Button buttonSaut =  new Button(getContext());
        Button buttonSaut2 =  new Button(getContext());
        Button buttonGauche =  new Button(getContext());
        Button buttonDroit=  new Button(getContext());
    }

    public void setFond(Bitmap fond) {
        this.fond = fond;
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
    }
}

