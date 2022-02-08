package fr.iut.simpleplateformer.controleurs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.simpleplateformer.R;

public class Jeu extends AppCompatActivity {

    private int temps;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetrejeu);
    }


    public void cliqueTestSaisieScore(View view) {
        temps = 120;
        Intent monIntent = new Intent(this, SaisieScore.class);
        monIntent.putExtra("temps", temps);
        startActivity(monIntent);
    }
    
}
