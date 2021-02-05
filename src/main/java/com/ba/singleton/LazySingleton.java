package com.ba.singleton;

public class LazySingleton {

    private static LazySingleton lazySingleton;

    private  LazySingleton(){
    }

    public static LazySingleton getLazySingleton() {
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    public void testLazySingleton(){
        System.out.println("Lazy singleton method calisti...");
    }
}
