package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;

public class ProgrammerCalculator extends AppCompatActivity {

    Button btnHome;
    private TextView previousCalc;
    private EditText userInput;
    private RadioGroup rdbTable;

    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private Button btnE;
    private Button btnF;

    //use for enabling all buttons
    ArrayList<Button> list;

    final String binary = "binary";
    final String HEX = "hex";
    final String decimal = "decimal";

    private DataState state = new DataState();

    private boolean notOperationChecker = false;
    private boolean operationChecker = false;
    private boolean  isOperationChecker = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmer_calculator);

        btnHome = findViewById(R.id.btnProHome);
        previousCalc = findViewById(R.id.lblPreviousCalculation);
        userInput = findViewById(R.id.txtDisplayText);

        btnHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        btnDeclaration(state);
        rdbTable = findViewById(R.id.rdbTable);

        rdbTable.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int optionID) {
                findRadioButton(optionID);
            }
        });

    }

    private void findRadioButton(int checkID)
    {
        int cursorPosition = userInput.getSelectionStart();
        String leftString;
        String operator;
        String rightString;

        switch (checkID)
        {
            case R.id.rdbBinary:
                //setting the states so that the conversion can take place
                state.setCurrentDataState(binary);
                btnDeclaration(state);

                userInput = findViewById(R.id.txtDisplayText);

                if(state.getPreviousDataState().equals(decimal))
                {
                    //DECIMAL TO BINARY
                    //If text field is empty to just swap modes and set text to 0
                    if(userInput.getText().length() == 0)
                    {
                        userInput.setText("");
                    }
                    else
                    {
                        String s = userInput.getText().toString();

                        for(int i = 0; i < s.length();i++)
                        {
                            System.out.println(s.charAt(i));
                            if (s.charAt(i) == '@')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+2);
                                rightString = s.substring(i+2);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString);
                                int rightDecimalValue = Integer.parseInt(rightString);
                                userInput.setText(Integer.toBinaryString(leftDecimalValue)+operator+Integer.toBinaryString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '×')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString);
                                int rightDecimalValue = Integer.parseInt(rightString);
                                userInput.setText(Integer.toBinaryString(leftDecimalValue)+operator+Integer.toBinaryString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '÷')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString);
                                int rightDecimalValue = Integer.parseInt(rightString);
                                userInput.setText(Integer.toBinaryString(leftDecimalValue)+operator+Integer.toBinaryString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '-')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString);
                                int rightDecimalValue = Integer.parseInt(rightString);
                                userInput.setText(Integer.toBinaryString(leftDecimalValue)+operator+Integer.toBinaryString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '+')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString);
                                int rightDecimalValue = (Integer.parseInt(rightString));

                                userInput.setText(Integer.toBinaryString(leftDecimalValue)+operator+Integer.toBinaryString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());
                            }
                        }

//                        int binaryConvertor = Integer.parseInt(s);
                        //userinput.setText(Integer.toBinaryString(binaryString))

                    }

                    state.setPreviousDataState(binary);
                }
                else if(state.getPreviousDataState().equals(HEX))
                {
                    // HEX TO BINARY
                    //If text field is empty to just swap modes and set text to 0
                    if(userInput.getText().length() == 0)
                    {
                        userInput.setText("");
                    }
                    else
                    {

                        // HEX TO DECIMAL
                        String s = userInput.getText().toString();

                        for(int i = 0; i < s.length();i++)
                        {
                            System.out.println(s.charAt(i));
                            if (s.charAt(i) == '@')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+2);
                                rightString = s.substring(i+2);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,16);
                                int rightDecimalValue = Integer.parseInt(rightString,16);

                                userInput.setText(Integer.toBinaryString(leftDecimalValue)+operator+Integer.toBinaryString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '×')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,16);
                                int rightDecimalValue = Integer.parseInt(rightString,16);

                                userInput.setText(Integer.toBinaryString(leftDecimalValue)+operator+Integer.toBinaryString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '÷')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,16);
                                int rightDecimalValue = Integer.parseInt(rightString,16);

                                userInput.setText(Integer.toBinaryString(leftDecimalValue)+operator+Integer.toBinaryString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '-')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,16);
                                int rightDecimalValue = Integer.parseInt(rightString,16);

                                userInput.setText(Integer.toBinaryString(leftDecimalValue)+operator+Integer.toBinaryString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '+')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,16);
                                int rightDecimalValue = (Integer.parseInt(rightString,16));

                                userInput.setText(Integer.toBinaryString(leftDecimalValue)+operator+Integer.toBinaryString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());
                            }
                        }


//                        int dcml = Integer.parseInt(s,16);
//
//                        // DECIMAL TO BINARY
//                        userInput.setText(Integer.toBinaryString(dcml));
//                        userInput.setSelection(userInput.getText().length());

                    }


                    state.setPreviousDataState(binary);
                }
                break;

            case R.id.rdbDec:
                state.setCurrentDataState(decimal);
                btnDeclaration(state);

                if(state.getPreviousDataState().equals(binary))
                {
                    // BINARY TO DECIMAL
                    //If text field is empty to just swap modes and set text to 0
                    if(userInput.getText().length() == 0)
                    {
                        userInput.setText("");
                    }
                    else
                    {
                        String s = String.valueOf(userInput.getText());

                        for(int i = 0; i < s.length();i++)
                        {
                            System.out.println(s.charAt(i));
                            if (s.charAt(i) == '@')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+2);
                                rightString = s.substring(i+2);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,2);
                                int rightDecimalValue = (Integer.parseInt(rightString,2));

                                userInput.setText(Integer.toString(leftDecimalValue)+operator+Integer.toString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '×')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,2);
                                int rightDecimalValue = (Integer.parseInt(rightString,2));

                                userInput.setText(Integer.toString(leftDecimalValue)+operator+Integer.toString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '÷')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,2);
                                int rightDecimalValue = (Integer.parseInt(rightString,2));

                                userInput.setText(Integer.toString(leftDecimalValue)+operator+Integer.toString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '-')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,2);
                                int rightDecimalValue = (Integer.parseInt(rightString,2));

                                userInput.setText(Integer.toString(leftDecimalValue)+operator+Integer.toString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '+')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,2);
                                int rightDecimalValue = (Integer.parseInt(rightString,2));

                                userInput.setText(Integer.toString(leftDecimalValue)+operator+Integer.toString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());
                            }
                        }





//                        int dcml = Integer.parseInt(s,2);
//                        userInput.setText(Integer.toString(dcml));
//                        userInput.setSelection(userInput.getText().length());

                    }

                    state.setPreviousDataState(decimal);
                }
                else if(state.getPreviousDataState().equals(HEX))
                {
                    // Hex to decimal
                    //If text field is empty to just swap modes and set text to 0
                    if(userInput.getText().length() == 0)
                    {
                        userInput.setText("");
                    }
                    else
                    {
                        String s = userInput.getText().toString();

                        for(int i = 0; i < s.length();i++)
                        {
                            System.out.println(s.charAt(i));
                            if (s.charAt(i) == '@')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+2);
                                rightString = s.substring(i+2);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,16);
                                int rightDecimalValue = (Integer.parseInt(rightString,16));

                                userInput.setText(Integer.toString(leftDecimalValue)+operator+Integer.toString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '×')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,16);
                                int rightDecimalValue = (Integer.parseInt(rightString,16));

                                userInput.setText(Integer.toString(leftDecimalValue)+operator+Integer.toString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '÷')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,16);
                                int rightDecimalValue = (Integer.parseInt(rightString,16));

                                userInput.setText(Integer.toString(leftDecimalValue)+operator+Integer.toString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '-')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,16);
                                int rightDecimalValue = (Integer.parseInt(rightString,16));

                                userInput.setText(Integer.toString(leftDecimalValue)+operator+Integer.toString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '+')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,16);
                                int rightDecimalValue = (Integer.parseInt(rightString,16));

                                userInput.setText(Integer.toString(leftDecimalValue)+operator+Integer.toString(rightDecimalValue));
                                userInput.setSelection(userInput.getText().length());
                            }
                        }


//                        int dcml = Integer.parseInt(s,16);
//                        userInput.setText(Integer.toString(dcml));
//                        userInput.setSelection(userInput.getText().length());

                    }

                    state.setPreviousDataState(decimal);
                }

                break;

            case R.id.rdbHex:
                state.setCurrentDataState(HEX);
                btnDeclaration(state);

                if(state.getPreviousDataState().equals(binary))
                {
                    //binary to HEX
                    //If text field is empty to just swap modes and set text to 0
                    if(userInput.getText().length() == 0)
                    {
                        userInput.setText("");
                    }
                    else
                    {
                        String s = userInput.getText().toString();

                        for(int i = 0; i < s.length();i++)
                        {
                            System.out.println(s.charAt(i));
                            if (s.charAt(i) == '@')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+2);
                                rightString = s.substring(i+2);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,2);
                                int rightDecimalValue = (Integer.parseInt(rightString,2));

                                userInput.setText(Integer.toHexString(leftDecimalValue).toUpperCase()+operator+Integer.toHexString(rightDecimalValue).toUpperCase());
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '×')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,2);
                                int rightDecimalValue = (Integer.parseInt(rightString,2));

                                userInput.setText(Integer.toHexString(leftDecimalValue).toUpperCase()+operator+Integer.toHexString(rightDecimalValue).toUpperCase());
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '÷')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,2);
                                int rightDecimalValue = (Integer.parseInt(rightString,2));

                                userInput.setText(Integer.toHexString(leftDecimalValue).toUpperCase()+operator+Integer.toHexString(rightDecimalValue).toUpperCase());
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '-')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,2);
                                int rightDecimalValue = (Integer.parseInt(rightString,2));

                                userInput.setText(Integer.toHexString(leftDecimalValue).toUpperCase()+operator+Integer.toHexString(rightDecimalValue).toUpperCase());
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '+')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString,2);
                                int rightDecimalValue = (Integer.parseInt(rightString,2));

                                userInput.setText(Integer.toHexString(leftDecimalValue).toUpperCase()+operator+Integer.toHexString(rightDecimalValue).toUpperCase());
                                userInput.setSelection(userInput.getText().length());
                            }
                        }


//                        int num = Integer.parseInt(String.valueOf(userInput.getText()),2);



//                        String s = Integer.toHexString(num);
//                        userInput.setText(s.toUpperCase());
//                        userInput.setSelection(userInput.getText().length());

                    }


                    state.setPreviousDataState(HEX);

                }
                else if(state.getPreviousDataState().equals(decimal))
                {

                    //If text field is empty to just swap modes and set text to 0
                    if(userInput.getText().length() == 0)
                    {
                        userInput.setText("");
                    }
                    else
                    {
                        String s = userInput.getText().toString();

                        for(int i = 0; i < s.length();i++)
                        {
                            System.out.println(s.charAt(i));
                            if (s.charAt(i) == '@')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+2);
                                rightString = s.substring(i+2);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString);
                                int rightDecimalValue = (Integer.parseInt(rightString));

                                userInput.setText(Integer.toHexString(leftDecimalValue).toUpperCase()+operator+Integer.toHexString(rightDecimalValue).toUpperCase());
                                userInput.setSelection(userInput.getText().length());


                            }
                            if (s.charAt(i) == '×')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString);
                                int rightDecimalValue = (Integer.parseInt(rightString));

                                userInput.setText(Integer.toHexString(leftDecimalValue).toUpperCase()+operator+Integer.toHexString(rightDecimalValue).toUpperCase());
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '÷')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString);
                                int rightDecimalValue = (Integer.parseInt(rightString));

                                userInput.setText(Integer.toHexString(leftDecimalValue).toUpperCase()+operator+Integer.toHexString(rightDecimalValue).toUpperCase());
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '-')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString);
                                int rightDecimalValue = (Integer.parseInt(rightString));

                                userInput.setText(Integer.toHexString(leftDecimalValue).toUpperCase()+operator+Integer.toHexString(rightDecimalValue).toUpperCase());
                                userInput.setSelection(userInput.getText().length());

                            }
                            if (s.charAt(i) == '+')
                            {
                                leftString = s.substring(0, i);
                                operator = s.substring(i, i+1);
                                rightString = s.substring(i+1);

                                System.out.println("leftS: "+leftString);
                                System.out.println("oper: "+ operator);
                                System.out.println("rs: "+rightString);

                                int leftDecimalValue = Integer.parseInt(leftString);
                                int rightDecimalValue = (Integer.parseInt(rightString));

                                userInput.setText(Integer.toHexString(leftDecimalValue).toUpperCase()+operator+Integer.toHexString(rightDecimalValue).toUpperCase());
                                userInput.setSelection(userInput.getText().length());
                            }
                        }




//                        int s = Integer.parseInt(String.valueOf(userInput.getText()));
//                        userInput.setText(Integer.toHexString(s).toUpperCase());
//                        userInput.setSelection(userInput.getText().length());

                    }


                    state.setPreviousDataState(HEX);
                }
                break;


        }
    }

    public void btnDeclaration(DataState state)
    {
        if(state.getCurrentDataState().equals("binary"))
        {
            list = new ArrayList<>();
            list = hexList();
            buttonMode(list, false);

            ArrayList<Button> binButton = new ArrayList<>();
            binButton = binaryList();
            buttonMode(binButton, true);
        }
        else if(state.getCurrentDataState().equals("decimal"))
        {
            list = new ArrayList<>();
            list = hexList();
            buttonMode(list, false);

            ArrayList<Button> decButton = new ArrayList<>();
            decButton = decList();
            buttonMode(decButton, true);
        }
        else
        {
            ArrayList<Button> hexButton = new ArrayList<>();
            hexButton = hexList();
            buttonMode(hexButton, true);
        }

    }

    public void buttonMode(ArrayList<Button> list, boolean condition)
    {
        if(!condition)
        {
            for (Button b: list) {
                b.setBackgroundResource(R.drawable.disabled_button);
                b.setEnabled(false);
            }
        }
        else
        {
            for (Button b: list) {
                b.setBackgroundResource(R.drawable.button_background);
                b.setEnabled(true);
            }
        }
    }
    public ArrayList<Button> binaryList()
    {
        createButtons();
        ArrayList<Button> binaryButtons = new ArrayList<>();
        binaryButtons.add(btnOne);
        binaryButtons.add(btnZero);

        return binaryButtons;
    }

    public ArrayList<Button> hexList()
    {
        createButtons();
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(btnZero);
        buttons.add(btnOne);
        buttons.add(btnTwo);
        buttons.add(btnThree);
        buttons.add(btnFour);
        buttons.add(btnFive);
        buttons.add(btnSix);
        buttons.add(btnSeven);
        buttons.add(btnEight);
        buttons.add(btnNine);
        buttons.add(btnA);
        buttons.add(btnB);
        buttons.add(btnC);
        buttons.add(btnD);
        buttons.add(btnE);
        buttons.add(btnF);

        return buttons;
    }

    public ArrayList<Button> decList()
    {
        createButtons();
        ArrayList<Button> decimalButtons = new ArrayList<>();
        decimalButtons.add(btnZero);
        decimalButtons.add(btnOne);
        decimalButtons.add(btnTwo);
        decimalButtons.add(btnThree);
        decimalButtons.add(btnFour);
        decimalButtons.add(btnFive);
        decimalButtons.add(btnSix);
        decimalButtons.add(btnSeven);
        decimalButtons.add(btnEight);
        decimalButtons.add(btnNine);
        return decimalButtons;
    }
    public void createButtons()
    {
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnA = findViewById(R.id.keyA);
        btnB = findViewById(R.id.keyB);
        btnC = findViewById(R.id.keyC);
        btnD = findViewById(R.id.keyD);
        btnE = findViewById(R.id.keyE);
        btnF = findViewById(R.id.keyF);
    }
    public void updateUserInput(String inputToAdd)
    {
//        userInput.setText(inputToAdd);
        String oldString = userInput.getText().toString();

        int cursorPosition = userInput.getSelectionStart();

        String leftString = oldString.substring(0,cursorPosition);
        String rightString = oldString.substring(cursorPosition);
//        "ASH | WIN"
        if(!operationChecker)
        {
            userInput.setText(String.format("%s%s%s", leftString, inputToAdd, rightString));
            userInput.setSelection(cursorPosition+inputToAdd.length());
        }
    }

    public void zeroBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnZero));
        if(isOperationChecker)
        {
            operationChecker = true;
        }

    }

    public void oneBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnOne));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }

    public void twoBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnTwo));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }
    public void threeBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnThree));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }
    public void fourBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnFour));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }
    public void fiveBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnFive));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }
    public void sixBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnSix));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }
    public void sevenBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnSeven));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }
    public void eightBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnEight));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }
    public void nineBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnNine));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }
    public void parenthesesOpenBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnParenthesesOpen));
        if(isOperationChecker)
        {
            operationChecker = true;
        }

    }
    public void parenthesesCloseBTN(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.btnParenthesesClose));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }
    public void divideBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnDivide));
        operationChecker = true;
        isOperationChecker = true;

    }
    public void multiplyBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnMultiply));
        operationChecker = true;
        isOperationChecker = true;

    }
    public void subtractBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnSubtract));
        operationChecker = true;
        isOperationChecker = true;


    }
    public void addBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnAdd));
        operationChecker = true;
        isOperationChecker = true;
    }
    public void decimalBTN(View view)
    {
        updateUserInput(getResources().getString(R.string.btnDecimal));
//        operationChecker = true;
    }

    public void btnA(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.A));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }

    public void btnB(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.B));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }

    public void btnC(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.C));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }

    public void btnD(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.D));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }

    public void btnE(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.E));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }

    public void btnF(View view)
    {
        operationChecker = false;
        updateUserInput(getResources().getString(R.string.F));
        if(isOperationChecker)
        {
            operationChecker = true;
        }
    }

    public void btnAND(View view)
    {
        updateUserInput("@&");
        operationChecker = true;
        isOperationChecker = true;
    }

    public void btnOR(View view)
    {
        updateUserInput("@|");
        operationChecker = true;
        isOperationChecker = true;


    }

    public void btnNAND(View view)
    {
        notOperationChecker=true;
        updateUserInput("@&");
        operationChecker = true;
        isOperationChecker = true;


    }

    public void btnNOR(View view)
    {
        notOperationChecker=true;
        updateUserInput("@|");
        operationChecker = true;
        isOperationChecker = true;


    }

    public void btnXOR(View view)
    {
        updateUserInput("@^");
        operationChecker = true;
        isOperationChecker = true;


    }

    public void btnNegation(View view)
    {
        updateUserInput("@~");
        operationChecker = true;
        isOperationChecker = true;

    }

    public void equalsBTN(View view)
    {
        String userExpression = userInput.getText().toString();

        previousCalc.setText(userExpression);

        userExpression = convertTo(userExpression);


        Expression exp = new Expression(userExpression);
        //exp.calculate -> in the MX parser library
        if(!notOperationChecker)
        {
            String solution = String.valueOf((exp.calculate()));
            solution = convertBack(solution);
            userInput.setText(solution);
            userInput.setSelection(userInput.getText().length());
            operationChecker = false;
            isOperationChecker = false;
        }
        else {
            // AND COMPLETE
            String solution = String.valueOf((exp.calculate()));

            //TO NEGATE THE SOLUTION SO WE GET NOR  or NAND
            String s = "@~" + solution;
            Expression newExp = new Expression(s);
            solution = String.valueOf((newExp.calculate()));
            solution = convertBack(solution);
            userInput.setText(solution);
            userInput.setSelection(userInput.getText().length());

            notOperationChecker = false;
            operationChecker = false;
            isOperationChecker = false;

        }


    }


    public String convertBack(String userExpression)
    {
        System.out.println("convertback UserExpression = " +userExpression);
        switch (state.getCurrentDataState()) {
            case binary:
                for (int i = 0; i < userExpression.length(); i++) {
                    if (userExpression.charAt(i) == '.') {
                        String s = userExpression.substring(0, i);
                        return Integer.toBinaryString(Integer.parseInt(s));

                    }
                }

                break;
            case HEX:
                for (int i = 0; i < userExpression.length(); i++) {
                    if (userExpression.charAt(i) == '.') {
                        String s = userExpression.substring(0, i);
                        return Integer.toHexString(Integer.parseInt(s)).toUpperCase();

                    }
                }
                break;
            case decimal:
                for (int i = 0; i < userExpression.length(); i++) {
                    if (userExpression.charAt(i) == '.') {
                        return userExpression.substring(0, i);

                    }
                }
                break;
        }
        return null;
    }

    public String convertTo(String userExpression)
    {
        System.out.println("convertTo : " +userExpression);
        if (state.getCurrentDataState().equals(binary))
        {
            String leftString;
            String operator;
            String rightString;
            for (int i = 0; i < userExpression.length(); i++)
            {
                if (userExpression.charAt(i) == '@')
                {
                    leftString = userExpression.substring(0, i);
                    operator = userExpression.substring(i, i+2);
                    rightString = userExpression.substring(i+2);

                    System.out.println("!!!BINARY WE HERE IN BINARY!!!");
                    System.out.println("leftS: "+leftString);
                    System.out.println("oper: "+ operator);
                    System.out.println("rs: "+rightString);

                    int leftDecimalValue = Integer.parseInt(leftString,2);
                    int rightDecimalValue = Integer.parseInt(rightString,2);

                    return leftDecimalValue+operator+rightDecimalValue;

                }
                else if (userExpression.charAt(i) == '×')
                {
                    leftString = userExpression.substring(0, i);
                    operator = userExpression.substring(i, i+1);
                    rightString = userExpression.substring(i+1);

                    System.out.println("leftS: "+leftString);
                    System.out.println("oper: "+ operator);
                    System.out.println("rs: "+rightString);

                    int leftDecimalValue = Integer.parseInt(leftString,2);
                    int rightDecimalValue = Integer.parseInt(rightString,2);
                    System.out.println("converted value : "+ leftDecimalValue+operator+rightDecimalValue);
                    return leftDecimalValue+operator+rightDecimalValue;
                }
                else if (userExpression.charAt(i) == '÷')
                {
                    leftString = userExpression.substring(0, i);
                    operator = userExpression.substring(i, i+1);
                    rightString = userExpression.substring(i+1);

                    System.out.println("leftS: "+leftString);
                    System.out.println("oper: "+ operator);
                    System.out.println("rs: "+rightString);

                    int leftDecimalValue = Integer.parseInt(leftString,2);
                    int rightDecimalValue = Integer.parseInt(rightString,2);

                    return leftDecimalValue+operator+rightDecimalValue;
                }
                else if (userExpression.charAt(i) == '-')
                {
                    leftString = userExpression.substring(0, i);
                    operator = userExpression.substring(i, i+1);
                    rightString = userExpression.substring(i+1);

                    System.out.println("leftS: "+leftString);
                    System.out.println("oper: "+ operator);
                    System.out.println("rs: "+rightString);

                    int leftDecimalValue = Integer.parseInt(leftString,2);
                    int rightDecimalValue = Integer.parseInt(rightString,2);

                    return leftDecimalValue+operator+rightDecimalValue;
                }
                else if (userExpression.charAt(i) == '+')
                {
                    leftString = userExpression.substring(0, i);
                    operator = userExpression.substring(i, i+1);
                    rightString = userExpression.substring(i+1);

                    System.out.println("leftS: "+leftString);
                    System.out.println("oper: "+ operator);
                    System.out.println("rs: "+rightString);

                    int leftDecimalValue = Integer.parseInt(leftString,2);
                    int rightDecimalValue = Integer.parseInt(rightString,2);

                    return leftDecimalValue+operator+rightDecimalValue;
                }
            }

        }
        else if (state.getCurrentDataState().equals(HEX))
        {
            System.out.println("inside and state is : " + state.getCurrentDataState());
            String leftString;
            String operator;
            String rightString;
            for (int i = 0; i < userExpression.length(); i++)
            {
                System.out.println(userExpression.charAt(i));
                if (userExpression.charAt(i) == '@')
                {
                    leftString = userExpression.substring(0, i);
                    operator = userExpression.substring(i, i+2);
                    rightString = userExpression.substring(i+2);

                    System.out.println("leftS: "+leftString);
                    System.out.println("oper: "+ operator);
                    System.out.println("rs: "+rightString);

                    int leftDecimalValue = Integer.parseInt(leftString,16);
                    int rightDecimalValue = Integer.parseInt(rightString,16);

                    return leftDecimalValue+operator+rightDecimalValue;
                }
                if (userExpression.charAt(i) == '×')
                {
                    leftString = userExpression.substring(0, i);
                    operator = userExpression.substring(i, i+1);
                    rightString = userExpression.substring(i+1);

                    System.out.println("leftS: "+leftString);
                    System.out.println("oper: "+ operator);
                    System.out.println("rs: "+rightString);

                    int leftDecimalValue = Integer.parseInt(leftString,16);
                    int rightDecimalValue = Integer.parseInt(rightString,16);

                    return leftDecimalValue+operator+rightDecimalValue;
                }
                if (userExpression.charAt(i) == '÷')
                {
                    leftString = userExpression.substring(0, i);
                    operator = userExpression.substring(i, i+1);
                    rightString = userExpression.substring(i+1);

                    System.out.println("leftS: "+leftString);
                    System.out.println("oper: "+ operator);
                    System.out.println("rs: "+rightString);

                    int leftDecimalValue = Integer.parseInt(leftString,16);
                    int rightDecimalValue = Integer.parseInt(rightString,16);

                    return leftDecimalValue+operator+rightDecimalValue;
                }
                if (userExpression.charAt(i) == '-')
                {
                    leftString = userExpression.substring(0, i);
                    operator = userExpression.substring(i, i+1);
                    rightString = userExpression.substring(i+1);

                    System.out.println("leftS: "+leftString);
                    System.out.println("oper: "+ operator);
                    System.out.println("rs: "+rightString);

                    int leftDecimalValue = Integer.parseInt(leftString,16);
                    int rightDecimalValue = Integer.parseInt(rightString,16);

                    return leftDecimalValue+operator+rightDecimalValue;
                }
                if (userExpression.charAt(i) == '+')
                {
                    leftString = userExpression.substring(0, i);
                    operator = userExpression.substring(i, i+1);
                    rightString = userExpression.substring(i+1);

                    System.out.println("leftS: "+leftString);
                    System.out.println("oper: "+ operator);
                    System.out.println("rs: "+rightString);

                    int leftDecimalValue = Integer.parseInt(leftString,16);
                    int rightDecimalValue = Integer.parseInt(rightString,16);

                    return leftDecimalValue+operator+rightDecimalValue;
                }

            }

        }

        return userExpression;
    }




    public void clearBTN(View view)
    {
        operationChecker = false;
        notOperationChecker = false;
        isOperationChecker = false;
        userInput.setText("");
        previousCalc.setText("");
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