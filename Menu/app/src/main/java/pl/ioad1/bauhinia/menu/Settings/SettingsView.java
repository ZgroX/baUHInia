package pl.ioad1.bauhinia.menu.Settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import pl.ioad1.bauhinia.menu.R;
import pl.ioad1.bauhinia.menu.helpers.SharedPreferencesHelper;

public class SettingsView extends FrameLayout {
    public SettingsView(Context context) {
        super(context);
        initComponent(context);
    }

    public SettingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initComponent(context);
    }

    public SettingsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initComponent(context);
    }

    public SettingsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initComponent(context);
    }

    private void initComponent(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.settings, this);
        ((CheckBox)findViewById(R.id.dark_mode_checkbox)).setChecked(SharedPreferencesHelper.isDarkMode(context));
        ((CheckBox)findViewById(R.id.map_autosave_checkbox)).setChecked(SharedPreferencesHelper.isMapAutosave(context));
        ((CheckBox)findViewById(R.id.mute_checkbox)).setChecked(SharedPreferencesHelper.isMuted(context));
        ((EditText)findViewById(R.id.edit_text_user_nickname)).setText(SharedPreferencesHelper.getUsername(context));
    }
}
