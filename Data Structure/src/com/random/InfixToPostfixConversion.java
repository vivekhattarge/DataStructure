package com.random;

import java.util.Stack;

public class InfixToPostfixConversion {
    public static void main(String[] args) {

        String inputSTring = "A+B*C+D";

        String postfixString = infixToPostfix(inputSTring);
        System.out.println("Postfix is : "+postfixString);
    }

    private static String infixToPostfix(String inputSTring) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char letter : inputSTring.toCharArray()){
            if( (letter <= 'z' && letter >= 'a') || (letter <= 'Z' && letter >= 'A')){
               result.append(letter);
            }else{
                    while(!stack.isEmpty() &&  (checkPrecendence(letter) < checkPrecendence(stack.peek()) ||
                            checkPrecendence(letter) == checkPrecendence(stack.peek()))){
                        result.append(stack.pop());
                    }
                stack.push(letter);
        }
    }
        while (!stack.isEmpty()){
            result.append(stack.peek());
            stack.pop();
        }
        return result.toString();
    }

    private static int checkPrecendence(char letter) {

        if(letter == '*' || letter == '/'){
            return 2;
        }else if(letter == '+' || letter == '-'){
            return 1;
        }
        return 0;
    }
}
