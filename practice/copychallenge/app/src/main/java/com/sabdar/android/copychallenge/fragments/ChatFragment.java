package com.sabdar.android.copychallenge.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sabdar.android.copychallenge.R;
import com.sabdar.android.copychallenge.adapters.ChatAdapter;
import com.sabdar.android.copychallenge.pojo.Chat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabdar on 15-03-2018.
 */

public class ChatFragment extends Fragment  {

    private  RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private List<Chat> mChatList;
    private List<Integer> mImages;


    public  ChatFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initImages();
        initChatItems();
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ChatAdapter(mChatList, view.getContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initChatItems() {

        mChatList = new ArrayList<>();
        mChatList.add(new Chat(mImages.get(0),"Whitmans Chat",
                "Ned: Yeah, I think i know what we want to know about that will be ", "11:45 AM",true,3, 0,false ));
        mChatList.add(new Chat(mImages.get(1),"Stewart Family",
                "Steve: Great, thanks!","11:39 AM", true, 1, 0, false));
        mChatList.add(new Chat(mImages.get(2),"Alice Whitman",
                "Photo","YESTERDAY", false, 0, R.drawable.svg_camera, true));
        mChatList.add(new Chat(mImages.get(3),"Jack Whitman",
                "Video","3/15/18", false, 0, R.drawable.svg_video, true));
        mChatList.add(new Chat(mImages.get(4),"Lunch Group",
                "Sounds good!","3/15/18", false, 0, R.drawable.svg_double_tick, true));
        mChatList.add(new Chat(mImages.get(5),"Jane Pearson",
                "Photo","3/15/18", false, 0, R.drawable.svg_camera, true));
        mChatList.add(new Chat(mImages.get(6),"Sabdar Shaik",
                "Hello Sabdar","3/14/18", false, 0,R.drawable.svg_single_tick, true));
        mChatList.add(new Chat(mImages.get(2),"Alice Whitman",
                "Photo","3/14/18", false, 0, R.drawable.svg_camera, true));
        mChatList.add(new Chat(mImages.get(3),"Jack Whitman",
                "Video","3/14/18", false, 0, R.drawable.svg_video, true));
        mChatList.add(new Chat(mImages.get(4),"Lunch Group",
                "Sounds good!","3/13/18", false, 0, R.drawable.svg_double_tick, true));
        mChatList.add(new Chat(mImages.get(5),"Jane Pearson",
                "Photo","3/13/18", false, 0, R.drawable.svg_camera, true));
        mChatList.add(new Chat(mImages.get(6),"Sabdar Shaik",
                "Welcome Sabdar","3/13/18", false, 0,R.drawable.svg_double_tick, true));

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
