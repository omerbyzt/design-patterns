package com.ba.observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}