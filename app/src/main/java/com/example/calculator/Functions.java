package com.example.calculator;

import java.util.Arrays;
import java.util.Stack;

public class Functions {
    boolean func=true;
    static Stack<String> stack = new Stack<String>();
    private static double tri(double d,String in){
        if(in.equals("sinh"))
            return Math.sinh(d);
        else if(in.equals("cosh"))
            return Math.cosh(d);
        else if(in.equals("tanh"))
            return Math.tanh(d);
        else if(in.equals("sin"))
            return Math.sin(d);
        else if(in.equals("tan"))
            return Math.tan(d);
        else if(in.equals("cos"))
            return Math.cos(d);
        return -1000000.000;

    }
    private static boolean trigonos(String str){
        return (str.equals("sin")||str.equals("cos")||str.equals("tan")||str.equals("sinh")
                ||str.equals("cosh")||str.equals("tanh"));
    }
    public static String evalExp(String exp){   //recursive function to evaluate functions
        int paracount=0;
        if(stack.size()==0)
            return exp;
        String inner = stack.peek();
        System.out.println("inner:"+inner); //inner trigonometric function
        //identifying inner arithmetic expression
        String arithmetic="";
        double arith=0.0;
        int innerparanthesis_pos = exp.indexOf(inner)+inner.length();
        int i=innerparanthesis_pos;
        char ch;
        System.out.println("length:"+exp.length());
        while(paracount>=0 && (i<=exp.length()-1)){
            System.out.println(paracount + " "+ i);
            ch = exp.charAt(i);
            System.out.println("exp:"+ch);
            if(ch=='(')
                paracount++;
            if(ch==')')
                paracount--;
            arithmetic=arithmetic+ch;
            i++;

            if(paracount==0)
                break;
        }
        if(paracount!=0) {
            System.out.println("invalid expression");
            return null;
        }
        else
            arith = Double.parseDouble(Expression.resultDisp(arithmetic));
        String value = String.valueOf(tri(arith,inner));
        exp = exp.substring(0,exp.indexOf(inner))+value+exp.substring(i,exp.length());
        //System.out.println(exp);
        stack.pop();
        return evalExp(exp);//trigonometric evaluation

    }
    public static String disp(String exp){
        String br[] = exp.split("[(]");
        //System.out.println(Arrays.toString(br));
        //use recursive approach for better results!!!
        for(String b:br){
            if(trigonos(b)){
                stack.push(b); //identifying functions from outer to inner
            }
        }
        return (evalExp(exp));
    }
}
