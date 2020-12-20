package pl.ioad1.bauhinia.sessionManager;

import android.app.Activity;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import pl.ioad1.bauhinia.mapviewer.logic.model.MapListItem;
import pl.ioad1.bauhinia.mapviewer.logic.model.MapTemplateListItem;
import pl.ioad1.bauhinia.serverhttp.DatabaseProvider;

public class MapSender {
    public static final String STRING_MAPS = "Maps";
    public static final String STRING_MAPS_TEMPLATE = "Maps_template";

    private static Map<String, Object> mapListItemToMap(MapListItem mapListItem) {
        Map<String, Object> map = new HashMap<>();

        map.put("name", mapListItem.getName());
        map.put("mapTemplateId", mapListItem.getMapTemplateId());
        map.put("placedElements", mapListItem.getPlacedElements());

        return map;
    }

    private static Map<String, Object> mapTemplateListItemToMap(MapTemplateListItem m) {
        Map<String, Object> map = new HashMap<>();

        map.put("name", m.getName());
        map.put("district", m.getDistrict());
        map.put("maxBudget", m.getMaxBudget());
        map.put("placedElements", m.getPlacedElements());

        return map;
    }

    public static int sendMapListItem(MapListItem mapListItem) throws ExecutionException, InterruptedException, TimeoutException {
        String id;

        Map<String, Object> map = mapListItemToMap(mapListItem);

        DocumentReference documentReference = Tasks.await(DatabaseProvider.addDocument(STRING_MAPS, map), 3, TimeUnit.SECONDS);
        id = (String) Tasks.await(documentReference.get(), 3, TimeUnit.SECONDS).get("id");

        return Integer.parseInt(id);
    }

    public static int sendMapTemplateListItem(MapTemplateListItem m) throws ExecutionException, InterruptedException, TimeoutException {
        String id;

        Map<String, Object> map = mapTemplateListItemToMap(m);

        DocumentReference documentReference = Tasks.await(DatabaseProvider.addDocument(STRING_MAPS_TEMPLATE, map), 3, TimeUnit.SECONDS);
        id = (String) Tasks.await(documentReference.get(), 3, TimeUnit.SECONDS).get("id");

        return Integer.parseInt(id);
    }

    public static MapListItem receiveMapListItem(int id, Activity activity)
            throws InterruptedException, ExecutionException, TimeoutException {

        DocumentSnapshot row = Tasks.await(
                DatabaseProvider.getDocument(STRING_MAPS, String.valueOf(id)),
                3,
                TimeUnit.SECONDS);

        if (row != null) {
            return new MapListItem(
                    row.get("id"),
                    row.get("name"),
                    row.get("mapTemplateId"),
                    row.get("placedElements"));
        }
        return null;
    }

    public static void updateMapListItem(MapListItem mapListItem) throws ExecutionException, InterruptedException {
        Tasks.await(DatabaseProvider.updateDocument(
                STRING_MAPS,
                mapListItemToMap(mapListItem),
                String.valueOf(mapListItem.getId())));
    }
}
