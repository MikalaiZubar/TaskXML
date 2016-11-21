package by.zubar.mikalai.pars.main;

import by.zubar.mikalai.pars.action.Action;
import by.zubar.mikalai.pars.action.PrintText;
import by.zubar.mikalai.pars.composite.TextComposite;
import by.zubar.mikalai.pars.creator.CompositeCreator;
import by.zubar.mikalai.pars.exception.EmptyFileException;
import by.zubar.mikalai.pars.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by Mikalay Zubar on 01.11.2016.
 */
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String ROOT = "inputText/text.txt";


    public static void main(String[] args) {

        try {
            TextComposite textComposite = CompositeCreator.createComposite(TextReader.readTextFile(ROOT));

            PrintText.print(textComposite);

            Action.changeFirstLastLexemes(textComposite);
            Action.changeFirstLastLexemes(textComposite); //rolling back changes
            Action.printMinToMaxLexeme(textComposite);
            Action.printLexemesInAlphabethicalOrder(textComposite);
        }catch (EmptyFileException e){
            LOGGER.error(e);
        }

    }

}