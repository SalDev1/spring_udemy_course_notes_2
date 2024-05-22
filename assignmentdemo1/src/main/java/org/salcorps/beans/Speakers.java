package org.salcorps.beans;


import org.springframework.stereotype.Component;

@Component
public class Speakers {
    public String speakerName;
    public String getSpeakerName() {
        return speakerName;
    }
    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
    public void makeSound(String s) {
        System.out.println(s);
    }
}
