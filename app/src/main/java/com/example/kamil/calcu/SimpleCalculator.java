package com.example.kamil.calcu;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SimpleCalculator extends AppCompatActivity {

    private TextView calc;
    private double val1;
    private double val2;
    private String symbol;
    private boolean dotInside;
    private boolean equalActive;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_simple_calculator);
       calc = (TextView) findViewById(R.id.tCalculator);

       calc.setText("");
        symbol = "";
        val1 = Double.NaN;
        val2 = Double.NaN;
        dotInside = false;
        equalActive = true;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putDouble("val1", val1);
        savedInstanceState.putDouble("val2", val2);
        savedInstanceState.putString("symbol", symbol);
        savedInstanceState.putBoolean("dot", dotInside);
        savedInstanceState.putBoolean("equal", equalActive);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        val1 = savedInstanceState.getDouble("val1");
        val2 = savedInstanceState.getDouble("val2");
        symbol = savedInstanceState.getString("symbol");
        dotInside = savedInstanceState.getBoolean("dot");
        equalActive = savedInstanceState.getBoolean("equal");
    }

    public boolean isANumber() {
        if (calc.getText().length() > 0) {
            String buffer = (calc.getText().toString());
            if (buffer.matches("([E0-9.-])+")) {
                return true;
            }
        } return false;
    }

    public void setDot(View view){
        if(dotInside == false && calc.getText().length() > 0 && isANumber()) {
            String buf = calc.getText().toString();
            if(buf.contains(".")){
                dotInside = true;
                return;
            } else {
                dotInside = true;
                calc.append(".");
            }
        }
    }

    public void setNumber(View view) {
        Button button = (Button) view;
        calc.append(button.getText());
    }

    public void clearScreen(View view) {
        calc.setText("");
        clear();
    }

    public void clear(){
        symbol = "";
        val1 = Double.NaN;
        val2 = Double.NaN;
        dotInside = false;
        equalActive = true;
    }

    public void changeSign(View view) {

       String buf = calc.getText().toString();
        if(buf.length() != 0) {
            if(buf.startsWith("-"))
                calc.setText(buf.substring(1, buf.length()));
            else
                calc.setText("-" + buf);
        }
    }

    public void backSpace(View view) {

        String buf = calc.getText().toString();
        if(buf.length() != 0) {
           if(buf.endsWith("."))
               dotInside = false;
            calc.setText(buf.substring(0, buf.length() - 1));

        }

    }

    public void setOperation(View view) {
        Button button = (Button) view;

        if(calc.getText().length() != 0 && isANumber()) {

            symbol = button.getText().toString();
            val1 = Double.parseDouble(calc.getText().toString());
            calc.setText("");
            dotInside = false;
        } else {
            Toast.makeText(this, "No input", Toast.LENGTH_SHORT).show();
        }
    }

    public  void useEqual(View view) {
        if(!Double.isNaN(val1)) {
            if (calc.getText().length() != 0 && isANumber()) {
                val2 = Double.parseDouble(calc.getText().toString() );

                    switch (symbol) {
                        case "+":
                            val1 = val1 + val2;

                            break;
                        case "-":
                            val1 = val1 - val2;

                            break;
                        case "*":
                            val1 = val1 * val2;

                            break;
                        case "/":
                            if (val2 != 0) {
                                val1 = val1 / val2;

                            }else {
                                Toast.makeText(this, "Do Not Divide By 0", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            break;
                    }

                calc.setText(String.valueOf(val1));
                clear();
            } else {
                calc.setText(String.valueOf(val1));
                clear();
            }
        } else {
            Toast.makeText(this, "No input", Toast.LENGTH_SHORT).show();
            clear();
        }
    }

}

