package com.designpatterns.creational.singleton;

public class SingletonSync {

    private static SingletonSync mSingletonSync=null;

    private SingletonSync(){

    }

    public static synchronized SingletonSync getSingletonSync(){
        if (mSingletonSync == null) {
            mSingletonSync=new SingletonSync();
        }
        return mSingletonSync;
    }

}