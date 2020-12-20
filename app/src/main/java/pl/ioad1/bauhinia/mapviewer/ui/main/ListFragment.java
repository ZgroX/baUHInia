package pl.ioad1.bauhinia.mapviewer.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import pl.ioad1.bauhinia.R;
import pl.ioad1.bauhinia.mapviewer.logic.model.MapListItem;
import pl.ioad1.bauhinia.mapviewer.logic.model.MapTemplateListItem;

/**
 * Fragment that contains map list or map template list.
 */
public class ListFragment extends Fragment {

    // Determines if it is fragment that contains list of maps or
    // fragment that contains list of map templates.
    public enum FragmentType {
        MAP_LIST_FRAGMENT,
        MAP_TEMPLATE_LIST_FRAGMENT
    }

    private FragmentType fragmentType;

    ListFragment(FragmentType fragmentType) {
        this.fragmentType = fragmentType;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Create view based on which fragment is it.

        View root = inflater.inflate(R.layout.list_fragment, container, false);
        switch (fragmentType) {
            // if it is fragment that contains list of maps
            case MAP_LIST_FRAGMENT: {
                ArrayList<MapListItem> items = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    items.add(new MapListItem(i, "Map name " + Integer.toString(i), 0));
                }

                ListView mapListView = (ListView) root.findViewById(R.id.map_list_view);

                MapListAdapter adapter = new MapListAdapter(container.getContext(), items);
                mapListView.setAdapter(adapter);
            }
                break;
            // if it is fragment that contains list of map templates
            case MAP_TEMPLATE_LIST_FRAGMENT: {
                ArrayList<MapTemplateListItem> items = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    items.add(new MapTemplateListItem(i, "Map Template name " + Integer.toString(i), "District", i * 1000));
                }

                ListView mapListView = (ListView) root.findViewById(R.id.map_list_view);

                MapTemplateListAdapter adapter = new MapTemplateListAdapter(container.getContext(), items);
                mapListView.setAdapter(adapter);
            }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + fragmentType);
        }

        return root;
    }
}