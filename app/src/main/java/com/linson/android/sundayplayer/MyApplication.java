package com.linson.android.sundayplayer;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.linson.android.sundayplayer.service.IPlayer;

import app.lslibrary.androidHelper.LSLog;

public class MyApplication extends Application
{
    private static Context mContext;
    @Override
    public void onCreate()
    {
        LSLog.Log_INFO();
        super.onCreate();
        mContext=getApplicationContext();
    }

    public static Context getmContext()
    {
        return mContext;
    }
}