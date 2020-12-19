package pl.ioad1.bauhinia.menu.Settings;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;

import pl.ioad1.bauhinia.menu.R;
import pl.ioad1.bauhinia.menu.databinding.SettingsDialogBinding;
import pl.ioad1.bauhinia.menu.helpers.SharedPreferencesHelper;

public class SettingsDialog extends Dialog implements View.OnClickListener {
    private SettingsDialogBinding binding;

    private Context context;

    public SettingsDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public SettingsDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = SettingsDialogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.settingsDialogButtonYes.setOnClickListener(this::onClickYes);
        binding.settingsDialogButtonNo.setOnClickListener(this::onClickNo);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }

    public void onClickYes(View v) {
        SharedPreferencesHelper.saveDarkmode(context, ((CheckBox) findViewById(R.id.dark_mode_checkbox)).isChecked());
        SharedPreferencesHelper.saveMapAutosave(context, ((CheckBox) findViewById(R.id.map_autosave_checkbox)).isChecked());
        SharedPreferencesHelper.saveMuted(context, ((CheckBox) findViewById(R.id.mute_checkbox)).isChecked());
        SharedPreferencesHelper.saveUsername(context, ((EditText) findViewById(R.id.edit_text_user_nickname)).getText().toString());
        dismiss();
    }

    public void onClickNo(View v) {
        dismiss();
    }
}
