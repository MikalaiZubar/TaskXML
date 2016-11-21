package by.zubar.mikalai.pars.creator;

import by.zubar.mikalai.pars.action.ConverterToRPN;
import by.zubar.mikalai.pars.action.Parser;
import by.zubar.mikalai.pars.composite.TextComponent;
import by.zubar.mikalai.pars.composite.TextComposite;
import by.zubar.mikalai.pars.composite.TextLeaf;
import by.zubar.mikalai.pars.interpreter.Client;
import by.zubar.mikalai.pars.texttype.TextType;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mikalay Zubar on 10.11.2016.
 */
public class CompositeCreator {


    public static TextComposite createComposite(String text){
        TextComposite fullText = new TextComposite();
        Parser parser = new Parser();
        List<String> paragraphs = parser.parse(TextType.PARAGRAPH, text);
        int paragraphsSize = paragraphs.size();
        for(int i=0; i<paragraphsSize; i++){
            TextComponent paragraph = new TextComposite();
            paragraph.setText(paragraphs.get(i));
            fullText.add(paragraph);
            List<String> sentences = parser.parse(TextType.SENTENCE, paragraphs.get(i));
            int sentencesSize = sentences.size();

            for(int j=0; j<sentencesSize; j++){
                TextComponent sentence = new TextComposite();
                sentence.setText(sentences.get(j));
                paragraph.add(sentence);
                List<String> lexemes = parser.parse(TextType.LEXEME, sentences.get(j));
                int lexemesSize = lexemes.size();
                for(int k=0; k<lexemesSize; k++){
                    TextComponent lexeme = new TextComposite();
                    String singleLexeme = lexemes.get(k);  //start changing math expression to calc result
                    String digit = "[\\d]";
                    Pattern pattern = Pattern.compile(digit);
                    Matcher matcher = pattern.matcher(singleLexeme);
                    if(matcher.find()){
                        String temp = ConverterToRPN.convert(singleLexeme);
                        Client client = new Client(temp);
                        Double num = client.calculate();
                        singleLexeme = String.valueOf(num);
                        //deleting float part from math result if it's .0
                        if(singleLexeme.substring(singleLexeme.length() - 2).equals(".0")){
                            singleLexeme = singleLexeme.substring(0, singleLexeme.length() - 2);
                        }
                    }

                    lexemes.remove(k);  //deleting expression
                    lexemes.add(k, singleLexeme);  // changing expression to result
                    lexeme.setText(singleLexeme);
                    sentence.add(lexeme);
                    List<String> words = parser.parse(TextType.WORD_SIGN, lexemes.get(k));
                    int wordsSize = words.size();
                    for(int f=0; f<wordsSize; f++){
                        TextComponent wordAndSign = new TextLeaf();
                        wordAndSign.setText(words.get(f));
                        lexeme.add(wordAndSign);
                    }
                }
            }
        }
        return  fullText;
    }


}
