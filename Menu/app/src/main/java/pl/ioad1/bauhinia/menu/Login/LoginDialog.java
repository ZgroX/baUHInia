package pl.ioad1.bauhinia.menu.Login;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import pl.ioad1.bauhinia.menu.R;
import pl.ioad1.bauhinia.menu.User.User;
import pl.ioad1.bauhinia.menu.databinding.LoginDialogBinding;

public class LoginDialog extends Dialog implements View.OnClickListener {

    private LoginDialogBinding binding;

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
        // TODO: 18.12.2020 Przesyłać użytkownika dane
        User user = new User(((EditText) findViewById(R.id.editTextLogin)).getText().toString(), ((EditText) findViewById(R.id.editTextPassword)).getText().toString());
        dismiss();
    }

    public void onClickNo(View v) {
        dismiss();
    }


    @Override
    public void onClick(View v) {

    }
}
