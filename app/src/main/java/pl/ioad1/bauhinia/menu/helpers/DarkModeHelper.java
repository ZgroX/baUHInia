package pl.ioad1.bauhinia.menu.helpers;

import androidx.appcompat.app.AppCompatDelegate;

public class DarkModeHelper {

    private DarkModeHelper() {
    }

    public static void setDarkMode(boolean isDarkMode) {
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
