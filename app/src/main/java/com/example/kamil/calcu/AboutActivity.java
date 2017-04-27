package com.example.kamil.calcu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_about);
    }
}
