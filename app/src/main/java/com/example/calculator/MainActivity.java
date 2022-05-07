package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button basicMode;
    Button scientificMode;
    Button programmerMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basicMode = findViewById(R.id.btnBasicMode);
        scientificMode = findViewById(R.id.btnScientificMode);
        programmerMode = findViewById(R.id.btnProgrammerMode);



    }
}