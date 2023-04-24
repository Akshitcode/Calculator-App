package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private enum  OPERATOR {
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }
    TextView txtCalculations;
    TextView txtResults;

    //Instance Variables

    private String currentNumber;
    private String stringNumberLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationsResult;
    private String calculationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationsResult = 0;
        calculationsString = "";

        txtCalculations = findViewById(R.id.txtCalculations);
        txtResults = findViewById(R.id.txtResults);

        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSubtract).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(@NonNull View v) {

        if(v.getId() == R.id.btnEqual) {
            operatorIsTapped(OPERATOR.EQUAL);
        }
        else if(v.getId() == R.id.btn7) {
            numberIsTapped(7);
        }
        else if(v.getId() == R.id.btn8) {
            numberIsTapped(8);
        }
        else if(v.getId() == R.id.btn9) {
            numberIsTapped(9);
        }else if(v.getId() == R.id.btnPlus) {
            operatorIsTapped(OPERATOR.PLUS);
            calculationsString += " + ";
        }
        else if(v.getId() == R.id.btn4) {
            numberIsTapped(4);
        }
        else if(v.getId() == R.id.btn5) {
            numberIsTapped(5);
        }
        else if(v.getId() == R.id.btn6) {
            numberIsTapped(6);
        }
        else if(v.getId() == R.id.btnSubtract) {
            operatorIsTapped(OPERATOR.SUBTRACT);
            calculationsString += " - ";
        }
        else if(v.getId() == R.id.btn1) {
            numberIsTapped(1);
        }
        else if(v.getId() == R.id.btn2) {
            numberIsTapped(2);
        }
        else if(v.getId() == R.id.btn3) {
            numberIsTapped(3);
        }
        else if(v.getId() == R.id.btnMultiply) {
            operatorIsTapped(OPERATOR.MULTIPLY);
            calculationsString += " * ";
        }
        else if(v.getId() == R.id.btnClear) {
            clearTapped();
        }
        else if(v.getId() == R.id.btn0) {
            numberIsTapped(0);
        }
        else if(v.getId() == R.id.btnDivide) {
            operatorIsTapped(OPERATOR.DIVIDE);
            calculationsString += " / ";
        }

        txtCalculations.setText(calculationsString);
    }
    private void numberIsTapped(int tappedNumber) {
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResults.setText(currentNumber);
        calculationsString = currentNumber;
        txtCalculations.setText(calculationsString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator) {
        if( currentOperator!= null  ) {

            if (currentNumber != "") {

                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {
                    case PLUS:
                        calculationsResult = Integer.parseInt(stringNumberLeft) +
                                Integer.parseInt(stringNumberAtRight);
                        break;

                    case DIVIDE:
                        calculationsResult = Integer.parseInt(stringNumberLeft) /
                                Integer.parseInt(stringNumberAtRight);
                        break;

                    case MULTIPLY:
                        calculationsResult = Integer.parseInt(stringNumberLeft) *
                                Integer.parseInt(stringNumberAtRight);
                        break;

                    case SUBTRACT:
                        calculationsResult = Integer.parseInt(stringNumberLeft) -
                                Integer.parseInt(stringNumberAtRight);
                        break;
                }

                stringNumberLeft = String.valueOf(calculationsResult);
                txtResults.setText(stringNumberLeft);
                calculationsString = stringNumberLeft;
            }
        }else {
            stringNumberLeft = currentNumber;
            currentNumber="";
        }
        currentOperator = tappedOperator;
    }
    private void clearTapped() {

        stringNumberLeft = "";
        stringNumberAtRight = "";
        calculationsResult= 0;
        currentNumber= "";
        currentOperator = null;
        txtResults.setText("0");
        calculationsString = "0";
    }
}