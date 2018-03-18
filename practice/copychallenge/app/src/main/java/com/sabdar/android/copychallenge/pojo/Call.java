package com.sabdar.android.copychallenge.pojo;

/**
 * Created by sabdar on 18-03-2018.
 */

public class Call {
    private int mImageView;
    private String mUserName;
    private String mTimeDate;
    private boolean mCall;
    private boolean mShowIcon;

    public Call(int mImageView, String mUserName, String mTimeDate, boolean mCall, boolean mShowIcon) {
        this.mImageView = mImageView;
        this.mUserName = mUserName;
        this.mTimeDate = mTimeDate;
        this.mCall = mCall;
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

    public String getTimeDate() {
        return mTimeDate;
    }

    public void setTimeDate(String mTimeDate) {
        this.mTimeDate = mTimeDate;
    }

    public boolean isCall() {
        return mCall;
    }

    public void setCall(boolean mCall) {
        this.mCall = mCall;
    }



    public boolean isShowIcon() {
        return mShowIcon;
    }

    public void setShowIcon(boolean mShowIcon) {
        this.mShowIcon = mShowIcon;
    }
}
