package pl.ioad1.bauhinia.mapeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import pl.ioad1.bauhinia.R;
//TODO ogarnac to wszystko bo na razie jest mocno roboczo, zrobic siatke klikalna i zmieniajaca swoje tlo
public class MapEditorMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_editor_main);
        int [] test = {1,2,3,4,5,6,7,8,9};
        GridView gridView = (GridView) findViewById(R.id.gvTemplate);
        TileAdapter tileAdapter = new TileAdapter(MapEditorMainActivity.this,test);
        gridView.setAdapter(tileAdapter);
    }
}