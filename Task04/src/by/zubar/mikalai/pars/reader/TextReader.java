package by.zubar.mikalai.pars.reader;

import by.zubar.mikalai.pars.exception.EmptyFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Mikalay Zubar on 01.11.2016.
 */
public class TextReader {
    private static final Logger LOGGER = LogManager.getLogger(TextReader.class);


    public static String readTextFile(String root) throws EmptyFileException {
        File inputFile = new File(root);
        int n ;
        FileReader fr = null;
        StringBuilder text = new StringBuilder();
        String str = "";
        try {
            fr = new FileReader(inputFile);
            while((n = fr.read())!= -1){
                text.append((char) n);
            }
            str = text.toString();
            if(str.isEmpty()){
                throw new EmptyFileException("The input file is empty.");
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found", e);
        } catch (IOException e) {
            LOGGER.error("Data input mistake", e);
        }finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    LOGGER.error(e);
                }
            }
        }
        return str;
    }

}
