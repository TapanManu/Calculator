package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.EmptyStackException;

public class Scientific extends AppCompatActivity {
    TextView tvResult;
    Button equals,exp,ln,log,sin,cos,tan,sinh,cosh,tanh;
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
        sinh = findViewById(R.id.btnsinh);
        cosh = findViewById(R.id.btncosh);
        tanh = findViewById(R.id.btntanh);
        Intent intent = getIntent();
        str= intent.getStringExtra("result");
        tvResult.setText(str);
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double result=0.0;
                Intent r = new Intent();
                try {
                    String eval = Functions.disp(str);
                    result = Double.parseDouble(Functions.disp(str));
                    r.putExtra("result",String.valueOf(result));
                    setResult(Activity.RESULT_OK,r);
                }
                catch(NullPointerException|NumberFormatException| EmptyStackException e) {
                    r.putExtra("error", "Invalid Expression");
                    setResult(Activity.RESULT_CANCELED,r);
                }
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
        sinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str="sinh("+str+")";
                value=1;
                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText(str);
            }
        });
        cosh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str="cosh("+str+")";
                value=1;
                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText(str);
            }
        });
        tanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str="tanh("+str+")";
                value=1;
                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText(str);
            }
        });

        }




}