package com.smarthome.state;

import com.smarthome.mode.ModeContext;

public interface HomeModeState {
    String name();
    void apply(ModeContext context);
}
