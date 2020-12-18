package pl.ioad1.bauhinia.mapviewer.logic.model;

public class MapTemplateListItem {
    public int id;
    public String name;
    public String district;
    public int maxBudget;

    public MapTemplateListItem(int id, String name, String district, int maxBudget) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.maxBudget = maxBudget;
    }
}
