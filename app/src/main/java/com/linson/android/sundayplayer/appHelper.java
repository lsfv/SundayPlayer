package com.linson.android.sundayplayer;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.linson.android.sundayplayer.activities.Index;

import app.lslibrary.androidHelper.LSActivity;

public abstract class appHelper
{
    public static int checkMsgtype(Intent intent)
    {
        return 1;
    }

    public static void AddCategoryFragment(FragmentManager fragmentManager, Fragment fragment)
    {
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        LSActivity.ClearAndAddFragment(fragmentManager, R.id.mainFragment, fragment,false);
    }

    public static void AddNextFragment(FragmentManager fragmentManager, Fragment fragment)
    {
        LSActivity.ClearAndAddFragment(fragmentManager, R.id.mainFragment, fragment,true);
    }
}