package org.salcorps.implementation;

import org.salcorps.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class BridgeStoneTyres implements Tyres {

    @Override
    public String rotate(){
        return "Vehicle moving with BridgeStone tyres";
    }
}
