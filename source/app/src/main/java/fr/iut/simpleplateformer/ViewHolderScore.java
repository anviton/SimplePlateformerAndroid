package fr.iut.simpleplateformer;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderScore extends RecyclerView.ViewHolder {

    private TextView textViewTemps;
    private TextView textViewNom;
    private TextView textViewNiveau;

    public ViewHolderScore(@NonNull View itemView) {
        super(itemView);
        textViewNom = itemView.findViewById(R.id.text_view_nom);
        textViewNiveau = itemView.findViewById(R.id.text_view_niveau);
        textViewTemps = itemView.findViewById(R.id.text_view_temps);
    }

    public TextView getTextViewNom() {
        return textViewNom;
    }

    public TextView getTextViewNiveau() {
        return textViewNiveau;
    }

    public TextView getTextViewTemps() {
        return textViewTemps;
    }
}
