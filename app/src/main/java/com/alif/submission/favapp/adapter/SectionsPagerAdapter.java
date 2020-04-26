package com.alif.submission.favapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alif.submission.favapp.R;
import com.alif.submission.favapp.fragment.MovieFragment;
import com.alif.submission.favapp.fragment.ShowFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final Context context;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    private final int[] TAB_TITLES = new int[]{
            R.string.fav_movie,
            R.string.fav_show
    };

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new MovieFragment();
                break;

            case 1:
                fragment = new ShowFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}
