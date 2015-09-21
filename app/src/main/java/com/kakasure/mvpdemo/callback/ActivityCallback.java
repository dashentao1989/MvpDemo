package com.kakasure.mvpdemo.callback;

import android.animation.ObjectAnimator;

/**
 * Created by Administrator on 2015/9/21.
 */
public interface ActivityCallback {
    /**
     * return to UI<br/>
     *
     * @param action
     * @param object
     */
    void toUI(int action, Object object);
}
