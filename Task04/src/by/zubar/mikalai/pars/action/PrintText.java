package by.zubar.mikalai.pars.action;

import by.zubar.mikalai.pars.composite.TextComponent;
import by.zubar.mikalai.pars.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Created by Mikalay Zubar on 12.11.2016.
 */
public class PrintText {
    private static final Logger LOGGER = LogManager.getLogger(PrintText.class);
    private  static final String ROOT = "newText/newText.txt";

    public static void print(TextComposite allText){
        File newText = new File(ROOT);
        FileWriter fileWriter;
        BufferedWriter br;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(newText, false);
            br = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(br);
            TextComposite composite = allText;
            for(TextComponent paragraph: composite.getComponentList()){
                for (TextComponent sentence:  ((TextComposite) paragraph).getComponentList()){
                    for(TextComponent lexeme: ((TextComposite)sentence).getComponentList()){
                        for (TextComponent word: ((TextComposite) lexeme).getComponentList()){
                            printWriter.print(word+" ");
                        }
                    }
                    printWriter.print('\n');
                }
            }
        } catch (IOException e) {
            LOGGER.error("File input error", e);
        }finally {
            if(printWriter != null){
                printWriter.close();
            }
        }
    }


}
