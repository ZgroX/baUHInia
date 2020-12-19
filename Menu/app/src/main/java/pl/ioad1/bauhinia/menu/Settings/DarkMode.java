package pl.ioad1.bauhinia.menu.Settings;

import androidx.appcompat.app.AppCompatDelegate;

public class DarkMode {

    private static final DarkMode INSTANCE = new DarkMode();

    private DarkMode() {
    }

    public DarkMode getInstance(){
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
