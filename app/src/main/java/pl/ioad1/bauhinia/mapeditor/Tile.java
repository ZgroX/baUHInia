package pl.ioad1.bauhinia.mapeditor;

import android.app.Application;
import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import pl.ioad1.bauhinia.R;

public class Tile {
    private int id; // id of a single tile on template
    private int tileBackground; // actual background of tile - for example grass, road, river,

    // private List<Element> elements // elements on tile - for example tree, house, bench
    // private List<String> blockedTypes; // types of element, which are out of use
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


//    public boolean addElement(Element element) {
        // TODO: dodawanie elementow do listy
//    }

    public void sortElements() {
        //TODO: metoda do ukladania elementow w odpowiedniej kolejnosci
    }

//    public boolean deleteElement(String name) {
        // TODO: metoda sluzaca do usuniecia z listy odpowiedniego elementu
//    }
}
