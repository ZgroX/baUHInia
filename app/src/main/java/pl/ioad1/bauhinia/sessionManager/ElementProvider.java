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

import pl.ioad1.bauhinia.sessionManager.model.Element;
import pl.ioad1.bauhinia.serverhttp.DatabaseProvider;
import pl.ioad1.bauhinia.serverhttp.StorageProvider;

public class ElementProvider {
    private static final String STRING_ELEMENTS = "Elements";

    private static Map<String, Object> elementToMap(Element element) {
        Map<String, Object> map = new HashMap<>();

        map.put("length", element.getLength());
        map.put("width", element.getWidth());
        map.put("name", element.getName());
        map.put("height", element.getHeight());
        map.put("transparent", element.getTransparent());

        return map;
    }

    public static int sendElement(Element element) throws ExecutionException, InterruptedException, TimeoutException {
        String id;

        Map<String, Object> map = elementToMap(element);

        DocumentReference documentReference = Tasks.await(DatabaseProvider.addDocument(STRING_ELEMENTS, map), 3, TimeUnit.SECONDS);
        id = (String) Tasks.await(documentReference.get(), 3, TimeUnit.SECONDS).get("id");
        StorageProvider.upload(element.getImage(), STRING_ELEMENTS + "//" + id);

        return Integer.parseInt(id);
    }

    public static Element receiveElement(int id, Activity activity)
            throws IOException, InterruptedException, ExecutionException, TimeoutException {

        DocumentSnapshot row = Tasks.await(
                DatabaseProvider.getDocument(STRING_ELEMENTS, String.valueOf(id)),
                3,
                TimeUnit.SECONDS);

        Uri imageUriTask = Tasks.await(
                StorageProvider.getDownloadUrl(STRING_ELEMENTS + "//" + id),
                3,
                TimeUnit.SECONDS);

        if (row != null && imageUriTask != null) {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(
                    activity.getContentResolver(), imageUriTask);

            return new Element(
                    row.get("id"),
                    row.get("length"),
                    row.get("width"),
                    row.get("name"),
                    bitmap,
                    row.get("height"),
                    row.get("transparent"));
        }
        return null;
    }

    public static void updateElement(Element element) throws ExecutionException, InterruptedException {
        Tasks.await(DatabaseProvider.updateDocument(
                STRING_ELEMENTS,
                elementToMap(element),
                String.valueOf(element.getId())));
    }
}
