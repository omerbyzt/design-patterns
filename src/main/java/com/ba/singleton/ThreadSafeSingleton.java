package com.ba.singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton threadSafeSingleton;

    private  ThreadSafeSingleton(){
    }

    public static synchronized ThreadSafeSingleton getThreadSafeSingleton() {
        if(threadSafeSingleton == null){
            threadSafeSingleton = new ThreadSafeSingleton();
        }
        return threadSafeSingleton;
    }

    public void testThreadSafeSingleton(){
        System.out.println("Thread Safe singleton method calisti...");
    }

}
