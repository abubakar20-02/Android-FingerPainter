package com.example.fingerpainter;

import androidx.annotation.Nullable;
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
        getSupportActionBar().hide();

        Button button = findViewById(R.id.ColourSelector);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ColourSelector.class);
            startActivityForResult(intent, 1);
        });

        Button BrushSettingsbutton = findViewById(R.id.BrushSettings);
        BrushSettingsbutton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BrushSettings.class);
            startActivity(intent);
        });
    }

    //https://www.youtube.com/watch?v=uToOj67nl8Y&ab_channel=FilipVujovic (for colour)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        FingerPainterView myFingerPainterView = findViewById(R.id.myFingerPainterViewId);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK){
            int diff = data.getIntExtra("Color", 0xFFFF0000);
            myFingerPainterView.setColour(diff);
        }
    }


}
