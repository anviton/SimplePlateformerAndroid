package fr.iut.simpleplateformer;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import fr.iut.simpleplateformer.modele.metier.HitBox;
import fr.iut.simpleplateformer.modele.metier.Personnage;

public class TestDeplacement extends AppCompatActivity {

    Button jumpB;
    Button leftB;
    Button rightB;
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_deplacement_layout);
        this.init();
    }

    private void init(){
        int w = this.getResources().getDisplayMetrics().widthPixels;
        int h = this.getResources().getDisplayMetrics().heightPixels;
        iv = (ImageView) findViewById(R.id.persoTestDeplacement);
        iv.setX(w/2);
        iv.setY(h/2);
        iv.getLayoutParams().width = 200;
        iv.getLayoutParams().height = 200;

        jumpB = (Button) findViewById(R.id.jumpButton);
        jumpB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    Path path = new Path();
                    float[] anims = {-0f + iv.getY()-300,-0f + iv.getY()};
                    ObjectAnimator animation = ObjectAnimator.ofFloat(iv, "translationY", -0f + iv.getY()-300);
                    //ObjectAnimator animation = ObjectAnimator.ofMultiFloat(iv, "translationY",anims);
                    animation.setDuration(500);
                    animation.start();
                }
                return false;
            }
        });
        leftB = (Button) findViewById(R.id.leftButton);
        leftB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    iv.setX(iv.getX() - 10);
                }
                if (event.getAction() == MotionEvent.ACTION_UP ) {
                    Log.d("inGameClicks","Left Button Released");
                }
                return false;
            }
        });
        rightB = (Button) findViewById(R.id.rightButton);
        rightB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    iv.setX(iv.getX() + 10);
                }
                if (event.getAction() == MotionEvent.ACTION_UP ) {
                    Log.d("inGameClicks","Right Button Released");
                }
                return false;
            }
        });
    }

}
