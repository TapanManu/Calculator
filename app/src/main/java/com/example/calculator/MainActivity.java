package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
            btnplus,btnminus,btnmult,btndiv,btnequals,
            btnclear,btndot,btnBack;
    Double  num1,num2,result;
    boolean status;
    String s="",s1,s2;
    char op;
    DecimalFormat df = new DecimalFormat("#.####");
    TextToSpeech t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        tvResult=findViewById(R.id.tvResult);
        tvResult.setVisibility(View.VISIBLE);
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
                tvResult.setVisibility(View.VISIBLE);
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
                if(status) {
                    tvResult.setVisibility(View.INVISIBLE);
                    status = false;
                }
                else
                    tvResult.setVisibility(View.VISIBLE);
                    tvResult.setText(s);
                    resultSpeaker(s);
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
    public void onResume(){
        super.onResume();
        status = false;
        tvResult.setVisibility(View.VISIBLE);
    }
    public String add(){
        int operand = s.indexOf("+");
        s1=s.substring(0,operand);
        s2=s.substring(operand+1,s.length());
       // operationSpeaker(s1+"plus"+s2);
        num1=Double.parseDouble(s1);
        num2=Double.parseDouble(s2);
        result=num1+num2;
        return String.valueOf(df.format(result));
    }
    public String sub(){
        int operand = s.indexOf("-");
        s1=s.substring(0,operand);
        s2=s.substring(operand+1,s.length());
        //operationSpeaker(s1+"minus"+s2);
        num1=Double.parseDouble(s1);
        num2=Double.parseDouble(s2);
        result=num1-num2;
        return String.valueOf(df.format(result));
    }
    public String mult(){
        int operand = s.indexOf("x");
        s1=s.substring(0,operand);
        s2=s.substring(operand+1,s.length());
        //operationSpeaker(s1+"into"+s2);
        num1=Double.parseDouble(s1);
        num2=Double.parseDouble(s2);
        result=num1*num2;
        return String.valueOf(df.format(result));
    }
    public String div(){
        int operand = s.indexOf("/");
        s1=s.substring(0,operand);
        s2=s.substring(operand+1,s.length());
        //operationSpeaker(s1+"by"+s2);
        num1=Double.parseDouble(s1);
        num2=Double.parseDouble(s2);
        if(num2==0){
            status=true;
            return "cannot divide by zero('press C to continue')";
        }
        result=num1/num2;
        return String.valueOf(df.format(result));
    }
    private void init() {
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                    //t1.setPitch(0.5f);
                }
            }
        });
    }
    private void greetings(){
        String Greetings = "Hi all, Welcome to your calc app!";
        t1.speak(Greetings,TextToSpeech.QUEUE_FLUSH,null,null);
    }
    private void resultSpeaker(String result){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            t1.speak(result,TextToSpeech.QUEUE_FLUSH,null,null);
        } else {
            t1.speak(result, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
