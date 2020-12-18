package pl.ioad1.bauhinia.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import pl.ioad1.bauhinia.menu.Login.LoginDialog;
import pl.ioad1.bauhinia.menu.Settings.SettingsDialog;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void settingButtonOnClick(View v) {
        Dialog dialog =  new SettingsDialog(this);
        dialog.show();
    }

    public void loginButtonOnClick(View v) {
        Dialog dialog =  new LoginDialog(this);
        dialog.show();
    }

    public void showMapListSButtonOnClick(View v) {

    }

    public void showElementEditorButtonOnClick(View v) {

    }


}