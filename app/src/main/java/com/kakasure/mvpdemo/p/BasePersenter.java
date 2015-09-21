package com.kakasure.mvpdemo.p;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.kakasure.mvpdemo.callback.ActivityCallback;

/**
 * Created by Administrator on 2015/9/21.
 */
public abstract class BasePersenter {
    protected ActivityCallback mActivityCallback;
    /**
     * 动作唯一绑定标志
     */
    public static final int ACTION_1 = 1;

    private void toUI(Message msg) {
        if (mActivityCallback != null) {
            mActivityCallback.toUI(msg.what, msg.obj);
        }
    }

    private Handler myHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            toUI(msg);
        }
    };

    protected void sendMsg(Message message) {
        myHandler.sendMessage(message);
    }

    /**
     * 调用实例销毁时同步销毁Persenter实例,避免单例长期被持有,导致潜在的内存泄露
     */
    public abstract void destoryInstance();
}
