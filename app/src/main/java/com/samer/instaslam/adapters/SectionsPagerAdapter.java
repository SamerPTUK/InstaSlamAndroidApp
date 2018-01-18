package com.samer.instaslam.adapters;

/**
 * Created by Samer AlShurafa on 1/15/2018.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.samer.instaslam.fragments.FeedActivityFragment;
import com.samer.instaslam.fragments.HomeFragment;
import com.samer.instaslam.fragments.ProfileFragment;
import com.samer.instaslam.fragments.SearchFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return HomeFragment.newInstance();
            case 1: return SearchFragment.newInstance();
            case 2: return FeedActivityFragment.newInstance();
            default: return ProfileFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }
}