package fr.iut.simpleplateformer.modele;


import static java.lang.System.out;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class LesScores implements Parcelable {
    private List<Score> listeScores;



    public LesScores() {
        this.listeScores = new ArrayList<>();
    }

    protected LesScores(Parcel in) {
        listeScores = in.readArrayList(Score.class.getClassLoader());
    }

    public static final Creator<LesScores> CREATOR = new Creator<LesScores>() {
        @Override
        public LesScores createFromParcel(Parcel in) {
            return new LesScores(in);
        }

        @Override
        public LesScores[] newArray(int size) {
            return new LesScores[size];
        }
    };

    public void ajouterScore(Score score){
        listeScores.add(score);
    }

    public List<Score> getListeScores() {
        return listeScores;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(listeScores);
    }
}
