package com.example.fingerpainter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ColourSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_selector);
        getSupportActionBar().hide();
    }
}