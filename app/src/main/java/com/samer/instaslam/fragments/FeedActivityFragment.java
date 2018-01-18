package com.samer.instaslam.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samer.instaslam.R;


public class FeedActivityFragment extends Fragment {

    public FeedActivityFragment() {

    }

    public static FeedActivityFragment newInstance() {
        return new FeedActivityFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed_activity, container, false);

        return view;
    }

}
