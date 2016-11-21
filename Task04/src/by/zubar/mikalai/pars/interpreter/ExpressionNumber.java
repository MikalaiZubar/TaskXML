package by.zubar.mikalai.pars.interpreter;

/**
 * Created by Mikalay Zubar on 12.11.2016.
 */
public class ExpressionNumber extends AbstractExpression {
    private double number;

    public ExpressionNumber(double number){
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
