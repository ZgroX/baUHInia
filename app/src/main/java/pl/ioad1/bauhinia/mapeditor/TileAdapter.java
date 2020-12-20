package pl.ioad1.bauhinia.mapeditor;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import pl.ioad1.bauhinia.R;

public class TileAdapter extends BaseAdapter {
    private final Context mContext;
    //private final int[] buttons;
    private Button button;
    private LayoutInflater thisInflater;
    private Tile[] tiles; // tiles on GridView

    public TileAdapter(Context mContext, Tile[] tiles) { //int[] buttons
        this.mContext = mContext;
        this.thisInflater = LayoutInflater.from(mContext);
        //this.buttons = buttons;
        this.tiles = tiles;
    }

    @Override
    public int getCount() {
        //return buttons.length;
        return tiles.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    //TODO: ustawic kolor klockow na bialy, dodac listenery, ktore otworza aktywnosc wyboru tła
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Tile tile = tiles[position];

        if (convertView == null) {
            convertView = thisInflater.inflate(R.layout.item_grid,parent,false);
//            Button button = (Button) convertView.findViewById(R.id.button_in_gird);
//            button.setBackgroundResource(R.drawable.grid_button);
//            button.setBackgroundColor(ContextCompat.getColor(mContext,R.color.white));
            ImageView imageView = (ImageView) convertView.findViewById(R.id.button_in_gird);
            imageView.setBackgroundColor(tile.getTileBackground());
        }

//        button.setBackgroundResource(R.drawable.grid_button);
//        button.setHeight(button.getWidth());
        return convertView;
    }
}
