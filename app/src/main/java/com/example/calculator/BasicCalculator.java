package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BasicCalculator extends AppCompatActivity {

//    Button btnHome;
    private TextView previousCalc;
    private EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);

        previousCalc = findViewById(R.id.lblPreviousCalculation);
        userInput = findViewById(R.id.txtDisplayText);


//        btnHome = findViewById(R.id.btnBasicHome);
//        btnHome.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                finish();
//            }
//        });
    }

    public void updateUserInput(String inputToAdd)
    {
//        userInput.setText(inputToAdd);
        String oldString = userInput.getText().toString();

        int cursorPosition = userInput.getSelectionStart();

        String leftString = oldString.substring(0,cursorPosition);
        String rightString = oldString.substring(cursorPosition);
//        "ASH | WIN"
        userInput.setText(String.format("%s%s%s", leftString, inputToAdd, rightString));
        userInput.setSelection(cursorPosition+inputToAdd.length());
    }

    public void zeroBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnZero));
    }

    public void oneBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnOne));
    }

    public void twoBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnTwo));
    }
    public void threeBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnThree));
    }
    public void fourBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnFour));
    }
    public void fiveBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnFive));
    }
    public void sixBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnSix));
    }
    public void sevenBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnSeven));
    }
    public void eightBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnEight));
    }
    public void nineBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnNine));
    }
    public void parenthesesOpenBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnParenthesesOpen));
    }
    public void parenthesesCloseBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnParenthesesClose));
    }
    public void divideBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnDecimal));
    }
    public void multiplyBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnMultiply));
    }
    public void subtractBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnSubtract));
    }
    public void addBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnAdd));
    }
    public void decimalBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnDecimal));
    }

    public void equalsBTN(View view)
    {
//        updateUserInput();
    }
    public void clearBTN(View view)
    {
        updateUserInput("");
    }
    public void backspaceBTN(View view)
    {
//        updateUserInput();
    }
}