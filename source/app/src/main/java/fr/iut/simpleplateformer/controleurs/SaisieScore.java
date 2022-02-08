package fr.iut.simpleplateformer.controleurs;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.simpleplateformer.R;

public class SaisieScore extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetresaisiescore);
        textView = findViewById(R.id.textviewtemps);
        int temps = getIntent().getIntExtra("temps", 2);
        textView.setText( String.valueOf(temps));
    }
}
