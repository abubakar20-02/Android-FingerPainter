package com.example.fingerpainter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FingerPainterView myFingerPainterView = findViewById(R.id.myFingerPainterViewId);
        myFingerPainterView.setColour(Color.parseColor("#FF00FF00"));
        getSupportActionBar().hide();

        Button button= findViewById(R.id.ColourSelector);
        button.setOnClickListener(view -> {
            Intent intent= new Intent(MainActivity.this, ColourSelector.class);
            startActivity(intent);
        });

        Button BrushSettingsbutton= findViewById(R.id.BrushSettings);
        BrushSettingsbutton.setOnClickListener(view -> {
            Intent intent= new Intent(MainActivity.this, BrushSettings.class);
            startActivity(intent);
        });
    }
}