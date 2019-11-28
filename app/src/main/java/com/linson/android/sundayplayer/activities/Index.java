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
    public static Fragment getFragmentInstance(BunderVariable var)
    {
        Fragment fragment=new Index();
        Bundle bundle=new Bundle();
        bundle.putSerializable(BaseFragment.BunderVariableNAME,var );
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        BunderVariable var=(BunderVariable) getArguments().getSerializable(BaseFragment.BunderVariableNAME);
        LSLog.Log_INFO("var1:"+var.intVar1);
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