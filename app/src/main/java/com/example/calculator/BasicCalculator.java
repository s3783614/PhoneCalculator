package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class BasicCalculator extends AppCompatActivity {

//    Button btnHome;
    private boolean operationChecker = false;


    private TextView previousCalc;
    private EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);

        previousCalc = findViewById(R.id.lblPreviousCalculation);
        userInput = findViewById(R.id.txtDisplayText);
        userInput.setShowSoftInputOnFocus(false);

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
//        if(!operationChecker)
//        {
            userInput.setText(String.format("%s%s%s", leftString, inputToAdd, rightString));
            userInput.setSelection(cursorPosition+inputToAdd.length());
//        }
    }

    public void zeroBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnZero));
    }

    public void oneBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnOne));
    }

    public void twoBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnTwo));
    }
    public void threeBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnThree));
    }
    public void fourBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnFour));
    }
    public void fiveBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnFive));
    }
    public void sixBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnSix));
    }
    public void sevenBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnSeven));
    }
    public void eightBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnEight));
    }
    public void nineBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnNine));
    }
    public void parenthesesOpenBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnParenthesesOpen));
    }
    public void parenthesesCloseBTN(View view)
    {
//        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnParenthesesClose));
    }
    public void divideBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnDivide));
//        operationChecker = true;
    }
    public void multiplyBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnMultiply));
//        operationChecker = true;
    }
    public void subtractBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnSubtract));
//        operationChecker = true;
    }
    public void addBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnAdd));
//        operationChecker = true;
    }
    public void decimalBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnDecimal));
//        operationChecker = true;
    }

    public void equalsBTN(View view)
    {
        String userExpression = userInput.getText().toString();

        Expression exp = new Expression(userExpression);
        //exp.calculate -> in the MX parser library
        String solution = String.valueOf((exp.calculate()));

        userInput.setText(solution);
        userInput.setSelection(userInput.getText().length());
    }
    public void clearBTN(View view)
    {
//        operationChecker = false;
        userInput.setText("");
    }
    public void backspaceBTN(View view)
    {
        int cursorPositon = userInput.getSelectionStart();
        int textLength = userInput.getText().length();

        if(cursorPositon != 0 && textLength != 0)
        {
            SpannableStringBuilder selection = (SpannableStringBuilder)userInput.getText();
            selection.replace(cursorPositon-1,cursorPositon,"");
            userInput.setText(selection);
            userInput.setSelection(cursorPositon-1);
        }
    }
}
