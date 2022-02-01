package fr.iut.simpleplateformer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Jeu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetrejeu);
    }


    public void cliqueTestSaisieScore(View view) {
        Intent monIntent = new Intent(this, SaisieScore.class);
        startActivity(monIntent);
    }
    
}
