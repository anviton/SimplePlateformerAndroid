package fr.iut.simpleplateformer.activites;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.LesScores;
import fr.iut.simpleplateformer.ManagerJeu;
import fr.iut.simpleplateformer.modele.logique.ChargeurNiveau;
import fr.iut.simpleplateformer.modele.metier.Niveau;

/**
 * Classe Jeu qui permet de gére le jeu
 * @author anviton flgaugirard
 */
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable("lesScores", lesScores);
        super.onSaveInstanceState(outState);
    }

}
