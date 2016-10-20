package by.zubarmikalay.task2.exception;

/**
 * Created by Nick on 07.10.16.
 */
public class NegativeTariffValueException extends Exception {

    public NegativeTariffValueException(){
    }

    public NegativeTariffValueException(String message){
        super(message);
    }

    public NegativeTariffValueException(String message, Throwable exception){
        super(message, exception);
    }

    public NegativeTariffValueException(Throwable exception){
        super(exception);
    }
}

