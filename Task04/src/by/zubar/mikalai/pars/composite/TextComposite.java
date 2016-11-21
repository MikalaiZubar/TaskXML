package by.zubar.mikalai.pars.composite;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mikalay Zubar on 02.11.2016.
 */
public class TextComposite implements TextComponent {
    private List<TextComponent> componentList = new LinkedList<>();;
    private String text;

    public TextComposite(){
    }


    public void setText(String text) {
        this.text = text;
    }

    public List<TextComponent> getComponentList() {
        return componentList;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public void add(TextComponent component) {
        componentList.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        componentList.remove(component);
    }

    @Override
    public Object getChild(int index) {
        return componentList.get(index);
    }

}
