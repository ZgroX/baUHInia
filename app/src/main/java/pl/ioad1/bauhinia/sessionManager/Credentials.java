package pl.ioad1.bauhinia.sessionManager;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Credentials {
    private static final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public static boolean signIn(String email, String password) throws InterruptedException, ExecutionException, TimeoutException {
        AuthResult authorize = Tasks.await(mAuth.signInWithEmailAndPassword(email, password), 5, TimeUnit.SECONDS);
        return authorize.getUser() != null;
    }
    public static boolean signInAsGuest() throws InterruptedException, ExecutionException, TimeoutException {
        AuthResult authorize = Tasks.await(mAuth.signInAnonymously(), 5, TimeUnit.SECONDS);
        return authorize.getUser() != null;
    }
    public static void signOut() {
        mAuth.signOut();
    }
    public static FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }
}