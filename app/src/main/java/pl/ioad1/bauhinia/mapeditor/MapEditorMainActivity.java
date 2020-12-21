package pl.ioad1.bauhinia.mapeditor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

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

        String[] backgrounds = {"water","road","sidewalk","grass",};
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MapEditorMainActivity.this, R.style.MyDialogTheme);
                builder.setTitle("Wybierz tlo");
                builder.setItems(backgrounds, new DialogInterface.OnClickListener() {
                    //TODO: tu wykorzystac setTileBackground
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if ("water".equals(backgrounds[which])) {
                            ImageView background = view.findViewById(R.id.single_tile_image_view);
                            background.setImageResource(R.drawable.water);
                        } else if ("road".equals(backgrounds[which])) {
                            ImageView background = view.findViewById(R.id.single_tile_image_view);
                            background.setImageResource(R.drawable.road);
                        } else if ("sidewalk".equals(backgrounds[which])) {
                            ImageView background = view.findViewById(R.id.single_tile_image_view);
                            background.setImageResource(R.drawable.road); // sidewalk.jpg miał za duzy rozmiar, na razie zamiast sidewalk pokazuje się road, będzie zmienione
                        } else if ("grass".equals(backgrounds[which])) {
                            ImageView background = view.findViewById(R.id.single_tile_image_view);
                            background.setImageResource(R.drawable.grass);
                        }
                    }
                });
                builder.show();

            }
        });
    }

}