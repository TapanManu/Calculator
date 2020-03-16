package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
            btnplus,btnminus,btnmult,btndiv,btnequals,
            btnclear,btndot,btnBack;
    Double  num1,num2,result;
    String s="",s1,s2;
    char op;
    DecimalFormat df = new DecimalFormat("#.####");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult=findViewById(R.id.tvResult);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn0=findViewById(R.id.btn0);
        btnplus=findViewById(R.id.btnplus);
        btnminus=findViewById(R.id.btnminus);
        btnmult=findViewById(R.id.btnmult);
        btndiv=findViewById(R.id.btndiv);
        btnequals=findViewById(R.id.btnequals);
        btnclear=findViewById(R.id.btnclear);
        btndot=findViewById(R.id.btndot);
        btnBack=findViewById(R.id.btnBack);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s =s+"1";
                tvResult.setText(s);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"2";
                tvResult.setText(s);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"3";
                tvResult.setText(s);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"4";
                tvResult.setText(s);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"5";
                tvResult.setText(s);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"6";
                tvResult.setText(s);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"7";
                tvResult.setText(s);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"8";
                tvResult.setText(s);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"9";
                tvResult.setText(s);
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"0";
                tvResult.setText(s);
            }
        });
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"+";
                op ='+';
                tvResult.setText(s);
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"-";
                op ='-';
                tvResult.setText(s);
            }
        });
        btnmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"x";
                op='*';
                tvResult.setText(s);
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"/";
                op='/';
                tvResult.setText(s);
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s="";
                tvResult.setText(s);
            }
        });
        btnequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(op) {
                    case '+':s=add();
                             break;
                    case '-':s=sub();
                            break;
                    case '*':s=mult();
                            break;
                    case '/':s=div();
                            break;
                    default:
                        tvResult.setText(s);
                }
                tvResult.setText(s);
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s.equals(""))
                    s="0";
                s=s+".";
                tvResult.setText(s);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!s.equals("")) {
                    s = s.substring(0, s.length() - 1);
                    tvResult.setText(s);
                }
            }
        });

    }
    public String add(){
        int operand = s.indexOf("+");
        s1=s.substring(0,operand);
        s2=s.substring(operand+1,s.length());
        num1=Double.parseDouble(s1);
        num2=Double.parseDouble(s2);
        result=num1+num2;
        return String.valueOf(df.format(result));
    }
    public String sub(){
        int operand = s.indexOf("-");
        s1=s.substring(0,operand);
        s2=s.substring(operand+1,s.length());
        num1=Double.parseDouble(s1);
        num2=Double.parseDouble(s2);
        result=num1-num2;
        return String.valueOf(df.format(result));
    }
    public String mult(){
        int operand = s.indexOf("x");
        s1=s.substring(0,operand);
        s2=s.substring(operand+1,s.length());
        num1=Double.parseDouble(s1);
        num2=Double.parseDouble(s2);
        result=num1*num2;
        return String.valueOf(df.format(result));
    }
    public String div(){
        int operand = s.indexOf("/");
        s1=s.substring(0,operand);
        s2=s.substring(operand+1,s.length());
        num1=Double.parseDouble(s1);
        num2=Double.parseDouble(s2);
        if(num2==0){
            return "cannot divide by zero('press C to continue')";
        }
        result=num1/num2;
        return String.valueOf(df.format(result));
    }
}
