package pl.ioad1.bauhinia.sessionManager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import pl.ioad1.bauhinia.serverhttp.DatabaseProvider;
import pl.ioad1.bauhinia.serverhttp.StorageProvider;

public class MapProvider {
    private String stringMaps = "Maps";

    private Map<String, Object> elementToMap(MapListItem mapListItem) {
        Map<String, Object> map = new HashMap<>();

        map.put("name", mapListItem.getName());
        map.put("mapTemplateId", element.getMapTemplateId());

        return map;
    }

    public int sendMapListItem(MapListItem mapListItem) throws ExecutionException, InterruptedException, TimeoutException {
        String id;

        Map<String, Object> map = elementToMap(mapListItem);

        DocumentReference documentReference = Tasks.await(DatabaseProvider.addDocument(stringElements, map), 3, TimeUnit.SECONDS);
        id = (String) Tasks.await(documentReference.get(), 3, TimeUnit.SECONDS).get("id");
//        StorageProvider.upload(mapListItem.getImage(), stringMaps + "//" + id);

        return Integer.parseInt(id);
    }

    public MapListItem receiveMapListItem(int id, Activity activity)
            throws IOException, InterruptedException, ExecutionException, TimeoutException {

        DocumentSnapshot row = Tasks.await(
                DatabaseProvider.getDocument(stringMaps, String.valueOf(id)),
                3,
                TimeUnit.SECONDS);

        // Te linijki niżej to pod obrazek mapy, bo nie wiem czy mamy przechowywane
        // jakieś bitmapy dla map, więc na wszelki tu jest jeśli jednak
        // będzie potrzebne

//        Uri imageUriTask = Tasks.await(
//                StorageProvider.getDownloadUrl(stringMaps + "//" + id),
//                3,
//                TimeUnit.SECONDS);
//        Bitmap bitmap = MediaStore.Images.Media.getBitmap(
//                activity.getContentResolver(), imageUriTask);

        if (row != null) {
            return new MapListItem(
                    row.get("id"),
                    row.get("name"),
                    row.get("mapTemplateId"));
        }
        return null;
    }

    public void updateMapListItem(MapListItem mapListItem) {
        Tasks.await(DatabaseProvider.updateDocument(
                stringMaps,
                elementToMap(mapListItem),
                Integer.parseInt(mapListItem.getId())));
    }
}
