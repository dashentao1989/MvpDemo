package com.kakasure.mvpdemo.p;

import android.graphics.AvoidXfermode;
import android.os.Message;

import com.kakasure.mvpdemo.callback.ActivityCallback;
import com.kakasure.mvpdemo.m.Model;

import java.util.AbstractCollection;

/**
 * Created by Administrator on 2015/9/21.
 */
public class MainPersenter extends BasePersenter {
    private static MainPersenter persenter;
    private static Object object = new Object();

    public static MainPersenter getInstance() {
        if (persenter == null) {
            synchronized (object) {
                if (persenter == null) {
                    persenter = new MainPersenter();
                }
            }
        }
        return persenter;
    }

    /**
     * 操作
     */
    public void Opreation1(ActivityCallback activityCallback) {
        mActivityCallback = activityCallback;
        Model model = new Model();
        String result = model.test1();
        Message message = Message.obtain();
        message.what = ACTION_1;
        message.obj = result;
        sendMsg(message);
    }

    @Override
    public void destoryInstance() {
        if (persenter != null) {
            persenter = null;
            object = null;
        }
    }
}
