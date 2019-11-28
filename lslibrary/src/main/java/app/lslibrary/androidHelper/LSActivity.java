package app.lslibrary.androidHelper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public abstract class LSActivity
{
    public static void ClearAndAddFragment(FragmentManager fragmentManager, int ParentGroupID, Fragment fragment,boolean backStack)
    {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(ParentGroupID, fragment);
        if(backStack)
        {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}