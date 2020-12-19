package pl.ioad1.bauhinia.mapviewer.ui.main;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

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

        // Button, which can be used also by resident and by clerk
        ImageButton infoTemplateBtn = (ImageButton) view.findViewById(R.id.moreInfosTemplateBtn);

        ClickingButtons(i, infoTemplateBtn);

        nameTextView.setText(item.name);
        districtTextView.setText(item.district);
        maxBudgetTextView.setText(Integer.toString(item.maxBudget));

        return view;
    }

    public void ClickingButtons(int position, ImageButton infoBtn) {
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // new window with more informations about templates
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(items.get(position).getName());
                builder.setMessage("Więcej informacji")
                        .setNegativeButton("Zamknij", null);

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
