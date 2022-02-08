package fr.iut.simpleplateformer.controleurs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.simpleplateformer.R;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuprincipal);
    }

    public void cliqueScore(View view) {
        Intent monIntent = new Intent(this, VoirScore.class);
        startActivity(monIntent);
    }

    public void cliqueQuitter(View view) {
        this.finish();
    }


    public void cliqueJouer(View view) {
        Intent monIntent = new Intent(this, Jeu.class);
        startActivity(monIntent);
    }
}