package com.smarthome.mode;

import com.smarthome.state.HomeModeState;

public class ModeContext {
    private HomeModeState current;

    public void switchTo(HomeModeState state) {
        state.apply(this);
    }

    public HomeModeState getCurrent() {
        return current;
    }

    public void setCurrent(HomeModeState current) {
        this.current = current;
    }
}
