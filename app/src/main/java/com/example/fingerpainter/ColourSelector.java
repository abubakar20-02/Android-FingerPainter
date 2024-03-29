package com.example.fingerpainter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class ColourSelector extends AppCompatActivity {

    // used constants so that code is easier to alter if needed.
    final int Red = 0xFFFF0000;
    final int Green = 0xFF4CAF50;
    final int Blue = 0xFF3F51B5;
    final int Yellow = 0xFFFFEB3B;
    final int Orange = 0xFFFF5722;

    int Color;

    // when any of the button is clicked it sends the colour to the main activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_selector);
        getSupportActionBar().hide();



        button = findViewById(R.id.ColourRed);
        button.setOnClickListener(view -> {
            Color = Red;
            onClick();
        });

        button = findViewById(R.id.ColorGreen);
        button.setOnClickListener(view -> {
            Color=Green;
            onClick();
        });

        button = findViewById(R.id.ColourBlue);
        button.setOnClickListener(view -> {
            Color = Blue;
            onClick();
        });

        button = findViewById(R.id.ColourYellow);
        button.setOnClickListener(view -> {
            Color = Yellow;
            onClick();
        });

        button = findViewById(R.id.ColourOrange);
        button.setOnClickListener(view -> {
            Color = Orange;
            onClick();
        });

    }

    // method to send data to main activity.
    public void onClick(){
        Intent result = new Intent();
        result.putExtra("Color",Color);
        setResult(RESULT_OK,result);
        finish();
    }



}