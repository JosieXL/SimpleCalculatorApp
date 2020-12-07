package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Screen;
    boolean isNewOp = true;
    String op = "+";
    String oldNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Screen = findViewById(R.id.screen);
    }

    @SuppressLint("NonConstantResourceId")
    public void numberEvent(View view) {
        if (isNewOp) {
            Screen.setText("");
        }
        isNewOp = false;
        String number = Screen.getText().toString();
        switch (view.getId()) {
            case R.id.zero:
                number += "0";
                break;
            case R.id.one:
                number += "1";
                break;
            case R.id.two:
                number += "2";
                break;
            case R.id.three:
                number += "3";
                break;
            case R.id.four:
                number += "4";
                break;
            case R.id.five:
                number += "5";
                break;
            case R.id.six:
                number += "6";
                break;
            case R.id.seven:
                number += "7";
                break;
            case R.id.eight:
                number += "8";
                break;
            case R.id.nine:
                number += "9";
                break;
            case R.id.dot:
                number += ".";
                break;
            case R.id.Sign:
                if (number.contains("-")) {
                    number = number.substring(1);
                }
                else {
                    number = "-" + number;
                }
                break;
        }
        Screen.setText(number);
    }

    @SuppressLint("NonConstantResourceId")
    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = Screen.getText().toString();
        switch (view.getId()) {
            case R.id.divide:
                op = "÷";
                break;
            case R.id.multiply:
                op = "x";
                break;
            case R.id.minus:
                op = "-";
                break;
            case R.id.plus:
                op = "+";
                break;
        }
    }


    @SuppressLint("SetTextI18n")
    public void equalEvent(View view) {
        String newNumber = Screen.getText().toString();
        double result = 0.0;
        switch (op) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "x":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "÷":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        Screen.setText(result+"");
    }

    public void acEvent(View view) {
        Screen.setText("0");
        isNewOp = true;
    }

    @SuppressLint("SetTextI18n")
    public void percentEvent(View view) {
        double num = Double.parseDouble(Screen.getText().toString()) / 100;
        Screen.setText(num + "");
        isNewOp = true;
    }
}
