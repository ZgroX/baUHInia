package pl.ioad1.bauhinia.sessionManager;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import pl.ioad1.bauhinia.sessionManager.model.MapListItem;
import pl.ioad1.bauhinia.sessionManager.model.MapTemplateListItem;
import pl.ioad1.bauhinia.serverhttp.DatabaseProvider;

public class MapProvider {
    public ArrayList<MapListItem> getMapList() throws InterruptedException, ExecutionException, TimeoutException {
        ArrayList<MapListItem> mapList = new ArrayList<>();

        QuerySnapshot table = Tasks.await(DatabaseProvider.getCollection(MapSender.STRING_MAPS), 10, TimeUnit.SECONDS);

        for (DocumentSnapshot row : table.getDocuments()) {
            mapList.add(new MapListItem(
                    row.get("id"),
                    row.get("name"),
                    row.get("mapTemplateId"),
                    row.get("placedElements")));
        }

        return mapList;
    }

    public ArrayList<MapTemplateListItem> getMapTemplateList() throws InterruptedException, ExecutionException, TimeoutException {
        ArrayList<MapTemplateListItem> mapTemplateList = new ArrayList<>();

        QuerySnapshot table = Tasks.await(DatabaseProvider.getCollection(MapSender.STRING_MAPS_TEMPLATE), 10, TimeUnit.SECONDS);

        for (DocumentSnapshot row : table.getDocuments()) {
            mapTemplateList.add(new MapTemplateListItem(
                    row.get("id"),
                    row.get("name"),
                    row.get("district"),
                    row.get("maxBudget"),
                    row.get("placedElements")));
        }

        return mapTemplateList;
    }

    public int sendMapListItem(MapListItem mapListItem) throws ExecutionException, InterruptedException, TimeoutException {
        return MapSender.sendMapListItem(mapListItem);
    }

    public int sendMapTemplateListItem(MapTemplateListItem mapTemplateListItem) throws InterruptedException, ExecutionException, TimeoutException {
        return MapSender.sendMapTemplateListItem(mapTemplateListItem);
    }

    public static void deleteMapItem(String id) throws ExecutionException, InterruptedException {
        Tasks.await(DatabaseProvider.deleteDocument(MapSender.STRING_MAPS, id));
    }

    public static void deleteMapTemplateItem(String id) throws ExecutionException, InterruptedException {
        Tasks.await(DatabaseProvider.deleteDocument(MapSender.STRING_MAPS_TEMPLATE, id));
    }

    public static void deleteMapItem(MapListItem m) throws ExecutionException, InterruptedException {
        Tasks.await(DatabaseProvider.deleteDocument(MapSender.STRING_MAPS, String.valueOf(m.getId())));
    }

    public static void deleteMapTemplateItem(MapTemplateListItem m) throws ExecutionException, InterruptedException {
        Tasks.await(DatabaseProvider.deleteDocument(MapSender.STRING_MAPS_TEMPLATE, String.valueOf(m.getId())));
    }
}