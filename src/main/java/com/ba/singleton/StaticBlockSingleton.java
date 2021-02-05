package com.ba.singleton;

public class StaticBlockSingleton {

    private static StaticBlockSingleton staticBlockSingleton;

    static {
        try{
            staticBlockSingleton = new StaticBlockSingleton();
        }catch(Exception e){
        }
    }

    private StaticBlockSingleton(){
    }

    public static StaticBlockSingleton getStaticBlockSingleton(){
        return staticBlockSingleton;
    }

    public void staticBlockTest(){
        System.out.println("Static block singleton method calisti...");
    }
}
