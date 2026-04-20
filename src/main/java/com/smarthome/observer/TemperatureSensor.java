package com.smarthome.observer;

import java.util.ArrayList;
import java.util.List;


    private double temperature;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }


        observers.add(observer);
    }

    @Override

        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        }
    }
}
