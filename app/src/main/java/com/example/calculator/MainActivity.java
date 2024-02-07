package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView calculation, result;
    String input, output, newOutput;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button add;
    Button mul;
    Button sub;
    Button div;
    Button expo;
    Button dot;
    Button equal;
    Button Clr;
    Button mod;
    Button AC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = findViewById(R.id.calculate);
        result = findViewById(R.id.result);

        one = findViewById(R.id.one);
        zero =findViewById(R.id.zero);
        two = findViewById(R.id.two);
        three =findViewById(R.id.tri);
        four =findViewById(R.id.four);
        five =findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven =findViewById(R.id.seven);
        eight =findViewById(R.id.eight);
        nine =findViewById(R.id.nine);
        add = findViewById(R.id.plus);
        sub =findViewById(R.id.minus);
        mul =findViewById(R.id.mul);
        div =findViewById(R.id.div);
        equal =findViewById(R.id.equ);
        calculation =findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        Clr = findViewById(R.id.Clr);
        expo = findViewById(R.id.exponent);
        dot = findViewById(R.id.dot);
        mod = findViewById(R.id.mod);
        AC = findViewById(R.id.AC);

    }
    public void onButtonClicked(View view) {

        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "AC":
                input = null;
                output=null;
                newOutput=null;
                result.setText("");
                break;

            case "Clr":
                if (input != null && !input.isEmpty()) {
                    input = input.substring(0, input.length() - 1);
                }
                else if (newOutput != null && !newOutput.isEmpty()) {
                    newOutput = newOutput.substring(0, newOutput.length() - 1);
                }
                result.setText(input);
                break;

            case "^":
                solve();
                input += "^";
                break;
            case "*":
                solve();
                input += "*";
                break;

            case "=":
                solve();
                break;

            case "%":
                input += "%";
                double d = Double.parseDouble(calculation.getText().toString()) / 100;
                result.setText(String.valueOf(d));
                break;

            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")) {
                    solve();
                }
                input += data;
        }
        calculation.setText(input);
    }

    @SuppressLint("SetTextI18n")
    private void solve() {
        if (input.split("\\+").length == 2) {
            String[] numbers = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                result.setText(newOutput);
                input = d +" ";
            }catch (Exception e) {
                result.setText(e.getMessage());
            }
        }

        if (input.split("\\*").length == 2) {
            String[] numbers = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                result.setText(newOutput);
                input = d +" ";
            }catch (Exception e){
                result.setText(e.getMessage());
            }
        }
        if (input.split("/").length == 2) {
            String[] numbers = input.split("/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                result.setText(newOutput);
                input = d +" ";
            }catch (Exception e){
                result.setText(e.getMessage());
            }
        }
        if (input.split("\\^").length == 2) {
            String[] numbers = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                result.setText(newOutput);
                input = d +" ";
            }catch (Exception e){
                result.setText(e.getMessage());
            }
        }
        if (input.split("-").length == 2) {
            String[] numbers = input.split("-");
            try {
                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    result.setText("-" + newOutput);
                    input = d +" ";
                }
                else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    result.setText(newOutput);
                    input = d + " ";
                }
            }catch (Exception e){
                result.setText(e.getMessage());
            }
        }
    }

    private String cutDecimal(String number){
        String[] n = number.split("\\.");
        if (n.length >1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }

}