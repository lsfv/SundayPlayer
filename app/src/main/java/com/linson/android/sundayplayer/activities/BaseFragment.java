package com.linson.android.sundayplayer.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.io.Serializable;
import java.security.PublicKey;

public abstract class BaseFragment extends Fragment
{



    //提供方法而不是成员变量，因为想让调用者自己清楚调用的时机，必须是activity之后。错误可以给出提示。
    public MasterPage getMaster()
    {
        MasterPage res=null;
        if(getActivity() instanceof  MasterPage)
        {
            res=(MasterPage) getActivity();
        }
        if(res==null)
        {
            throw new Error("master is null,please check call the function after activity is created.");
        }
        else
        {
            return res;
        }
    }

    //region 提供简便的参数服务。
    public static final String BunderVariableNAME="vv";
    public static class BunderVariable implements Serializable
    {
        int intVar1;
        int intVar2;
    }
    //在fragment中，最好定义一个静态的FragmentHelper对象来生成Fragment,而不是定义一个生成fragment静态方法。
    //这样强制fragment的参数类型必须使用BunderVariable，如果参数需要自定义，在fragment中。定义一个重载BunderVariable的类就好了。
    public static abstract class FragmentHelper
    {
        public abstract Fragment getFragmentInstance(BunderVariable var);
    }
    //endregion
}