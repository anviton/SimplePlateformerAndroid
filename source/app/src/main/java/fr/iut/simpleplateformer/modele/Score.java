package fr.iut.simpleplateformer.modele;

import android.os.Parcel;
import android.os.Parcelable;

public class Score implements Parcelable {

    private String nom;
    private int niveau;
    private int temps;

    public Score(String nom, int niveau, int temps) {
        this.nom = nom;
        this.niveau = niveau;
        this.temps = temps;


    }

    protected Score(Parcel in) {
        nom = in.readString();
        niveau = in.readInt();
        temps = in.readInt();
    }

    public static final Creator<Score> CREATOR = new Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel in) {
            return new Score(in);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getTemps() {
        return temps;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeInt(niveau);
        parcel.writeInt(temps);
    }
}
