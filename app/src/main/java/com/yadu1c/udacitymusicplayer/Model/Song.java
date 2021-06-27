package com.yadu1c.udacitymusicplayer.Model;

public class Song {
    String mName;
    String mSinger;
    int mThumbnail;
    double mStartTime;
    double mEndTime;

    public Song(String sName, String sSinger, double sStartTime, double sEndTime, int sThumbnail) {
        mStartTime = sStartTime;
        mEndTime = sEndTime;
        mSinger = sSinger;
        mName = sName;
        mThumbnail = sThumbnail;
    }

    public String getmName() {
        return mName;
    }

    public String getmSinger() {
        return mSinger;
    }

    public int getmThumbnail() {
        return mThumbnail;
    }

    public double getmStartTime() {
        return mStartTime;
    }

    public double getmEndTime() {
        return mEndTime;
    }
}
