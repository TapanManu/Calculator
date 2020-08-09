package com.example.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Expression {
    static ArrayList<String> disp = new ArrayList<String>();
    static Stack<String> stack = new Stack<String>();
    public static boolean status=false;
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case 'x':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    static boolean isOperand(String op){
        return((op.equals("+"))||(op.equals("/"))||(op.equals("-"))||(op.equals("x"))||(op.equals("("))||(op.equals(")"))
                ||(op.equals("^")));
    }
    static double evaluatePostfix(ArrayList<String> disp) {
        Stack<Double> s = new Stack<Double>();
        // Scan all characters one by one

        for(String c:disp) {

            if(c.equals(" "))
                continue;
                // If the scanned character is an operand
                // (number here),extract the number
                // Push it to the stack.
            else if(!isOperand(c)) {
                double n = 0;
                if(!isOperand(c)) {
                    n=Double.parseDouble(c);
                }
                System.out.println(n);

                //push the number in stack
                s.push(n);
            }

            // If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else if(isOperand(c)){
                double val1 = s.pop();
                double val2 = s.pop();

                switch(c.charAt(0)){
                    case '+':
                        s.push(val2+val1);
                        break;

                    case '-':
                        s.push(val2- val1);
                        break;

                    case '/':
                        if(val1!=0)
                            s.push(val2/val1);
                        else {
                            status=true;
                            s.push(0d);
                        }
                        break;

                    case 'x':
                        s.push(val2*val1);
                        break;

                    case '^':
                        s.push(Math.pow(val1,val2));
                        break;
                }
            }

        }
        return s.pop();
    }
    static void postfix(String[] result){
        for(String r:result){
            if(!isOperand(r))
                disp.add(r);
            else if(r.equals("("))
                stack.push(r);
            else if (r.equals(")"))
            {
                while (!stack.isEmpty() && !(stack.peek().equals("(")))
                    disp.add(stack.pop());

                if (!stack.isEmpty() && !(stack.peek().equals("(")))
                    status=true; // invalid expression
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(r.charAt(0)) <= Prec(stack.peek().charAt(0))){
                    if(stack.peek().equals("("))
                        status=true;
                    disp.add(stack.pop());
                }
                stack.push(r);
            }
        }
        while (!stack.isEmpty()){
            if(stack.peek().equals("(")) {
                status=true;
            }
            disp.add(stack.pop());
        }
    }
    public static String resultDisp(String exp) {
        //String exp  = "2^3^2";
        if(disp.size()!=0){
            disp.clear();
            stack.clear();
        }
        String[] result = exp.split("(?<=[-(+x/)^])|(?=[-(+x/)^])");
        //System.out.println(Arrays.toString(result));
        postfix(result);
        if(!status)
            return String.valueOf(evaluatePostfix(disp));
        return null;
    }
}
