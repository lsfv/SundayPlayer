package com.linson.android.sundayplayer.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linson.android.sundayplayer.R;

import java.io.Serializable;

import app.lslibrary.androidHelper.LSLog;

public class Index extends BaseFragment
{
    public static Fragment GetMyInstance(FragmentVariable vv)
    {
        Fragment fragment=new Index();
        Bundle bundle=new Bundle();
        bundle.putSerializable(VARIABLENAME, vv);
        fragment.setArguments(bundle);
        return  fragment;
    }

    public static class FragmentVariable implements Serializable
    {
        int myid=-1;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle mybunder= getArguments();
        FragmentVariable variables=(FragmentVariable) mybunder.get(VARIABLENAME);
        LSLog.Log_INFO("vv:"+variables.myid);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_index, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }
}