package by.zubar.mikalai.pars.composite;


/**
 * Created by Mikalay Zubar on 02.11.2016.
 */
public class TextLeaf implements TextComponent {

    private String string;

    public TextLeaf(){

    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public void add(TextComponent c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setText(String text) {
        string = text;
    }

    @Override
    public Object getChild(int index) {
        throw new UnsupportedOperationException();
    }
}
