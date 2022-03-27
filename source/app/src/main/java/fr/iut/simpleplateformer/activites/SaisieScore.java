package fr.iut.simpleplateformer.activites;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.LesScores;
import fr.iut.simpleplateformer.modele.Score;
import fr.iut.simpleplateformer.modele.logique.SauveurDeScores;

/**
 * Classe SaisieScore dère la saisie d'un score
 * @author anviton flgaugirard
 */
public class SaisieScore extends AppCompatActivity {
    private TextView textViewTemps;
    private TextView textViewNiveau;
    private EditText editText;
    private LesScores lesScores;
    private int temps;
    private int niveau;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            lesScores = (LesScores) savedInstanceState.get("lesScores");
            temps = (int) savedInstanceState.get("temps");
            niveau = (int) savedInstanceState.get("niveau");
        }
        else {
            lesScores = getIntent().getParcelableExtra("lesScores");
            temps = getIntent().getIntExtra("temps", 500);
            niveau = getIntent().getIntExtra("niveau", 1);
        }
        setContentView(R.layout.fenetresaisiescore);
        textViewTemps = findViewById(R.id.textviewtemps);
        textViewNiveau = findViewById(R.id.textniveau);
        editText = findViewById(R.id.editTextTextPersonName);
        textViewTemps.setText("Score : " + temps);
        textViewNiveau.setText("Niveau : " + niveau);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("lesScores", lesScores);
        outState.putInt("temps",temps);
        outState.putInt("niveau",niveau);
    }

    /**
     * valide la saisie d'un score
     * réaffiche le menu
     * @param view vue du clique
     */
    public void cliqueValiderScore(View view) {
        File file = getDir("score", 0);
        SauveurDeScores sauveurDeScores = new SauveurDeScores();
        lesScores.ajouterScore(new Score(String.valueOf(editText.getText()),temps,niveau));
        try {
            sauveurDeScores.sauver(lesScores, new FileOutputStream(file.getAbsolutePath() + "/score.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Intent monIntent = new Intent(this, MenuPrincipal.class);
        monIntent.putExtra("lesScores", (Parcelable) lesScores);
        startActivity(monIntent);
    }
}
