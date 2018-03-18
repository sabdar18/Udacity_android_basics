package com.sabdar.android.copychallenge.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sabdar.android.copychallenge.R;
import com.sabdar.android.copychallenge.pojo.Call;

import java.util.List;

/**
 * Created by sabdar on 18-03-2018.
 */

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.ViewHolder> {


    private List<Call> mCallList;
    private Context mContext;

    public CallAdapter(List<Call> mCallList, Context context) {
        this.mCallList = mCallList;
        this.mContext = context;
    }

    @Override
    public CallAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.call_item, parent, false
        );

        CallAdapter.ViewHolder viewHolder = new CallAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CallAdapter.ViewHolder holder, int position) {

        Call mCall = mCallList.get(position);
        holder.nameTV.setText(mCall.getUserName());
        holder.profileIV.setImageDrawable(mContext.getResources().getDrawable(mCall.getImageView()));
        holder.messageTV.setText(mCall.getTimeDate());
        if(mCall.isCall()){
            holder.messageTV.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.drawable.ic_call_received_black_24dp), null, null, null);
        }else{
            holder.messageTV.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.drawable.ic_call_made_black_24dp), null, null, null);

        }
        if(mCall.isShowIcon()) {
            holder.callButton.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_call_black_24dp));
        }else{
            holder.callButton.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_videocam_black_24dp));
        }

    }

    @Override
    public int getItemCount() {
        return mCallList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView profileIV;
        public TextView nameTV;
        public TextView messageTV;
        public ImageButton callButton;


        public ViewHolder(View itemView) {
            super(itemView);
            profileIV = itemView.findViewById(R.id.call_profile_image_view);
            nameTV = itemView.findViewById(R.id.call_user_text_view);
            messageTV = itemView.findViewById(R.id.call_message_text_view);
            callButton = itemView.findViewById(R.id.call_video_button);

        }
    }
}
