package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button basicMode;
    Button scientificMode;
    Button programmerMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        basicMode = findViewById(R.id.btnBasicMode);
//        scientificMode = findViewById(R.id.btnScientificMode);
//        programmerMode = findViewById(R.id.btnProgrammerMode);


    }

    public void onCLick(View v)
    {
        Intent intent;
        switch(v.getId())
        {
            case R.id.btnBasicMode:
                intent = new Intent(MainActivity.this, BasicCalculator.class);
                startActivity(intent);

                break;

            case R.id.btnProgrammerMode:
                intent = new Intent(MainActivity.this, ProgrammerCalculator.class);
                startActivity(intent);

                break;

            case R.id.btnScientificMode:
                intent = new Intent(MainActivity.this, ScientificCalculator.class);
                startActivity(intent);

                break;
        }
    }

}