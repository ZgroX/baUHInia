package pl.ioad1.bauhinia.serverhttp;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthenticationProvider {
    private static final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public static Task<AuthResult> signIn(String email, String password) {
        return mAuth.signInWithEmailAndPassword(email, password);
    }

    public static Task<AuthResult> signInAsGuest() {
        return mAuth.signInAnonymously();
    }

    public static void signOut() {
        mAuth.signOut();
    }

    public static FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

}
