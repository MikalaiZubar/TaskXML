package by.zubar.mikalai.xmltask.exeption;

/**
 * Created by Mikalay Zubar on 21.11.2016.
 */
public class NoSuchTariffException extends Exception {
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
