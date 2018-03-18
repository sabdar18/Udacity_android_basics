package com.sabdar.android.copychallenge.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sabdar.android.copychallenge.R;

/**
 * Created by sabdar on 18-03-2018.
 */

public class StatusFragment extends Fragment {

    public StatusFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_status, container, false);
        return rootView;
    }

}
