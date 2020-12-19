package pl.ioad1.bauhinia.mapeditor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import pl.ioad1.bauhinia.R;

public class TileAdapter extends BaseAdapter {
    private Context mContext;
    private final int[] buttons;
    private Button button;

    public TileAdapter(Context mContext, int[] buttons) {
        this.mContext = mContext;
        this.buttons = buttons;
    }

    @Override
    public int getCount() {
        return buttons.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button = new Button(mContext);
        button.setBackgroundResource(R.drawable.grid_button);
        return button;
    }
}
