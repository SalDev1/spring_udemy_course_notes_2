package org.salcorps.beans;

import org.springframework.stereotype.Component;

@Component
public class Wheels {
    public String wheelName;
    public String getWheelName() {
        return wheelName;
    }
    public void setWheelName(String wheelName) {
        this.wheelName = wheelName;
    }
    public void rotate(String s) {
        System.out.println(s);
    }
}
