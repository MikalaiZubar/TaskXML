package by.zubar.mikalai.pars.interpreter;

import java.util.ArrayDeque;

/**
 * Created by Mikalay Zubar on 12.11.2016.
 */
public class Context {
    private ArrayDeque<Double> contextNumbers = new ArrayDeque<>();

    public Double popValue(){
        return contextNumbers.pop();
    }

    public void pushValue(Double value){
        contextNumbers.push(value);
    }
}
