package pl.ioad1.bauhinia.menu;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import pl.ioad1.bauhinia.R;
import pl.ioad1.bauhinia.elementeditor.ElementCreation;
import pl.ioad1.bauhinia.mapviewer.MapsPresentation;
import pl.ioad1.bauhinia.menu.login.LoginDialog;
import pl.ioad1.bauhinia.menu.settings.SettingsDialog;
import pl.ioad1.bauhinia.menu.helpers.DarkModeHelper;
import pl.ioad1.bauhinia.menu.helpers.GlobalVariables;
import pl.ioad1.bauhinia.menu.helpers.SharedPreferencesHelper;
import pl.ioad1.bauhinia.elementeditor.ElementCreation;
public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DarkModeHelper.setDarkMode(SharedPreferencesHelper.isDarkMode(this));
        setElementEditorVisible();
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
        new MapsPresentation(MapsPresentation.UserType.USER_CLERK, this);
    }

    public void showElementEditorButtonOnClick(View v) {
        Intent intent = new Intent(this, ElementCreation.class);
        startActivity(intent);
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