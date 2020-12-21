package pl.ioad1.bauhinia.menu;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pl.ioad1.bauhinia.R;
import pl.ioad1.bauhinia.menu.login.LoginDialog;
import pl.ioad1.bauhinia.menu.settings.SettingsDialog;
import pl.ioad1.bauhinia.menu.helpers.DarkModeHelper;
import pl.ioad1.bauhinia.menu.helpers.GlobalVariables;
import pl.ioad1.bauhinia.menu.helpers.SharedPreferencesHelper;
import pl.ioad1.bauhinia.sessionManager.Credentials;
import pl.ioad1.bauhinia.sessionManager.CredentialsCallback;

public class Menu extends AppCompatActivity {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DarkModeHelper.setDarkMode(SharedPreferencesHelper.isDarkMode(this));
        setElementEditorVisible();
        TextView test = findViewById(R.id.textView);
        Credentials credentials = Credentials.getInstance();
        credentials.init(executorService);
        credentials.signOut();
        credentials.signIn("test@mail.com", "Pa$$w0rd", new CredentialsCallback<Boolean>() {
            @Override
            public void onComplete(Boolean result) {

                test.setText(String.valueOf(result));
            }
        });

    }

    public void settingButtonOnClick(View v) {
        Dialog dialog = new SettingsDialog(this);
        dialog.show();
    }

    public void loginButtonOnClick(View v) {
        LoginDialog dialog = new LoginDialog(this);
        dialog.setOnLoginListener(this::setElementEditorVisible);
        dialog.show();
    }

    public void showMapListsButtonOnClick(View v) {
//        Intent intent = new Intent(this, MapList.class);
//        startActivity(intent);
    }

    public void showElementEditorButtonOnClick(View v) {
//        Intent intent = new Intent(this, ElementEditor.class);
//        startActivity(intent);
    }

    public void setElementEditorVisible() {
        boolean isVisible = GlobalVariables.getInstance().isUserAuthenticated();
        Button elementEditorButton = findViewById(R.id.elementEditorButton);
        if (isVisible) {
            elementEditorButton.setVisibility(View.VISIBLE);
            return;
        }
        elementEditorButton.setVisibility(View.INVISIBLE);
    }

}