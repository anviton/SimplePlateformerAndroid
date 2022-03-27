package fr.iut.simpleplateformer.activites;

import android.annotation.SuppressLint;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.iut.simpleplateformer.R;
import fr.iut.simpleplateformer.modele.LesScores;

/**
 * Classe VoirScore gère la vue de l'affichage des scores
 */
public class VoirScore extends AppCompatActivity {

    private LesScores lesScores;
    private RecyclerView recyclerView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            lesScores = (LesScores) savedInstanceState.get("lesScores");
        }
        else {
            lesScores = getIntent().getParcelableExtra("lesScores");
        }
        setContentView(R.layout.fenetrescore);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false));
        recyclerView.setAdapter(new MonAdaptateur(lesScores, this));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable("lesScores", lesScores);
        super.onSaveInstanceState(outState);
    }




}