package by.zubar.mikalai.pars.interpreter;

/**
 * Created by Mikalay Zubar on 12.11.2016.
 */
public class ExpressionSubstraction extends AbstractExpression {

    @Override
    public void interpret(Context context) {
        double n1 = context.popValue();
        double n2 = context.popValue();
        context.pushValue(n2 - n1);
    }
}
