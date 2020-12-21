package pl.ioad1.bauhinia.sessionManager;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Credentials {
    private static Credentials instance;
    private Executor executor;
    private static final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private Credentials() {
    }

    static {
        try {
            instance = new Credentials();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static Credentials getInstance() {
        return instance;
    }

    public void init(Executor executor) {
        this.executor = executor;
    }

    public void signIn(String email, String password, final CredentialsCallback<Boolean> callback) {

        executor.execute(() -> {
            AuthResult authorize = null;
            try {
                authorize = Tasks.await(mAuth.signInWithEmailAndPassword(email, password), 5, TimeUnit.SECONDS);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            callback.onComplete(authorize != null);
        });
    }

    public void signInAsGuest(final CredentialsCallback<Boolean> callback) {
        executor.execute(() -> {
            AuthResult authorize = null;
            try {
                authorize = Tasks.await(mAuth.signInAnonymously(), 5, TimeUnit.SECONDS);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            callback.onComplete(authorize != null);
        });
    }

    public void signOut() {
        executor.execute(mAuth::signOut);
    }

    public FirebaseUser getCurrentUser() { return mAuth.getCurrentUser();
    }
}