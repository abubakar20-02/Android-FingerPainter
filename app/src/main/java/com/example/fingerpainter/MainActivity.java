package com.example.fingerpainter;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import java.util.Objects;

// I have followed the instructions in the coursework sheet, which has helped me code significantly.
// I have also referred to the videos in Moodle to help me do my coursework.

public class MainActivity extends AppCompatActivity {
    FingerPainterView myFingerPainterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(MainActivity.this,"ON CREATE", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        myFingerPainterView = findViewById(R.id.myFingerPainterViewId);
        myFingerPainterView.load(getIntent().getData());


        // code for opening new activity and get data from the new activity to the main one.
        Button button = findViewById(R.id.ColourSelector);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ColourSelector.class);
            startActivityForResult(intent, 1);
        });

        Button BrushSettingsButton = findViewById(R.id.BrushSettings);
        BrushSettingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BrushSettings.class);
            startActivityForResult(intent,2);
        });
    }

    // code to get data from other activities to the main activity.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        myFingerPainterView = findViewById(R.id.myFingerPainterViewId);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK){
            int diff = data.getIntExtra("Color", 0xFFFF0000);
            myFingerPainterView.setColour(diff);
        }

        if (requestCode == 2 && resultCode == RESULT_OK){
            int Width = data.getIntExtra("Width", 20);
            myFingerPainterView.setBrushWidth(Width);
            // code to find if user selected round brush or square brush.
            if (Objects.equals(data.getStringExtra("BrushType"), "Round")){
                myFingerPainterView.setBrush(Paint.Cap.ROUND);
            }
            else{
                myFingerPainterView.setBrush(Paint.Cap.SQUARE);
            }
        }
    }

    // referred the documentation in android studio on how to save instance and restore it after activity is destroyed.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        myFingerPainterView = findViewById(R.id.myFingerPainterViewId);
        outState.putInt("Color", myFingerPainterView.getColour());
        outState.putInt("Width", myFingerPainterView.getBrushWidth());
        outState.putString("Type", (myFingerPainterView.getBrush()).toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        myFingerPainterView = findViewById(R.id.myFingerPainterViewId);
        super.onRestoreInstanceState(savedInstanceState);
        myFingerPainterView.setColour(savedInstanceState.getInt("Color"));
        myFingerPainterView.setBrushWidth(savedInstanceState.getInt("Width"));
        myFingerPainterView.setBrush(Paint.Cap.valueOf(savedInstanceState.getString("Type")));
    }
}
