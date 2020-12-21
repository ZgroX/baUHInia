package pl.ioad1.bauhinia.sessionManager.model;

import java.util.List;

public class MapTemplateListItem extends MapItem {
    private String district;
    private int maxBudget;

    public MapTemplateListItem(int id, String name, String district, int maxBudget, List<PlacedElement> placedElements) {
        super(id, name, placedElements);
        this.district = district;
        this.maxBudget = maxBudget;
    }

    public MapTemplateListItem(Object id, Object name, Object district, Object maxBudget, Object placedElements) {
        super(id, name, placedElements);
        this.district = (String) district;
        this.maxBudget = (int) maxBudget;
    }

    public String getDistrict() {
        return district;
    }

    public int getMaxBudget() {
        return maxBudget;
    }
}