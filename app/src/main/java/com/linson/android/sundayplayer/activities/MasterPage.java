package com.linson.android.sundayplayer.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linson.android.sundayplayer.R;
import com.linson.android.sundayplayer.appHelper;

import app.lslibrary.androidHelper.LSActivity;
import app.lslibrary.androidHelper.LSLog;
import app.lslibrary.androidHelper.LSUI;

public class MasterPage extends AppCompatActivity
{
    public static void StartMe(Activity activity)
    {
        Intent intent=new Intent(activity, MasterPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            int res = Welcome.getmConnection().mPlayer.add(3, 8);
            LSLog.Log_INFO(res+"");
        }
        catch (Exception e)
        {
            LSLog.Log_Exception(e);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_page);

        Index.FragmentVariable variable=new Index.FragmentVariable();
        variable.myid=3;
        appHelper.AddCategoryFragment(getSupportFragmentManager(), Index.GetMyInstance(variable));
    }
}