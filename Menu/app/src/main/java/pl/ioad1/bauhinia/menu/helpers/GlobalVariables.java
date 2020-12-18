package pl.ioad1.bauhinia.menu.helpers;

public class GlobalVariables {
    private static final GlobalVariables INSTANCE = new GlobalVariables();


    private GlobalVariables() {
    }

    public static GlobalVariables getInstance() {
        return INSTANCE;
    }

}