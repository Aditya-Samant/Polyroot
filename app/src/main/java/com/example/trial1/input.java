package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class input extends AppCompatActivity {
    String [] arr = new String[10];
    TextView textView;
    Integer n;
    EditText de,c,ae,be;
    Button button1,okay,calc,calcn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        de = findViewById(R.id.degree);
        ae = findViewById(R.id.textView6);
        be = findViewById(R.id.textView5);
        c = findViewById(R.id.coefficient);
        button1 = findViewById(R.id.button1);
        okay = findViewById(R.id.okay);
        calc = findViewById(R.id.calcB);
        calcn = findViewById(R.id.calcN);
        textView = findViewById(R.id.textView4);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String x= de.getText().toString();
                n = Integer.parseInt(x);
                refresh();
            }

        });
        okay.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(n==-1) {
                textView.setText("please click on calculate");
            }
            else {

                arr[n]= c.getText().toString();
                n--;
                if(n!=-1)
                {
                    refresh();
                }

            }
            }
        }));
        calc.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num =de.getText().toString();
                String cof =c.getText().toString();
                String aof =ae.getText().toString();
                String bof =be.getText().toString();
                Intent intent = new Intent(input.this,Activity2.class);
                intent.putExtra("numa",num);
                intent.putExtra("cofa",cof);
                intent.putExtra("aof",aof);
                intent.putExtra("bof",bof);
                intent.putExtra("arr",arr);

                startActivity(intent);
            }
        }));
        calcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num =de.getText().toString();
                String cof =c.getText().toString();
                String aof =ae.getText().toString();
                String bof =be.getText().toString();
                Intent intent = new Intent(input.this,newtonrap.class);
                intent.putExtra("numa",num);
                intent.putExtra("cofa",cof);
                intent.putExtra("aof",aof);
                intent.putExtra("bof",bof);
                intent.putExtra("arr",arr);
                startActivity(intent);
            }
        });

    }
    public void refresh(){
        textView.setText("Enter coefficient of x^"+n);
        c.getText().clear();
    }
}