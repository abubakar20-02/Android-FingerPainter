package com.example.fingerpainter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class BrushSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush_settings);
        EditText et = findViewById(R.id.Width);
        et.setText("20");
        getSupportActionBar().hide();

        Button button = findViewById(R.id.ApplyButton);
        button.setOnClickListener(view -> {
            onClick();
        });

    }

    public void onClick(){
        int width;

        // code to make sure that application does not crash if user does not enter brush width.
        if (String.valueOf(((EditText) findViewById(R.id.Width)).getText()).equals("")){
            width = 1;
        }
        else{
            width = Integer.parseInt(String.valueOf(((EditText) findViewById(R.id.Width)).getText()));
        }

        // Code to get the content of the radio button that is clicked.
        // Reference: https://stackoverflow.com/questions/18179124/android-getting-value-from-selected-radiobutton
        RadioGroup Round = findViewById(R.id.BrushType);
        int selectedId=Round.getCheckedRadioButtonId();
        RadioButton radioButton= findViewById(selectedId);
        String BrushType= (String) radioButton.getText();

        // method to send data to main activity.
        Intent result = new Intent();
        result.putExtra("Width",width);
        result.putExtra("BrushType",BrushType);
        setResult(RESULT_OK,result);

        finish();
    }
}