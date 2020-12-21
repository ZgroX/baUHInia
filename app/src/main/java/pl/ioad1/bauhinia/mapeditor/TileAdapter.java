package pl.ioad1.bauhinia.mapeditor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import pl.ioad1.bauhinia.R;

public class TileAdapter extends BaseAdapter {
    private final Context mContext;
    private final LayoutInflater thisInflater;
    private final Tile[] tiles; // tiles on GridView

    public TileAdapter(Context mContext, Tile[] tiles) {
        this.mContext = mContext;
        this.thisInflater = LayoutInflater.from(mContext);
        this.tiles = tiles;
    }

    @Override
    public int getCount() {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Tile tile = tiles[position];

        if (convertView == null) {
            convertView = thisInflater.inflate(R.layout.item_grid,parent,false);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.single_tile_image_view);
            imageView.setImageResource(R.drawable.grass);
        }

        return convertView;
    }
}
