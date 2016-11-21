package by.zubar.mikalai.pars.texttype;

/**
 * Created by Mikalay Zubar on 07.11.2016.
 */
public enum TextType {
    PARAGRAPH(".+"), SENTENCE("([^.!?]+[.!?])"), LEXEME("([^\\s]+)"), WORD_SIGN("([A-Za-z0-9-]+)|([.,!?'])|(\\-?\\d+(\\.\\d{0,}))");
    private String regex;
    TextType(String regex){
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
