package com.uis.carmensandiego.carmensandiego;

import android.os.Parcel;
import android.os.Parcelable;

class WrapperActivity implements Parcelable{
    private MainActivity activity;

    public WrapperActivity(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public MainActivity getActivity(){
        return activity;
    }

    //CODIGO QUE NO ES IMPORTANTE --IGNORAR

    protected WrapperActivity(Parcel in) {}

    public static final Creator<WrapperActivity> CREATOR = new Creator<WrapperActivity>() {
        @Override
        public WrapperActivity createFromParcel(Parcel in) {
            return new WrapperActivity(in);
        }

        @Override
        public WrapperActivity[] newArray(int size) {
            return new WrapperActivity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {}

    //////////////////////////////////////////////
}
