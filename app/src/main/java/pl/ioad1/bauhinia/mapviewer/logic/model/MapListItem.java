package pl.ioad1.bauhinia.mapviewer.logic.model;

public class MapListItem {
    public int id;
    public String name;
    public int mapTemplateId;

    public MapListItem(int id, String name, int mapTemplateId) {
        this.id = id;
        this.name = name;
        this.mapTemplateId = mapTemplateId;
    }

    public String getName() {
        return name;
    }
}
