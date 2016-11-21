package by.zubar.mikalai.pars.exception;

/**
 * Created by Mikalay Zubar on 14.11.2016.
 */
public class EmptyFileException extends Exception {
    public EmptyFileException(){
    }

    public EmptyFileException(String message){
        super(message);
    }

    public EmptyFileException(String message, Throwable exception){
        super(message, exception);
    }

    public EmptyFileException(Throwable exception){
        super(exception);
    }
}
