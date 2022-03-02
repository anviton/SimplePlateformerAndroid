package fr.iut.simpleplateformer.controleurs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Scene;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.ManagerJeu;
import fr.iut.simpleplateformer.modele.logique.ChargeurNiveau;
import fr.iut.simpleplateformer.modele.metier.Niveau;

public class Jeu extends AppCompatActivity {

    private int temps;
    private ManagerJeu managerJeu;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChargeurNiveau chargeurDeNiveau = new ChargeurNiveau();
        //setContentView(R.layout.fenetrejeu);
        File file = getDir("niveau", 0);
        Niveau niveau = chargeurDeNiveau.chargerNiveau(file.getAbsolutePath()+"/niveau1.niv");
        managerJeu = new ManagerJeu(niveau, this);
        managerJeu.initialiserLeJeu();
    }


    public void cliqueTestSaisieScore(View view) {
        temps = 120;
        Intent monIntent = new Intent(this, SaisieScore.class);
        monIntent.putExtra("temps", temps);
        startActivity(monIntent);
    }

    public void clickJump(){
        Log.d("inGameClicks","Jump Button Pressed");
    }

    public void clickLeft(){
        Log.d("inGameClicks","Left Button Pressed");
    }

    public void clickRight(){
        Log.d("inGameClicks","Right Button Pressed");
    }
    
}
