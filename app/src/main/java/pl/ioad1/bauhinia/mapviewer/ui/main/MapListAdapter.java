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

        // Button, which can show more infos, delete oraz edit map
        ImageButton deleteMapBtn = (ImageButton) view.findViewById(R.id.deleteMapBtn);
        ImageButton infoBtn = (ImageButton) view.findViewById(R.id.moreInfosMapBtn);
        ImageButton editBtn = (ImageButton) view.findViewById(R.id.editMapBtn);

        ClickingButtons(i, deleteMapBtn, infoBtn, editBtn);

        mapNameTextView.setText(item.name);
        mapTemplateNameTextView.setText(Integer.toString(item.mapTemplateId));

        return view;
    }

    public void ClickingButtons(int position, ImageButton deleteBtn, ImageButton infoBtn, ImageButton editMapBtn) {
        // use MapViewer to check, what actions are possible
        MapViewer mapViewer = MapViewer.getInstance();

        // variables to know, what should be possible for user
        boolean ifDelete = mapViewer.isActionAllowed((MapViewerUserActions.Action.ACTION_DELETE_MAP));
        boolean ifInfo = mapViewer.isActionAllowed(MapViewerUserActions.Action.ACTION_GET_MORE_INFO_MAP);
        boolean ifEdit = mapViewer.isActionAllowed(MapViewerUserActions.Action.ACTION_EDIT_MAP);
        if (ifDelete) {
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // new window, where user can decide, if he is sure, that he want delete map
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Czy na pewno chcesz usunąć mapę?")
                            .setNegativeButton("Anuluj", null)
                            .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(context, "you want delete map nr" + position, Toast.LENGTH_SHORT).show();
                                    // here I have to remove element from maps list, but now it doesn't work correctly
                                    //items.remove(position);
                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }

        if (ifInfo) {
            infoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // new window with more informations about map
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
            editMapBtn.setImageResource(R.drawable.ic_edit);
            editMapBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // new window, where user can decide, if he want edit map
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Czy chcesz edytować mapę?")
                            .setNegativeButton("Anuluj", null)
                            .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(context, "you want edit map nr" + position, Toast.LENGTH_SHORT).show();
                                    // here we go to activity to edit map
                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
    }
}
