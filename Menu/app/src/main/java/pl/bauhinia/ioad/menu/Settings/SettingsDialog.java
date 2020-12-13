package pl.bauhinia.ioad.menu.Settings;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;

import pl.bauhinia.ioad.menu.R;
import pl.bauhinia.ioad.menu.databinding.SettingsDialogBinding;

public class SettingsDialog extends Dialog implements View.OnClickListener {

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
        SettingsDialogBinding binding = SettingsDialogBinding.inflate(getLayoutInflater());
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

    // TODO: 13.12.2020 More logic
    public void onClickYes(View v) {
        dismiss();
    }

    public void onClickNo(View v) {
        dismiss();
    }
}
