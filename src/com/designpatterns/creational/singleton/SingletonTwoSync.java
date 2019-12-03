package com.designpatterns.creational.singleton;

public class SingletonTwoSync {

    private static SingletonTwoSync mSingletonSync=null;

    private SingletonTwoSync(){

    }

    public static SingletonTwoSync getSingletonSync(){
        if (mSingletonSync == null) {
            synchronized (SingletonTwoSync.class){
                if (mSingletonSync == null) {
                    mSingletonSync=new SingletonTwoSync();
                }
            }
        }
        return mSingletonSync;
    }
}