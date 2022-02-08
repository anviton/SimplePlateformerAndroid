package fr.iut.simpleplateformer;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import fr.iut.simpleplateformer.modele.LesScores;
import fr.iut.simpleplateformer.modele.Score;

public class MonAdaptateur extends RecyclerView.Adapter {

    private LesScores lesScores;
    private AppCompatActivity activiteParente;

    public MonAdaptateur(LesScores lesScores, AppCompatActivity activiteParente) {
        super();
        this.lesScores = lesScores;
        this.activiteParente = activiteParente;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = activiteParente.getLayoutInflater().inflate(R.layout.cellule_score, parent, false);
        return new ViewHolderScore(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Score score = lesScores.getListeScores().get(position);
        ((ViewHolderScore) holder).getTextViewNom().setText(score.getNom());
        ((ViewHolderScore) holder).getTextViewNiveau().setText(String.valueOf(score.getNiveau()));
        ((ViewHolderScore) holder).getTextViewTemps().setText(String.valueOf(score.getTemps()));
    }

    @Override
    public int getItemCount() {
        return lesScores.getListeScores().size();
    }
}
