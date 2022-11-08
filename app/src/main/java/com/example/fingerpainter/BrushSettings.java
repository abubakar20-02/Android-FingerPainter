package com.example.fingerpainter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class BrushSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush_settings);
        getSupportActionBar().hide();

        Button button = findViewById(R.id.ApplyButton);
        button.setOnClickListener(view -> {
            onClick();
        });

    }

    public void onClick(){
//        Intent result = new Intent();
////        result.putExtra("Color",Color);
//        setResult(RESULT_OK,result);
        int width = Integer.parseInt(String.valueOf(((EditText) findViewById(R.id.Width)).getText()));
        RadioGroup Round = findViewById(R.id.BrushType);
        int selectedId=Round.getCheckedRadioButtonId();
        RadioButton radioButton= findViewById(selectedId);
        System.out.println(radioButton.getText());
        System.out.println(width);
        finish();
    }
}