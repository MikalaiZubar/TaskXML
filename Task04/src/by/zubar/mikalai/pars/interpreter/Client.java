package by.zubar.mikalai.pars.interpreter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mikalay Zubar on 12.11.2016.
 */
public class Client {
    private ArrayList<AbstractExpression> expressionList;
    private ExpressionSum sum = new ExpressionSum();
    private ExpressionSubstraction substraction = new ExpressionSubstraction();
    private ExpressionDivide divide = new ExpressionDivide();
    private ExpressionMultiply multiply = new ExpressionMultiply();

    public Client(String expression){
        expressionList = new ArrayList<>();
        parse(expression);
    }

    public void parse(String expression){
        for(String str : expression.split(" ")){

            switch (str){
                case "+":
                    expressionList.add(sum);
                    break;
                case "-":
                    expressionList.add(substraction);
                    break;
                case "*":
                    expressionList.add(multiply);
                    break;
                case "/":
                    expressionList.add(divide);
                    break;
                default:
                    Scanner scan = new Scanner(str);
                    if(scan.hasNextInt()){
                        expressionList.add(new ExpressionNumber(scan.nextInt()));
                    }
            }
        }
    }

    public Double calculate(){
        Context context = new Context();
        for (AbstractExpression expression : expressionList){
            expression.interpret(context);
        }
        return context.popValue();
    }
}
