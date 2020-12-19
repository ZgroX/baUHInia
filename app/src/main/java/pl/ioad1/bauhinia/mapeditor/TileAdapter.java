package pl.ioad1.bauhinia.mapeditor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import pl.ioad1.bauhinia.R;

public class TileAdapter extends BaseAdapter {
    private Context mContext;
    private final int[] buttons;
    private Button button;
    private LayoutInflater thisInflater;

    public TileAdapter(Context mContext, int[] buttons) {
        this.mContext = mContext;
        this.thisInflater = LayoutInflater.from(mContext);
        this.buttons = buttons;
    }

    @Override
    public int getCount() {
        return buttons.length;
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
        if (convertView == null) {
            convertView = thisInflater.inflate(R.layout.item_grid,parent,false);
            Button button = (Button) convertView.findViewById(R.id.button_in_gird);
            //button.setBackgroundResource(R.drawable.grid_button);
        }
//        button.setBackgroundResource(R.drawable.grid_button);
//        button.setHeight(button.getWidth());
        return convertView;
    }
}
