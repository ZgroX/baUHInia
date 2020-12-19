package pl.ioad1.bauhinia.menu.helpers;

public class GlobalVariables {
    private static final GlobalVariables INSTANCE = new GlobalVariables();
    private boolean isUserAuthenticated;


    private GlobalVariables() {
        isUserAuthenticated = false;
    }

    public static GlobalVariables getInstance() {
        return INSTANCE;
    }

    public boolean isUserAuthenticated() {
        return isUserAuthenticated;
    }

    public void setUserAuthenticated(boolean userAuthenticated) {
        isUserAuthenticated = userAuthenticated;
    }
}