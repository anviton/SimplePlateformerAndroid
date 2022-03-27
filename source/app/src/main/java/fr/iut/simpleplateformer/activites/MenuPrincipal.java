package fr.iut.simpleplateformer.activites;

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

/**
 * Classe MenuPrincipal gère la fenêtre du menu
 */
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

    /**
     * Permet de passer à la vue des scores
     * @param view vue du clique
     */
    public void cliqueScore(View view) {
        startActivity(passagDesScores(VoirScore.class));
    }

    /**
     * Permet de quittter l'application
     * @param view vue du clique
     */
    public void cliqueQuitter(View view) {
        System.exit(0);
    }

    /**
     * Permet de jouer au jeu
     * @param view vue du clique
     */
    public void cliqueJouer(View view) {
        startActivity(passagDesScores(Jeu.class));
    }


    /**
     * Permet de créer l'Intent avec le passage des cores
     * @param classe activités à charger
     * @return l'intent créé
     */
    private Intent passagDesScores(Class classe){
        Intent monIntent = new Intent(this, classe);
        monIntent.putExtra("lesScores", lesScores);
        return monIntent;
    }
}