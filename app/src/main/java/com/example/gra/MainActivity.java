package com.example.gra;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Maciej Kłębowski
 * @version 1.0
 * Główna
 */
public class MainActivity extends AppCompatActivity
{

    /**
     * Pierwszy ekran,
     * metoda informująca o ilości punktów i rozpoczynająca rozgrywkę.
     */
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        findViewById(R.id.play).setOnClickListener(view -> startActivity(new Intent(MainActivity.this,GameActivity.class)));

        TextView score =findViewById(R.id.score);
        SharedPreferences prefs = getSharedPreferences("game",MODE_PRIVATE);


            score.setText("Skacz po poprawnych działaniach do następnych poziomów klikając w lewą i prawą stronę ekranu.");
        if(prefs.getInt("score",0)!=0)
            score.setText("Opanowałeś: "+prefs.getInt("score",0)+"% ");
        if(prefs.getInt("score",0)>=100)
            score.setText("Opanowałeś: "+100+"% ");
    }
}

