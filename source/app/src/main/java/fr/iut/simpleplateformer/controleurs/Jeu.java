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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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
        InputStream fileInputStream = getResources().openRawResource(R.raw.niveau1);
        //File file = getDir("niveau", MODE_PRIVATE);
        Niveau niveau = chargeurDeNiveau.chargerNiveau(fileInputStream);
        managerJeu = new ManagerJeu(niveau, this);
        managerJeu.initialiserLeJeu();
        managerJeu.lancerLeJeu();
    }


    public void cliqueTestSaisieScore(View view) {
        temps = 120;
        Intent monIntent = new Intent(this, SaisieScore.class);
        monIntent.putExtra("temps", temps);
        startActivity(monIntent);
    }

    public void cliqueDeplacementAGauche(View view){
        managerJeu.getDeplaceur().seDeplacerAGauche(managerJeu.getPersonnagePrincipal());
    }

    public void cliqueDeplacementADroite(View view){
        managerJeu.getDeplaceur().seDeplacerADroite(managerJeu.getPersonnagePrincipal());
    }

    public void cliquePourSaut(View view){
        managerJeu.getDeplaceur().sauter(managerJeu.getPersonnagePrincipal());
    }

}
