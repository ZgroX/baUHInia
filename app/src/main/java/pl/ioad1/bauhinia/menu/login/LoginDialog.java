package pl.ioad1.bauhinia.menu.login;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import pl.ioad1.bauhinia.R;
import pl.ioad1.bauhinia.databinding.LoginDialogBinding;
import pl.ioad1.bauhinia.menu.Menu;
import pl.ioad1.bauhinia.sessionManager.Credentials;

public class LoginDialog extends Dialog implements View.OnClickListener {

    private LoginDialogBinding binding;
    private OnLoginListener onLoginListener;
    private Context context;

    public LoginDialog(@NonNull Menu menu) {
        this((Context) menu);
    }

    public LoginDialog(@NonNull Context context) {
        super(context);
        this.context = context;
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
        String login = ((EditText) findViewById(R.id.editTextLogin)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();
        if (checkIfInputsAreEmpty(login, password)) {
            Toast.makeText(this.context, "Inputs can not be empty!", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            if(Credentials.signIn(login, password)){
                if (this.onLoginListener != null) {
                    onLoginListener.onLoginSuccessful();
                }
            } else {
                Toast.makeText(this.context, "Authorization failed.", Toast.LENGTH_LONG).show();
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        dismiss();
    }


    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    public boolean checkIfInputsAreEmpty(String login, String password) {
        return login.trim().length() == 0 || password.trim().length() == 0;
    }

    public void onClickNo(View v) {
        dismiss();
    }

    @Override
    public void onClick(View v) {

    }


    public interface OnLoginListener {
        void onLoginSuccessful();
    }
}

