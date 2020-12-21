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
        return context.getSharedPreferences("settings", Context.MODE_PRIVATE).getBoolean("darkMode", false);
    }

    public static void saveDarkMode(@NonNull Context context, boolean darkMode) {
        SharedPreferences.Editor editor = context.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean("darkMode", darkMode);
        editor.apply();
        DarkModeHelper.setDarkMode(darkMode);
    }

    public static boolean isMapAutoSave(@NonNull Context context) {
        return context.getSharedPreferences("settings", Context.MODE_PRIVATE).getBoolean("autoSave", false);
    }

    public static void saveMapAutoSave(@NonNull Context context, boolean autoSave) {
        SharedPreferences.Editor editor = context.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean("autoSave", autoSave);
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
