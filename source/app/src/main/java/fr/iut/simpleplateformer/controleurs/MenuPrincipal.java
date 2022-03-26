package fr.iut.simpleplateformer.controleurs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.TestDeplacement;
import fr.iut.simpleplateformer.modele.LesScores;
import fr.iut.simpleplateformer.modele.Score;
import fr.iut.simpleplateformer.modele.logique.ChargeurDeScores;
import fr.iut.simpleplateformer.modele.logique.SauveurDeScores;

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
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file.getAbsolutePath() + "/score.txt");
            } catch (FileNotFoundException e) {
                inputStream = getResources().openRawResource(R.raw.score);
            }
            ChargeurDeScores chargeurDeScores = new ChargeurDeScores();
            lesScores = chargeurDeScores.charger(inputStream);
        }
        setContentView(R.layout.menuprincipal);

        /// la sauvegarde des scores doit être déplacée, elle doit être faite après
        // la saisie d'un nouveau score
        SauveurDeScores sauveurDeScores = new SauveurDeScores();
        try {
            sauveurDeScores.sauver(lesScores, new FileOutputStream(file.getAbsolutePath() + "/score.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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

    public void cliqueBoutonTest(View view){
        Intent monIntent = new Intent(this, TestDeplacement.class);
        startActivity(monIntent);
    }

    private Intent passagDesScores(Class classe){
        Intent monIntent = new Intent(this, classe);
        monIntent.putExtra("lesScores", (Parcelable) lesScores);
        return monIntent;
    }
}