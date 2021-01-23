package com.stack;

import java.util.Stack;

public class InfixEvaluationUsingStack {

    public static void main(String[] args) {

        String expression = "2+(5-((3*6)/2))";
       // String expression = "2+(5-3*6/2)";
       // String expression = "2+5";
        Stack<Character> operators =new Stack<>();
        Stack<Integer> operands =new Stack<>();

        for(int i=0;i<expression.length();i++){
           char ch = expression.charAt(i);

           if('(' == ch){
                operators.push(ch);
           }else if(Character.isDigit(ch)){
                operands.push(ch - '0'); // char to integer conversion
           }else if(')' == ch){
               //iterates till operator '(' is got and continue performing operation
               while(operators.peek() != '('){
                   char operator = operators.pop();
                    int value2 = operands.pop();
                    int value1 = operands.pop();

                    int result = operation(value1,value2,operator);
                    operands.push(result);
               }
              operators.pop();
           }else if('+' == ch || '-' == ch || '*' == ch || '/' == ch){

               // current operand let evaluate equalTo or greater operator
               while (operators.size() > 0 && operators.peek() != '(' &&
               precedence(ch) <= precedence(operators.peek())){
                   char operator = operators.pop();
                   int value2 = operands.pop();
                   int value1 = operands.pop();

                   int result = operation(value1,value2,operator);
                   operands.push(result);
               }

               // after completing equal to or greater operations finally it pushes itself
               operators.push(ch);
           }

        }

        // if expression ends and there are some operands remaining to be evaluated then this loop will run
        while(operators.size() != 0){
            char operator = operators.pop();
            int value2 = operands.pop();
            int value1 = operands.pop();

            int result = operation(value1,value2,operator);
            operands.push(result);
        }
        System.out.println("result is : "+operands.pop());
    }

    public static int precedence(char operator){
        if(operator == '+'){
            return 1;
        }else if(operator == '-'){
            return 1;
        }else if(operator == '*'){
            return 2;
        }else {
            return 2;
        }
    }

    public static int operation(int value1,int value2,char operator){
        int result = 0;
        switch(operator){
            case '+' :
                result = value1+value2;
                break;
            case '-' :
                result = value1-value2;
                break;
            case '*' :
                result = value1*value2;
                break;
            default:
                result = value1/value2;
        }
        return result;
    }
}
