package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class sample extends AppCompatActivity {

    TextView num,cof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        num =findViewById(R.id.textView2);
        cof =findViewById(R.id.textView3);
        Intent intent = getIntent();
        String numS = intent.getStringExtra("numa");
        String cofS = intent.getStringExtra("cofa");
        int i = Integer.parseInt(numS);
        i--;

        cof.setText(cofS);
    }
}