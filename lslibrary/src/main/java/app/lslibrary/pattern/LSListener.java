package app.lslibrary.pattern;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import app.lslibrary.androidHelper.LSLog;

public class LSListener<T>
{
    public interface IOrder<A>
    {
        void onHappen(A data);
    }

    public List<IOrder> LISTENERS = new ArrayList<>();

    public void addOrder(IOrder order)
    {
        LISTENERS.add(order);
    }

    public void unOrder(IOrder order)
    {
        LISTENERS.remove(order);
    }

    public void NoticeOrder(T parameter)
    {
        for (IOrder item : LISTENERS)
        {
            if (item != null)
            {
                try
                {
                    item.onHappen(parameter);
                }
                catch (Exception e)
                {
                    LSLog.Log_Exception(e);
                }
            }
        }
    }
}