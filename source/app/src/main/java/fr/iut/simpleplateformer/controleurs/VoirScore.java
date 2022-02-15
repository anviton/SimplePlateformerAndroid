package fr.iut.simpleplateformer.controleurs;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.iut.simpleplateformer.MonAdaptateur;
import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.LesScores;
import fr.iut.simpleplateformer.modele.Score;

public class VoirScore extends AppCompatActivity {

    private LesScores lesScores;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lesScores = new LesScores();
        lesScores.ajouterScore(new Score("Toto", 1, 30));
        lesScores.ajouterScore(new Score("tata", 3, 20));
        lesScores.ajouterScore(new Score("titi", 2, 10));
        lesScores.ajouterScore(new Score("titi", 2, 10));
        lesScores.ajouterScore(new Score("titi", 2, 10));
        lesScores.ajouterScore(new Score("titi", 2, 10));
        lesScores.ajouterScore(new Score("titi", 2, 10));
        lesScores.ajouterScore(new Score("titi", 2, 10));
        lesScores.ajouterScore(new Score("titi", 2, 10));
        lesScores.ajouterScore(new Score("titi", 2, 10));
        setContentView(R.layout.fenetrescore);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new MonAdaptateur(lesScores, this));
    }


}