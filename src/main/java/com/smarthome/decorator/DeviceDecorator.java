package com.smarthome.decorator;


    @Override
    public void turnOn() {
        delegate.turnOn();
    }

    @Override
    public void turnOff() {
        delegate.turnOff();
    }

}
