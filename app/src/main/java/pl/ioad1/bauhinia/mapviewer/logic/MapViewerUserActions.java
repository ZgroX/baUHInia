package pl.ioad1.bauhinia.mapviewer.logic;

import java.util.ArrayList;

public class MapViewerUserActions {
    public enum Action {
        ACTION_CREATE_TEMPLATE,
        ACTION_DELETE_TEMPLATE,
        ACTION_EDIT_TEMPLATE,
        ACTION_CREATE_MAP,
        ACTION_DELETE_MAP,
        ACTION_EDIT_MAP,
        ACTION_UPLOAD_MAP_TO_SERVER,
        ACTION_UPLOAD_MAP_TEMPLATE_TO_SERVER,
        ACTION_GET_MAPS_FROM_SERVER,
        ACTION_GET_MAPS_FROM_LOCAL_STORAGE,
        ACTION_CREATE_MAP_FROM_TEMPLATE
    }

    private ArrayList<Action> allowedActions;

    public void addAllowedAction(Action action) {
        allowedActions.add(action);
    }

    public final ArrayList<Action> getAllowedActions() {
        return allowedActions;
    }

    public boolean isActionAllowed(Action action) {
        return allowedActions.contains(action);
    }
}
