package org.salcorps.implementation;

import org.salcorps.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MichelinTyres implements Tyres {

    @Override
    public String rotate(){
        return "Vehicle moving with Michelin tyres";
    }

}
