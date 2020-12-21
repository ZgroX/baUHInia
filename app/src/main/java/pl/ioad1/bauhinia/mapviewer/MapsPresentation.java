package pl.ioad1.bauhinia.mapviewer;

import android.content.Context;
import android.content.Intent;

public class MapsPresentation {

    public enum UserType {
        USER_RESIDENT,
        USER_CLERK
    }

    UserType userType;
    Context context;

    public MapsPresentation(UserType userType, Context context) {
        this.userType = userType;
        this.context = context;
        runActivity();
    }

    private void runActivity() {
        Intent intent = new Intent(context, MapViewerMainActivity.class);
        intent.putExtra("UserType", userType.toString());
        context.startActivity(intent);
    }
}
