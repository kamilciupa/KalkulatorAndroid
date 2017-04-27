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
    }

    /*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            this.setContentView(R.layout.activity_simple_calculator_hor);
       else
            this.setContentView(R.layout.activity_simple_calculator);


    }
*/

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
        symbol = "";
        val1 = Double.NaN;
        val2 = Double.NaN;
        dotInside = false;
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
            Toast.makeText(this, "No input", Toast.LENGTH_LONG).show();
        }
    }

    public  void useEqual(View view) {
        if(!Double.isNaN(val1)) {
            if (calc.getText().length() != 0 && isANumber()) {
                val2 = Double.parseDouble(calc.getText().toString() );

                switch(symbol) {
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
                        if(val2 != 0)
                            val1 = val1 / val2;
                        else {
                            Toast.makeText(this, "Do Not Divide By 0", Toast.LENGTH_LONG).show();
                            return;
                        }
                        break;
                }

                calc.setText(String.valueOf(val1));
            } else {
                calc.setText(String.valueOf(val1));
            }
        } else {
            Toast.makeText(this, "No input", Toast.LENGTH_LONG).show();
        }
    }

}

