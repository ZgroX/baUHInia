package pl.ioad1.bauhinia.menu.helpers;

import androidx.appcompat.app.AppCompatDelegate;

public class DarkModeHelper {

    private static final DarkModeHelper INSTANCE = new DarkModeHelper();

    private DarkModeHelper() {
    }

    public static DarkModeHelper getInstance(){
        return INSTANCE;
    }

    public static void setDarkMode(boolean isDarkMode){
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
