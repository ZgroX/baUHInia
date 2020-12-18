package pl.ioad1.bauhinia.mapviewer.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pl.ioad1.bauhinia.R;
import pl.ioad1.bauhinia.mapviewer.logic.model.MapTemplateListItem;

public class MapTemplateListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MapTemplateListItem> items;

    public MapTemplateListAdapter(Context context, ArrayList<MapTemplateListItem> items) {
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
            view = LayoutInflater.from(context).inflate(R.layout.layout_map_template_list_item, viewGroup, false);
        }

        MapTemplateListItem item = (MapTemplateListItem) getItem(i);

        TextView nameTextView = (TextView) view.findViewById(R.id.map_template_list_item_name_textview);
        TextView districtTextView = (TextView) view.findViewById(R.id.map_template_list_item_district_textview);
        TextView maxBudgetTextView = (TextView) view.findViewById(R.id.map_template_list_item_max_budget_textview);

        nameTextView.setText(item.name);
        districtTextView.setText(item.district);
        maxBudgetTextView.setText(Integer.toString(item.maxBudget));

        return view;
    }
}
