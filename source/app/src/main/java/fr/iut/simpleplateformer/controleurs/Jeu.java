package fr.iut.simpleplateformer.controleurs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.transition.Scene;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.LesScores;
import fr.iut.simpleplateformer.modele.ManagerJeu;
import fr.iut.simpleplateformer.modele.logique.ChargeurNiveau;
import fr.iut.simpleplateformer.modele.metier.Niveau;

public class Jeu extends AppCompatActivity {


    private ManagerJeu managerJeu;
    private LesScores lesScores;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            lesScores = (LesScores) savedInstanceState.get("lesScores");
        }
        else {
            lesScores = getIntent().getParcelableExtra("lesScores");
        }
        ChargeurNiveau chargeurDeNiveau = new ChargeurNiveau();
        InputStream fileInputStream = getResources().openRawResource(R.raw.niveau1);
        Niveau niveau = chargeurDeNiveau.chargerNiveau(fileInputStream);
        managerJeu = new ManagerJeu(niveau, this,lesScores);
        managerJeu.initialiserLeJeu();
        managerJeu.lancerLeJeu();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable("lesScores", lesScores);
        super.onSaveInstanceState(outState);
    }

}
