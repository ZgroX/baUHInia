package pl.ioad1.bauhinia.sessionManager.model;

import java.util.List;

public class MapListItem extends MapItem {
    private int mapTemplateId;

    public MapListItem(int id, String name, int mapTemplateId, List<PlacedElement> placedElements) {
        super(id, name, placedElements);
        this.mapTemplateId = mapTemplateId;
    }

    public MapListItem(Object id, Object name, Object mapTemplateId, Object placedElements) {
        super(id, name, placedElements);
        this.mapTemplateId = (int) mapTemplateId;
    }

    public int getMapTemplateId() {
        return mapTemplateId;
    }

    public void setMapTemplateId(int mapTemplateId) {
        this.mapTemplateId = mapTemplateId;
    }
}