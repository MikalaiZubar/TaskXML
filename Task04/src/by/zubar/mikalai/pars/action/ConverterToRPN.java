package by.zubar.mikalai.pars.action;

import java.util.Stack;

/**
 * Created by Mikalay Zubar on 11.11.2016.
 */
public class ConverterToRPN {
    public static String convert(String lexeme){
        String expression = lexeme;
        expression = scanForIncrement(expression);
        Stack<Character> operators = new Stack<>();
        StringBuilder rpn = new StringBuilder();
        for(int i=0; i<expression.length(); i++){
            char symbol = expression.charAt(i);
            switch (symbol){
                    case '(':
                        operators.push(symbol);
                        break;
                    case ')':

                        while (operators.peek() != '('){
                            rpn.append(operators.pop());
                            rpn.append(" ");
                        }
                        operators.pop();  //remove ( from stack
                        break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        if(!operators.empty() && getPriority(symbol) <= getPriority(operators.peek())){
                            rpn.append(operators.pop());
                            rpn.append(" ");
                        }
                        operators.push(symbol);
                        break;
                    default:
                        rpn.append(symbol);
                        if(i<expression.length()-1 && !Character.isDigit(expression.charAt(i+1))){
                            rpn.append(" ");
                        }
                        break;
                }
        }
        while (!operators.empty()){
            rpn.append(" ");
            rpn.append(operators.pop());
        }
        return rpn.toString();
    }

     private static int getPriority(char symbol)
    {
        switch (symbol)
        {
            case '(':
            case ')': return 0;
            case '+':
            case '-': return 2;
            case '*':
            case '/': return 3;
            default: return 4;
        }
    }

    /*
       looks fo increment or decrement in math expression
       for there calculating
       also looks fo useless sings and delete them
     */

    public static String scanForIncrement(String lexeme){
        StringBuilder newLexeme = new StringBuilder();
        int minPartLength = 3;
        char last = lexeme.charAt(lexeme.length()-1);
        char preLast = lexeme.charAt(lexeme.length()-2);
        //deleting last useless sing in expression if it's not increment/decrement
        if(last == '+' && preLast != '+' || last == '-' && preLast != '-'
                || last == '*' || last == '/'){
            lexeme = lexeme.substring(0, lexeme.length()-1);
        }
        //adding 0 before negative value in the beginning of expression
        if(lexeme.charAt(0)=='(' && !Character.isDigit(lexeme.charAt(1))){
            lexeme = "(0"+lexeme.substring(1);
        }
        for(int i=0; i<lexeme.length(); i++){
            if(lexeme.length()-i >= minPartLength) {
                String part = lexeme.substring(i, i + 3);
                if (Character.isDigit(part.charAt(0)) && part.charAt(1) == '+' && part.charAt(2) == '+') {
                    int n = Integer.parseInt(String.valueOf(part.charAt(0)));
                    newLexeme.append(String.valueOf(n));
                    i += 2;
                } else if (Character.isDigit(part.charAt(0)) && part.charAt(1) == '-' && part.charAt(2) == '-') {
                    int n = Integer.parseInt(String.valueOf(part.charAt(0)));
                    newLexeme.append(String.valueOf(n));
                    i += 2;
                } else if (part.charAt(0) == '-' && part.charAt(1) == '-' && Character.isDigit(part.charAt(2))) {
                    int n = Integer.parseInt(String.valueOf(part.charAt(2))) - 1;
                    newLexeme.append(String.valueOf(n));
                    i += 2;
                } else if (part.charAt(0) == '+' && part.charAt(1) == '+' && Character.isDigit(part.charAt(2))) {
                    int n = Integer.parseInt(String.valueOf(part.charAt(2))) + 1;
                    newLexeme.append(String.valueOf(n));
                    i += 2;
                } else {
                    newLexeme.append(part.charAt(0));
                }
            }else {
                newLexeme.append(lexeme.charAt(i));
            }
        }
        return newLexeme.toString();
    }
}
