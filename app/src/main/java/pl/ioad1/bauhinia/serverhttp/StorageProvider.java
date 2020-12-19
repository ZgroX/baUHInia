package pl.ioad1.bauhinia.serverhttp;

import android.graphics.Bitmap;
import android.net.Uri;

import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StorageProvider {
    private static final FirebaseStorage storage = FirebaseStorage.getInstance();

    public static UploadTask upload(InputStream stream, String path) {
        StorageReference storageReference = storage.getReference().child(path);
        return storageReference.putStream(stream);
    }

    public static UploadTask upload(Bitmap bitmap, String path) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
        InputStream inputStream = new ByteArrayInputStream(bos.toByteArray());
        return upload(inputStream, path);
    }

    public static Task<Uri> getDownloadUrl(String path) {
        return storage.getReference().child(path).getDownloadUrl();
    }

    public static Task<ListResult> listAllFiles(String path) {
        StorageReference listRef = storage.getReference().child(path);
        return listRef.listAll();
    }

    public static Task<Void> removeFile(String path) {
        StorageReference fileReference = storage.getReference().child(path);
        return fileReference.delete();
    }
}
