package pl.ioad1.bauhinia.sessionManager.model;

import java.util.List;

public abstract class MapItem {
    private int id;
    private String name;
    private List<PlacedElement> placedElements;

    public MapItem(int id, String name, List<PlacedElement> placedElements) {
        this.id = id;
        this.name = name;
        this.placedElements = placedElements;
    }

    public MapItem(Object id, Object name, Object placedElements) {
        this.id = (int) id;
        this.name = (String) name;
        this.placedElements = (List<PlacedElement>) placedElements;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlacedElement(PlacedElement placedElement) {
        this.placedElements.add(placedElement);
    }

    public void addPlacedElement(Element element, int x, int y) {
        this.placedElements.add(new PlacedElement(element, x, y));
    }

    public List<PlacedElement> getPlacedElements() {
        return placedElements;
    }
}
