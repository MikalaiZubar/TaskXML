package by.zubar.mikalai.pars.action;

import by.zubar.mikalai.pars.composite.TextComponent;
import by.zubar.mikalai.pars.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Created by Mikalay Zubar on 13.11.2016.
 */
public class Action {
    private static final Logger LOGGER = LogManager.getLogger(Action.class);

    public static List<TextComposite> getSentences(TextComposite allText){
        TextComposite composite = allText;
        LinkedList<TextComposite> sentencesList = new LinkedList<>();
        for(TextComponent paragraph: composite.getComponentList()){
            for (TextComponent sentence:  ((TextComposite) paragraph).getComponentList()){
                sentencesList.add((TextComposite) sentence);
            }
        }
        return sentencesList;
    }


    public static void printMinToMaxLexeme(TextComposite allText){
        List<TextComposite> sentencesList = getSentences(allText);
        TreeMap<Integer, TextComposite> sentencesTree = new TreeMap<>();
        for(TextComposite sentence: sentencesList){
            int key = sentence.getComponentList().size();
            sentencesTree.put(key, sentence);
        }
        for(Map.Entry pair: sentencesTree.entrySet()){
            LOGGER.info("Number of lexemes: " + pair.getKey() + " : " + pair.getValue().toString());
        }

    }

    public static void changeFirstLastLexemes(TextComposite allText){
        List<TextComposite> sentencesList = getSentences(allText);
        for(TextComposite sentence : sentencesList){
            List<TextComponent> lexemeList = sentence.getComponentList();
            Collections.swap(lexemeList, 0, lexemeList.size()-1);
            StringBuilder stringBuilder = new StringBuilder();
            for(TextComponent lexeme: lexemeList ){
                stringBuilder.append(lexeme);
                stringBuilder.append(" ");
            }
            sentence.setText(stringBuilder.toString());
            LOGGER.info(sentence);

        }
    }

    public static void printLexemesInAlphabethicalOrder(TextComposite allText){
        List<TextComposite> sentencesList = getSentences(allText);
        TreeSet<String > lexemes = new TreeSet<>();
        for(TextComposite sentence : sentencesList){
            List<TextComponent> lexemeList = sentence.getComponentList();
            for(int i=0; i< lexemeList.size(); i++){
                lexemes.add(lexemeList.get(i).toString());
            }
        }
        char firstSign = ' ';
        int size = lexemes.size();
        String str = " ";
        for(int i=0; i< size; i++){
            if(firstSign != lexemes.first().charAt(0)){
                str = '\t' + lexemes.first();
                LOGGER.info(str);
                firstSign = lexemes.first().charAt(0);
                lexemes.remove(lexemes.first());
            }else {
                str = lexemes.first();
                LOGGER.info(str);
                firstSign = lexemes.first().charAt(0);
                lexemes.remove(lexemes.first());
            }
        }
    }


}
