package com.linson.android.sundayplayer.activities;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linson.android.sundayplayer.appHelper;
import com.linson.android.sundayplayer.service.IPlayer;
import com.linson.android.sundayplayer.service.MusicService;

import app.lslibrary.androidHelper.LSLog;
import app.lslibrary.pattern.LSListener;

public class Welcome extends AppCompatActivity
{
    public static MyConnection mConnection;
    public static final String SERVERNAME="ProvideService";
    public static LSListener<Integer> mListener_Broadcast=new LSListener();


    private boolean mIsFirstLoad=true;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        LSLog.Log_INFO();
        super.onCreate(savedInstanceState);

        //connection 是不用退出的。因为这里connection被设定为系统级别，而不是页面级别，这里比较特殊，所以不需要谁建立，谁释放的原则。
        setupConnection();

        IntentFilter intent=new IntentFilter(MusicService.BORADCASTNAME);
        registerReceiver(new MyReceiver(), intent);
        getApplication().getApplicationContext();

        mListener_Broadcast.addOrder(new LSListener.IOrder<Integer>()
        {
            @Override
            public void onHappen(Integer o)
            {
                LSLog.Log_INFO("welcome:"+o);
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        if(!mIsFirstLoad)
        {
            finish();
        }
        mIsFirstLoad=false;
    }

    //返回静态变量，不存在被系统回收的可能。
    public static MyConnection getmConnection()
    {
        return mConnection;
    }

    private void setupConnection()
    {
        Intent intent=new Intent();
        intent.setPackage(getPackageName());
        intent.setAction(SERVERNAME);
        mConnection=new MyConnection();
        bindService(intent, mConnection, BIND_AUTO_CREATE);
    }

    //region serverConnection
    public class MyConnection implements ServiceConnection
    {
        public IPlayer mPlayer;
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            mPlayer=IPlayer.Stub.asInterface(service);
            MasterPage.StartMe(Welcome.this);
            LSLog.Log_INFO();
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        { }
    }
    //endregion

    //region Broadcast Receiver
    private static class MyReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            //check baseinfo 2.call event for all order.
            int msgType= appHelper.checkMsgtype(intent);
            if(msgType==1)
            {
                int res=intent.getIntExtra(MusicService.MSG1VAR1, 0);
                LSLog.Log_INFO("broadcast:"+res);

               mListener_Broadcast.NoticeOrder(res);
            }
        }
    }
    //endregion
}