package pl.ioad1.bauhinia.mapviewer.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pl.ioad1.bauhinia.R;
import pl.ioad1.bauhinia.mapviewer.logic.model.MapListItem;

public class MapListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MapListItem> items;

    public MapListAdapter(Context context, ArrayList<MapListItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_map_list_item, viewGroup, false);
        }

        MapListItem item = (MapListItem) getItem(i);

        TextView mapNameTextView = (TextView) view.findViewById(R.id.map_list_item_name_textview);
        TextView mapTemplateNameTextView = (TextView) view.findViewById(R.id.map_list_item_map_template_name_textview);

        ImageButton deleteBtn = (ImageButton) view.findViewById(R.id.deleteMapBtn);
        ImageButton infoBtn = (ImageButton) view.findViewById(R.id.moreInfosMapBtn);

        ClickingButtons(deleteBtn, infoBtn);

        mapNameTextView.setText(item.name);
        mapTemplateNameTextView.setText(Integer.toString(item.mapTemplateId));

        return view;
    }

    public void ClickingButtons(ImageButton deleteBtn, ImageButton infoBtn) {
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "delete button", Toast.LENGTH_LONG).show();
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "information button", Toast.LENGTH_LONG).show();
            }
        });
    }
}
