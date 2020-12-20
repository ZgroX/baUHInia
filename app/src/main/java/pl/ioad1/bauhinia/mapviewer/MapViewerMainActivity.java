package pl.ioad1.bauhinia.mapviewer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import pl.ioad1.bauhinia.R;
import pl.ioad1.bauhinia.mapviewer.logic.MapViewer;
import pl.ioad1.bauhinia.mapviewer.logic.MapViewerUserActions;
import pl.ioad1.bauhinia.mapviewer.ui.main.SectionsPagerAdapter;

public class MapViewerMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        MapsPresentation.UserType userType = MapsPresentation.UserType.valueOf(intent.getStringExtra("UserType"));

        initLogic(userType);

        setContentView(R.layout.activity_map_viewer_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


    }

    private void initLogic(MapsPresentation.UserType userType) {
        MapViewerUserActions mapViewerUserActions = new MapViewerUserActions();

        switch (userType) {
            case USER_RESIDENT: {
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_CREATE_MAP_FROM_TEMPLATE);
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_DELETE_MAP);
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_EDIT_MAP);
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_UPLOAD_MAP_TO_SERVER);
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_GET_MAPS_FROM_LOCAL_STORAGE);
            }
                break;
            case USER_CLERK: {
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_CREATE_TEMPLATE);
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_DELETE_TEMPLATE);
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_EDIT_TEMPLATE);
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_PREVIEW_MAP);
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_UPLOAD_MAP_TEMPLATE_TO_SERVER);
                mapViewerUserActions.addAllowedAction(MapViewerUserActions.Action.ACTION_GET_MAPS_FROM_SERVER);
            }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + userType);
        }

        // Init the singleton logic class object.
        MapViewer.init(mapViewerUserActions);
    }
}
