package pl.ioad1.bauhinia.mapeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
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

        Tile[] tiles = new Tile[25 * 25];
        for (int i = 0; i < 25 * 25; i++) {
            tiles[i] = new Tile();
            tiles[i].setId(i);
            tiles[i].setTileBackground(Color.rgb(255,255,255));
        }

        GridView gridView = (GridView) findViewById(R.id.gvTemplate);
        TileAdapter tileAdapter = new TileAdapter(MapEditorMainActivity.this, tiles);
        gridView.setAdapter(tileAdapter);
    }

}