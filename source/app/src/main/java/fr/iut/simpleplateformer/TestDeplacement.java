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


import java.util.Timer;
import java.util.TimerTask;

import fr.iut.simpleplateformer.modele.metier.HitBox;
import fr.iut.simpleplateformer.modele.metier.Personnage;

public class TestDeplacement extends AppCompatActivity {

    int FPS;
    int w;
    int h;
    Button jumpB;
    Button leftB;
    Button rightB;
    ImageView iv;
    int xMove;
    int yMove;
    boolean jump;
    int speed;
    Boolean isRunning = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_deplacement_layout);
        this.init();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                loop();
            }
        }, 0, 1000 / FPS);
    }

    private void init(){
        w = this.getResources().getDisplayMetrics().widthPixels;
        h = this.getResources().getDisplayMetrics().heightPixels;
        xMove = 0;
        yMove = 0;
        jump = false;
        isRunning = true;
        FPS = 60;
        speed = 10;
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
                    jump = true;
                }
                return false;
            }
        });
        leftB = (Button) findViewById(R.id.leftButton);
        leftB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    xMove = -1;
                }
                else{
                    xMove = 0;
                }
                return false;
            }
        });
        rightB = (Button) findViewById(R.id.rightButton);
        rightB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    xMove = 1;
                }
                else{
                    xMove = 0;
                }
                return false;
            }
        });
    }

    private void eventHandler() {
    }

    private void loop() {
        if (iv.getX() < w-iv.getWidth()-speed && xMove == 1){
            iv.setX(iv.getX()+(xMove*speed));
        }
        else if (iv.getX() > speed && xMove == -1){
            iv.setX(iv.getX()+(xMove*speed));
        }
        if (jump){
            if (yMove < 0){
                jump = false;
                yMove = 0;
            }
            else if (yMove == 20){
                yMove = 19;
            }
            else if (yMove%2 == 0){
                iv.setY(iv.getY()-(2*speed));
                yMove += 2;
            }
            else if (iv.getY() > h+iv.getWidth()+speed){
                jump = false;
                yMove = 0;
            }
            else {
                iv.setY(iv.getY()+(2*speed));
                yMove -= 2;
            }
        }
    }

}
