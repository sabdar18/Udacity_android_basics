package com.sabdar.android.copychallenge.pojo;

import android.widget.ImageView;

/**
 * Created by sabdar on 15-03-2018.
 */

public class Chat {
    private int mImageView;
    private String mUserName;
    private String mMessage;
    private String mTimeDate;
    private boolean mShowNew;
    private int mMessageCount;
    private int mIconResource;
    private boolean  mShowIcon;


    public Chat(int mImageView, String mUserName, String mMessage, String mTimeDate, boolean mShowNew, int mMessageCount, int mIconResource, boolean mShowIcon) {
        this.mImageView = mImageView;
        this.mUserName = mUserName;
        this.mMessage = mMessage;
        this.mTimeDate = mTimeDate;
        this.mShowNew = mShowNew;
        this.mMessageCount = mMessageCount;
        this.mIconResource = mIconResource;
        this.mShowIcon = mShowIcon;
    }

    public int getImageView() {
        return mImageView;
    }

    public void setImageView(int mImageView) {
        this.mImageView = mImageView;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getTimeDate() {
        return mTimeDate;
    }

    public void setTimeDate(String mTimeDate) {
        this.mTimeDate = mTimeDate;
    }

    public boolean isShowNew() {
        return mShowNew;
    }

    public void setShowNew(boolean showNew) {
        this.mShowNew = showNew;
    }

    public int getMessageCount() {
        return mMessageCount;
    }

    public void setMessageCount(int mMessageCount) {
        this.mMessageCount = mMessageCount;
    }

    public int getIconResource() {
        return mIconResource;
    }

    public void setIconResource(int mIconResource) {
        this.mIconResource = mIconResource;
    }

    public boolean isShowIcon() {
        return mShowIcon;
    }

    public void setShowIcon(boolean mShowIcon) {
        this.mShowIcon = mShowIcon;
    }
}

