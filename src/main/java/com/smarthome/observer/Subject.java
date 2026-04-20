package com.smarthome.observer;

/**
 * 观察者模式：主题接口。
 */
public interface Subject {
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();
}
