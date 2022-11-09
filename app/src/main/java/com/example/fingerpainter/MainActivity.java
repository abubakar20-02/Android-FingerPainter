package com.example.fingerpainter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

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
            startActivityForResult(intent,2);
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

        if (requestCode == 2 && resultCode == RESULT_OK){
            int Width = data.getIntExtra("Width", 20);
            myFingerPainterView.setBrushWidth(Width);
            if (Objects.equals(data.getStringExtra("BrushType"), "Round")){
                myFingerPainterView.setBrush(Paint.Cap.ROUND);
            }
            else{
                myFingerPainterView.setBrush(Paint.Cap.SQUARE);
            }
        }
    }


}
