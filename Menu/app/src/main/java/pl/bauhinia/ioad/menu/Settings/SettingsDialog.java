package pl.bauhinia.ioad.menu.Settings;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import androidx.annotation.NonNull;

public class SettingsDialog extends Dialog implements View.OnClickListener {

    private Context context;

    public SettingsDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }
}
