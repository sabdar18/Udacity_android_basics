package com.sabdar.android.copychallenge.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sabdar.android.copychallenge.R;
import com.sabdar.android.copychallenge.adapters.CallAdapter;
import com.sabdar.android.copychallenge.adapters.ChatAdapter;
import com.sabdar.android.copychallenge.pojo.Call;
import com.sabdar.android.copychallenge.pojo.Chat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabdar on 18-03-2018.
 */

public class CallFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private List<Call> mCallList;
    private List<Integer> mImages;


    public  CallFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_call, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initImages();
        initCallItems();
        mRecyclerView = view.findViewById(R.id.call_recycler_view);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CallAdapter(mCallList, view.getContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initCallItems() {

        mCallList = new ArrayList<>();
        mCallList.add(new Call(mImages.get(0),"Whitmans Chat",
                "February 15, 8:52 PM ",true, false ));
        mCallList.add(new Call(mImages.get(1),"Stewart Family",
                "February 10, 4:52 PM ", true,false));
        mCallList.add(new Call(mImages.get(2),"Alice Whitman",
                "11/23/17, 3:24 AM", false,  true));
        mCallList.add(new Call(mImages.get(3),"Jack Whitman",
                "10/22/17, 5:38 AM", false, false));
        mCallList.add(new Call(mImages.get(4),"Lunch Group",
                "9/20/17, 8:30 PM", true, true));
        mCallList.add(new Call(mImages.get(5),"Jane Pearson",
                "8/12/17, 7:54 AM", false,  false));
        mCallList.add(new Call(mImages.get(6),"Sabdar Shaik",
                "8/8/17, 8:30 PM", false, true));
        mCallList.add(new Call(mImages.get(2),"Alice Whitman",
                "7/5/17, 6:38 AM", true,  true));
        mCallList.add(new Call(mImages.get(3),"Jack Whitman",
                "7/28/17, 7:50 PM", false, false));
        mCallList.add(new Call(mImages.get(4),"Lunch Group",
                "7/13/17, 5:50 AM", true,  true));
        mCallList.add(new Call(mImages.get(5),"Jane Pearson",
                "6/18/17, 3:30 PM", false,   false));
        mCallList.add(new Call(mImages.get(6),"Sabdar Shaik",
                "6/12/17, 3:24 AM", false, true));

    }


    private void initImages(){

        mImages = new ArrayList <>();
        mImages.add(R.drawable.img_1);
        mImages.add(R.drawable.img_2);
        mImages.add(R.drawable.img_3);
        mImages.add(R.drawable.img_4);
        mImages.add(R.drawable.img_5);
        mImages.add(R.drawable.img_6);
        mImages.add(R.drawable.img_7);
        mImages.add(R.drawable.img_8);

    }
}
