package com.linson.android.sundayplayer.service;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;

public class MyPlayer extends IPlayer.Stub
{
    public Context mContext;

    public MyPlayer(Context context)
    {
        mContext=context;
    }

    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException
    {

    }

    @Override
    public int add(int a, int b) throws RemoteException
    {
        Intent intent=new Intent(MusicService.BORADCASTNAME);
        intent.putExtra(MusicService.MSG1VAR1, a+b);
        mContext.sendBroadcast(intent);
        return a+b;
    }

}