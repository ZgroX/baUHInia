package pl.ioad1.bauhinia.sessionManager.model;

import java.util.List;

public class MapTemplateListItem {
    private int id;
    private String name;
    private String district;
    private int maxBudget;
    private List<PlacedElement> placedElements;

    public MapTemplateListItem(int id, String name, String district, int maxBudget, List<PlacedElement> placedElements) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.maxBudget = maxBudget;
        this.placedElements = placedElements;
    }

    public MapTemplateListItem(Object id, Object name, Object district, Object maxBudget, Object placedElements) {
        this.id = (int) id;
        this.name = (String) name;
        this.district = (String) district;
        this.maxBudget = (int) maxBudget;
        this.placedElements = (List<PlacedElement>) placedElements;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getMaxBudget() {
        return maxBudget;
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