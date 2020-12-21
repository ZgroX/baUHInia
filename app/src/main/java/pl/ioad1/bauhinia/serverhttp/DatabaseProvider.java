package pl.ioad1.bauhinia.serverhttp;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class DatabaseProvider {
    public static Task<DocumentReference> addDocument(String collection, Map<String, Object> data) {
        return FirebaseFirestore.getInstance().collection(collection).add(data);
    }

    public static Task<Void> updateDocument(String collection, Map<String, Object> data, String id) {
        return FirebaseFirestore.getInstance().collection(collection).document(id).update(data);
    }

    public static Task<Void> deleteDocument(String collection, String id) {
        return FirebaseFirestore.getInstance().collection(collection).document(id).delete();
    }

    public static Task<DocumentSnapshot> getDocument(String collection, String id) {
        return FirebaseFirestore.getInstance().collection(collection).document(id).get();
    }

    public static Task<QuerySnapshot> getCollection(String collection) {
        return FirebaseFirestore.getInstance().collection(collection).get();
    }
}
