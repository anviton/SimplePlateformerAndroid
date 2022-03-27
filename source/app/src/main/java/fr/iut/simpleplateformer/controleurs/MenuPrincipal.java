package fr.iut.simpleplateformer.controleurs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.InputStream;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.LesScores;

import fr.iut.simpleplateformer.modele.logique.ChargeurDeScores;

public class MenuPrincipal extends AppCompatActivity {
    private LesScores lesScores;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File file = getDir("score", 0);
        if (savedInstanceState != null) {
            lesScores = (LesScores) savedInstanceState.get("lesScores");
        }
        else {
            InputStream inputStream;
            try {
                inputStream = new FileInputStream(file.getAbsolutePath() + "/score.txt");
            } catch (FileNotFoundException e) {
                inputStream = getResources().openRawResource(R.raw.score);
            }
            ChargeurDeScores chargeurDeScores = new ChargeurDeScores();
            lesScores = chargeurDeScores.charger(inputStream);
        }
        setContentView(R.layout.menuprincipal);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable("lesScores", lesScores);
        super.onSaveInstanceState(outState);
    }

    public void cliqueScore(View view) {
        startActivity(passagDesScores(VoirScore.class));
    }

    public void cliqueQuitter(View view) {
        System.exit(0);
    }


    public void cliqueJouer(View view) {
        startActivity(passagDesScores(Jeu.class));
    }


    private Intent passagDesScores(Class classe){
        Intent monIntent = new Intent(this, classe);
        monIntent.putExtra("lesScores", (Parcelable) lesScores);
        return monIntent;
    }
}