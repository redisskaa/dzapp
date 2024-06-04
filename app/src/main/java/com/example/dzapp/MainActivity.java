package com.example.dzapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private int operand1 = 0;
    private int operand2 = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonAdd = findViewById(R.id.buttonPlus);
        Button buttonSubtract = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonUmnojenie);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonRavno);
        Button buttonClear = findViewById(R.id.buttonClear);

        button0.setOnClickListener(v -> numberPressed("0"));
        button1.setOnClickListener(v -> numberPressed("1"));
        button2.setOnClickListener(v -> numberPressed("2"));
        button3.setOnClickListener(v -> numberPressed("3"));
        button4.setOnClickListener(v -> numberPressed("4"));
        button5.setOnClickListener(v -> numberPressed("5"));
        button6.setOnClickListener(v -> numberPressed("6"));
        button7.setOnClickListener(v -> numberPressed("7"));
        button8.setOnClickListener(v -> numberPressed("8"));
        button9.setOnClickListener(v -> numberPressed("9"));

        buttonAdd.setOnClickListener(v -> operatorPressed("+"));
        buttonSubtract.setOnClickListener(v -> operatorPressed("-"));
        buttonMultiply.setOnClickListener(v -> operatorPressed("*"));
        buttonDivide.setOnClickListener(v -> operatorPressed("/"));
        buttonEquals.setOnClickListener(v -> calculate());
        buttonClear.setOnClickListener(v -> clear());
    }

    private void numberPressed(String number) {
        resultTextView.setText(number);
    }

    private void operatorPressed(String op) {
        operand1 = Integer.parseInt(resultTextView.getText().toString());
        operator = op;
        resultTextView.setText("");
    }

    private void calculate() {
        operand2 = Integer.parseInt(resultTextView.getText().toString());
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
        }
        resultTextView.setText(String.valueOf(result));
    }

    private void clear() {
        resultTextView.setText("0");
        operand1 = 0;
        operand2 = 0;
        operator = "";
    }
}
