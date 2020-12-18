package pl.ioad1.bauhinia.menu.Login;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import pl.ioad1.bauhinia.menu.R;
import pl.ioad1.bauhinia.menu.databinding.LoginDialogBinding;
import pl.ioad1.bauhinia.menu.databinding.SettingsDialogBinding;
import pl.ioad1.bauhinia.menu.helpers.SharedPreferencesHelper;

public class LoginDialog  extends Dialog implements View.OnClickListener{

    LoginDialogBinding binding;

    public LoginDialog(@NonNull Context context) {
        super(context);
    }


    public LoginDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoginDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = LoginDialogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.loginDialogButtonYes.setOnClickListener(this::onClickYes);
        binding.loginDialogButtonNo.setOnClickListener(this::onClickNo);
    }

    public void onClickYes(View v) {
        dismiss();
    }

    public void onClickNo(View v) {
        dismiss();
    }


    @Override
    public void onClick(View v) {

    }
}
