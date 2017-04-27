package com.example.kamil.calcu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_main);
    }

    public void simple(View view) {
        Button button = (Button) findViewById(R.id.bSimple);
        Intent intent = new Intent(this, SimpleCalculator.class);
        startActivity(intent);
    }

    public void advanced(View view) {
        Button button  = (Button) findViewById(R.id.bAdvanced);
        Intent intent = new Intent(this, AdvancedCalculator.class);
        startActivity(intent);
    }

    public void about(View view) {
        Button button = (Button) findViewById(R.id.bAbout);
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void exitApp(View view) {
        Button button = (Button) findViewById(R.id.bExit);
        System.exit(0);

    }


}
