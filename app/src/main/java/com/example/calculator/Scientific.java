package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Scientific extends AppCompatActivity {
    TextView tvResult;
    Button equals,exp,ln,log,sin,cos,tan;
    String str;
    int value=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);
        tvResult = findViewById(R.id.tvResult2);
        equals= findViewById(R.id.btnequals2);
        //exp = findViewById(R.id.btnexp);
       // ln = findViewById(R.id.btnln);
        //log = findViewById(R.id.btnlog);
        sin = findViewById(R.id.btnsin);
        cos = findViewById(R.id.btncos);
        tan = findViewById(R.id.btntan);
        Intent intent = getIntent();
        str= intent.getStringExtra("result");
        tvResult.setText(str);
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double result=0.0;
                if(value==1){
                    //result = trigonometric();
                }
                //composite functions to be added
                //empty cases should be considered
                Intent r = new Intent();
                r.putExtra("result",String.valueOf(result));
                setResult(Activity.RESULT_OK,r);
                finish();
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str="sin("+str+")";
                value=1;
                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText(str);
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str="cos("+str+")";
                value=1;
                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText(str);
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str="tan("+str+")";
                value=1;
                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText(str);
            }
        });

        }




}