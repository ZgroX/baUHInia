package pl.ioad1.bauhinia.sessionManager.data;

import java.util.Arrays;
import java.util.List;

import pl.ioad1.bauhinia.elementeditor.Element;

public class PlacedElement {
    private Element element;
    private List<Integer> location;

    public PlacedElement(Element element, List<Integer> location) {
        this.element = element;
        this.location = location;
    }

    public PlacedElement(Element element, int x, int y) {
        this.element = element;
        this.location = Arrays.asList(x, y);
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public List<Integer> getLocation() {
        return location;
    }

    public Integer getLocationX() {
        return location.get(0);
    }

    public Integer getLocationY() {
        return location.get(1);
    }

    public void setLocation(List<Integer> location) {
        this.location = location;
    }
}
