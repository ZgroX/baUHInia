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
import pl.ioad1.bauhinia.mapviewer.logic.MapViewer;
import pl.ioad1.bauhinia.mapviewer.logic.MapViewerUserActions;
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

        nameTextView.setText("Nazwa: " + item.name);
        districtTextView.setText("Dzielnica: " + item.district);
        maxBudgetTextView.setText("Max budżet: " + Integer.toString(item.maxBudget));

        // Buttons, which can show more infos, delete or edit template
        ImageButton infoTemplateBtn = (ImageButton) view.findViewById(R.id.moreInfosTemplateBtn);
        ImageButton deleteTemplateBtn = (ImageButton) view.findViewById(R.id.deleteTemplateBtn);
        ImageButton editTemplateBtn = (ImageButton) view.findViewById(R.id.editTemplateBtn);

        ClickingButtons(i, deleteTemplateBtn, infoTemplateBtn, editTemplateBtn);

        return view;
    }

    public void ClickingButtons(int position, ImageButton deleteTemplateBtn, ImageButton infoTemplateBtn, ImageButton editTemplateBtn) {
        // use MapViewer to check, what actions are possible
        MapViewer mapViewer = MapViewer.getInstance();

        // variables to know, what should be possible for user
        boolean ifDelete = mapViewer.isActionAllowed((MapViewerUserActions.Action.ACTION_DELETE_TEMPLATE));
        boolean ifInfo = mapViewer.isActionAllowed(MapViewerUserActions.Action.ACTION_GET_MORE_INFO_TEMPLATE);
        boolean ifEdit = mapViewer.isActionAllowed(MapViewerUserActions.Action.ACTION_EDIT_TEMPLATE);

        if (ifDelete) {
            deleteTemplateBtn.setImageResource(R.drawable.ic_delete);
            deleteTemplateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // new window, where user can decide, if he is sure, that he want delete map
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Czy na pewno chcesz usunąć szablon?")
                            .setNegativeButton("Anuluj", null)
                            .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // remove the template from list
                                    items.remove(position);
                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }

        if (ifInfo) {
            infoTemplateBtn.setOnClickListener(new View.OnClickListener() {
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

        if (ifEdit) {
            editTemplateBtn.setImageResource(R.drawable.ic_edit);
            editTemplateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // new window, where user can decide, if he want edit map
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Czy chcesz edytować szablon?")
                            .setNegativeButton("Anuluj", null)
                            .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(context, "you want edit template nr" + position, Toast.LENGTH_SHORT).show();
                                    // here we go to activity to edit template
                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }

    }
}
