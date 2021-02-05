package com.ba.singleton;

public class Run {

    public static void main(String[] args) {

        EagerInitializationSingleton.getInstance().singletonTest();
        StaticBlockSingleton.getStaticBlockSingleton().staticBlockTest();
        LazySingleton.getLazySingleton().testLazySingleton();
        ThreadSafeSingleton.getThreadSafeSingleton().testThreadSafeSingleton();
        BillPughSingleton.getInstance().testBillPughSingleton();
    }
}
