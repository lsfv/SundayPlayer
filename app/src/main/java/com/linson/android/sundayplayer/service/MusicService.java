package com.linson.android.sundayplayer.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import app.lslibrary.androidHelper.LSLog;


public class MusicService extends Service
{
    private MyPlayer mPlayer;
    public static final String BORADCASTNAME="aa";
    public static final String MSG1VAR1="res";


    @Override
    public void onCreate()
    {
        LSLog.Log_INFO();
        super.onCreate();
        mPlayer=new MyPlayer(getApplicationContext());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        LSLog.Log_INFO();
        return mPlayer;
    }
}