package by.zubar.mikalai.pars.composite;


/**
 * Created by Mikalay Zubar on 02.11.2016.
 */
public interface TextComponent {
    void add(TextComponent c);
    void remove(TextComponent c);
    void setText(String text);
    Object getChild (int index);
}
