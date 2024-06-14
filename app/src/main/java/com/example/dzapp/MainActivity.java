package com.example.dzapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private int operand1 = 0;
    private int operand2 = 0;
    private String operator = "";
    EditText editText;
    Button button0, button1, button2, button3, button4, button5,
            button6, button7, button8,
            button9, buttonAdd, buttonSubtract,
            buttonMultiply, buttonDivide,
            buttonEquals, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.buttonPlus);
        buttonSubtract = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonUmnojenie);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEquals = findViewById(R.id.buttonRavno);
        buttonClear = findViewById(R.id.buttonClear);

        button0.setOnClickListener(v -> {
            numberPressed("0");
        });
        button1.setOnClickListener(v -> {
            numberPressed("1");
        });
        button2.setOnClickListener(v -> {
            numberPressed("2");
        });
        button3.setOnClickListener(v -> {
            numberPressed("3");
        });
        button4.setOnClickListener(v -> {
            numberPressed("4");
        });
        button5.setOnClickListener(v -> {
            numberPressed("5");
        });
        button6.setOnClickListener(v -> {
            numberPressed("6");
        });
        button7.setOnClickListener(v -> {
            numberPressed("7");
        });
        button8.setOnClickListener(v -> {
            numberPressed("8");
        });
        button9.setOnClickListener(v -> {
            numberPressed("9");
        });

        buttonAdd.setOnClickListener(v -> {
            operatorPressed("+");
        });
        buttonSubtract.setOnClickListener(v -> operatorPressed("-"));
        buttonMultiply.setOnClickListener(v -> operatorPressed("*"));
        buttonDivide.setOnClickListener(v -> operatorPressed("/"));
        buttonEquals.setOnClickListener(v -> {
            calculate();
            Log.d("SergeyTag", "buttonClick");
        });
        buttonClear.setOnClickListener(v -> clear());
    }

    private void numberPressed(String number) {

        String ed = editText.getText().toString();
        Log.d("SergeyTag", "numberPressed");
        if(editText.length() > 7){
            editText.setTextSize(75);
        }

        if (ed.equals("0")){
            ed = "";
            editText.setText(ed);
        }

        if (number.length() >= 1){
            editText.append(number);
        }
    }

    private void operatorPressed(String op) {
        operand1 = Integer.parseInt(editText.getText().toString());
        operator = op;
        String s = editText.getText().toString() + " " + op;
        editText.setText(s);
        Log.d("SergeyTag", "operatorPressed");
    }

    private void calculate() {
        String text =  editText.getText().toString();
        String[] parts = text.split("[+]");

        for (String part : parts) {
            System.out.println(part);
        }

        Log.d("SergeyTag", "calculate " + Integer.parseInt(editText.getText().toString()));
        operand2 = Integer.parseInt(editText.getText().toString());
        int result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            case "=":
                break;
        }
        editText.setText(String.valueOf(result));
    }

    private void clear() {
        editText.setTextSize(80);
        editText.setText("0");
        operand1 = 0;
        operand2 = 0;
        operator = "";
    }
}
