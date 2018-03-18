package com.sabdar.android.copychallenge.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sabdar.android.copychallenge.R;
import com.sabdar.android.copychallenge.pojo.Chat;

import java.util.List;

/**
 * Created by sabdar on 15-03-2018.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<Chat> mChatList;
    private Context mContext;

    public ChatAdapter(List<Chat> mChatList, Context context) {
        this.mChatList = mChatList;
        this.mContext = context;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.chat_item, parent, false
        );

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {

        Chat mChat = mChatList.get(position);
        Log.i("Chat ", mChat.getMessage());
        holder.profileIV.setImageResource(mChat.getImageView());
        holder.nameTV.setText(mChat.getUserName());
        holder.messageTV.setText(mChat.getMessage());
        if(mChat.isShowIcon()) {
            holder.messageTV.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(mChat.getIconResource()), null, null, null);
        }
        holder.timeTv.setText(mChat.getTimeDate());
        if (mChat.isShowNew()) {
            holder.timeTv.setTextColor(mContext.getResources().getColor(R.color.colorGreen));
            holder.statusTv.setText(String.valueOf(mChat.getMessageCount()));
        } else {
            holder.statusTv.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mChatList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView profileIV;
        public TextView nameTV;
        public TextView messageTV;
        public TextView timeTv;
        public TextView statusTv;


        public ViewHolder(View itemView) {
            super(itemView);
            profileIV = itemView.findViewById(R.id.call_profile_image_view);
            nameTV = itemView.findViewById(R.id.call_user_text_view);
            messageTV = itemView.findViewById(R.id.call_message_text_view);
            timeTv = itemView.findViewById(R.id.time_text_view);
            statusTv = itemView.findViewById(R.id.status_text_view);
        }
    }
}
