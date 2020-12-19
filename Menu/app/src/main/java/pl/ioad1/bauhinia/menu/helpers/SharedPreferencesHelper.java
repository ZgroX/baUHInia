package pl.ioad1.bauhinia.menu.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;


public class SharedPreferencesHelper {

    private SharedPreferencesHelper() {
    }

    public static String getUsername(@NonNull Context context) {
        return context.getSharedPreferences("settings", Context.MODE_PRIVATE).getString("nickname", "Anonymous");
    }

    public static boolean isDarkMode(@NonNull Context context) {
        return context.getSharedPreferences("settings", Context.MODE_PRIVATE).getBoolean("darkmode", false);
    }

    public static void saveDarkmode(@NonNull Context context, boolean darkMode) {
        SharedPreferences.Editor editor = context.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean("darkmode", darkMode);
        editor.apply();
        DarkModeHelper.setDarkMode(darkMode);
    }

    public static boolean isMapAutosave(@NonNull Context context) {
        return context.getSharedPreferences("settings", Context.MODE_PRIVATE).getBoolean("autosave", false);
    }

    public static void saveMapAutosave(@NonNull Context context, boolean autosave) {
        SharedPreferences.Editor editor = context.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean("autosave", autosave);
        editor.apply();
    }

    public static boolean isMuted(@NonNull Context context) {
        return context.getSharedPreferences("settings", Context.MODE_PRIVATE).getBoolean("mute", false);
    }

    public static void saveMuted(@NonNull Context context, boolean mute) {
        SharedPreferences.Editor editor = context.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean("mute", mute);
        editor.apply();
    }

    public static void saveUsername(@NonNull Context context, String username) {
        SharedPreferences.Editor editor = context.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putString("nickname", username);
        editor.apply();
    }

}
