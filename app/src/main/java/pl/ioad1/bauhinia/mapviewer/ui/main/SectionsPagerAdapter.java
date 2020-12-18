package pl.ioad1.bauhinia.mapviewer.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import pl.ioad1.bauhinia.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment that will contain list of maps or list of map templates
        // based on which page the fragment will be.
        ListFragment listFragment;

        switch (position) {
            case 0:
                // Create fragment where map list will be.
                listFragment = new ListFragment(ListFragment.FragmentType.MAP_LIST_FRAGMENT);
                break;
            case 1:
                // Create fragment where map template list will be.
                listFragment = new ListFragment(ListFragment.FragmentType.MAP_TEMPLATE_LIST_FRAGMENT);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }

        return listFragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}