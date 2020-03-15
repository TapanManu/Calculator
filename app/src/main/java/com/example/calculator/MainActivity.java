package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    EditText etCalc;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnplus,btnminus,btnmult,btndiv,btnequals,btnclear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult.findViewById(R.id.tvResult);
        etCalc.findViewById(R.id.etCalc);
        btn1.findViewById(R.id.btn1);
        btn2.findViewById(R.id.btn2);
        btn3.findViewById(R.id.btn3);
        btn4.findViewById(R.id.btn4);
        btn5.findViewById(R.id.btn5);
        btn6.findViewById(R.id.btn6);
        btn7.findViewById(R.id.btn7);
        btn8.findViewById(R.id.btn8);
        btn9.findViewById(R.id.btn9);
        btn0.findViewById(R.id.btn0);
        btnplus.findViewById(R.id.btnplus);
        btnminus.findViewById(R.id.btnminus);
        btnmult.findViewById(R.id.btnmult);
        btndiv.findViewById(R.id.btndiv);
        btnequals.findViewById(R.id.btnequals);
        btnclear.findViewById(R.id.btnclear);
    }
}
