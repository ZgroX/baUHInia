package pl.ioad1.bauhinia.sessionManager.model;

import java.util.List;

public class MapListItem {
    private final int id;
    private String name;
    private int mapTemplateId;
    private List<PlacedElement> placedElements;

    public MapListItem(int id, String name, int mapTemplateId, List<PlacedElement> placedElements) {
        this.id = id;
        this.name = name;
        this.mapTemplateId = mapTemplateId;
        this.placedElements = placedElements;
    }

    public MapListItem(Object id, Object name, Object mapTemplateId, Object placedElements) {
        this.id = (int) id;
        this.name = (String) name;
        this.mapTemplateId = (int) mapTemplateId;
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

    public int getMapTemplateId() {
        return mapTemplateId;
    }

    public void setMapTemplateId(int mapTemplateId) {
        this.mapTemplateId = mapTemplateId;
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