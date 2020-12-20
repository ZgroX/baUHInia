package pl.ioad1.bauhinia.mapeditor;

import android.widget.ImageView;

public class Tile {
    private int id; // id of a single tile on template
    //private ImageView tileBackground;
    private int tileBackground; // actual background of tile - for example grass, road, river,
                                // sidewalk

    //private List<Element> elements // elements on tile - for example tree, house, bench

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTileBackground() {
        return tileBackground;
    }

    public void setTileBackground(int tileBackground) {
        this.tileBackground = tileBackground;
    }
}
