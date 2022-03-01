package fr.iut.simpleplateformer.controleurs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Scene;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.ManagerJeu;
import fr.iut.simpleplateformer.modele.logique.ChargeurNiveau;

public class Jeu extends AppCompatActivity {

    private int temps;
    private ManagerJeu managerJeu;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChargeurNiveau chargeurDeNiveau = new ChargeurNiveau();
        //setContentView(R.layout.fenetrejeu);

        managerJeu = new ManagerJeu(null, null , getApplicationContext(), this);
        managerJeu.initialiserLeJeu();
    }


    public void cliqueTestSaisieScore(View view) {
        temps = 120;
        View vue = getCurrentFocus();
        Intent monIntent = new Intent(this, SaisieScore.class);
        monIntent.putExtra("temps", temps);
        startActivity(monIntent);
    }
    
}
