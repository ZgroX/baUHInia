package pl.ioad1.bauhinia.mapviewer.logic;

import pl.ioad1.bauhinia.mapviewer.logic.io.Connector;

// Singleton class for all operations that can be performed from the UI.
public class MapViewer {

    private MapList mapList;
    private MapTemplateList mapTemplateList;
    final private MapViewerUserActions mapViewerUserActions;
    protected Connector connector;

    static private MapViewer instance = null;

    private MapViewer(MapViewerUserActions mapViewerUserActions) {
        this.mapViewerUserActions = mapViewerUserActions;
    }

    static public void init(MapViewerUserActions mapViewerUserActions) {
        if (instance == null) {
            instance = new MapViewer(mapViewerUserActions);
        }
    }

    static public MapViewer getInstance() {
        return instance;
    }

    /*
        Operations:
     */



    public final MapList getMapList() {
        return mapList;
    }

    public final MapTemplateList getMapTemplateList() {
        return mapTemplateList;
    }

    public final MapViewerUserActions getMapViewerUserActions() {
        return mapViewerUserActions;
    }

    public boolean isActionAllowed(MapViewerUserActions.Action action) {
        return mapViewerUserActions.isActionAllowed(action);
    }
}
