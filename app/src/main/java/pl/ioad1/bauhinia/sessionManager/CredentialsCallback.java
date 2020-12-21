package pl.ioad1.bauhinia.sessionManager;

public interface CredentialsCallback<T> {
    void onComplete(T result);
}
