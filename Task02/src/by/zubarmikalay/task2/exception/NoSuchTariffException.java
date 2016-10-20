package by.zubarmikalay.task2.exception;

/**
 * Created by Nick on 09.10.16.
 */
public class NoSuchTariffException extends Exception{
    public NoSuchTariffException(){
    }

    public NoSuchTariffException(String message){
        super(message);
    }

    public NoSuchTariffException(String message, Throwable exception){
        super(message, exception);
    }

    public NoSuchTariffException(Throwable exception){
        super(exception);
    }
}
