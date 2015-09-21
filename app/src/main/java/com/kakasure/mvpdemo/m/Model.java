package com.kakasure.mvpdemo.m;

/**
 * Created by Administrator on 2015/9/21.
 */
public class Model {
    public Model() {}

    public String test1() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(i + "");
        }
        return sb.toString();
    }
}
