package com.example.pet.pet;

import java.awt.*;

public enum PetState {
    Idle(4, 0, new Dimension(1, 2)), //2
    Cleaning_Paw(4, 2, new Dimension(3, 13)), //10
    Cleaning_Ear(4, 3, new Dimension(14, 22)), //8
    Walking(8, 4, new Dimension(23, 63)), //40
    Running(8, 5, new Dimension(64, 84)), //20
    Sleeping(4, 6, new Dimension(85, 87)), //2
    Playing(6, 7, new Dimension(88, 98)),
    Jumping(7, 8, new Dimension(99, 99)),
    Stretching(8, 9, new Dimension(100, 100));
    //100

    //Implemented :
    /*
    *   Idle
    *   Walking
    */

    int length;
    int y;
    Dimension range;

    PetState( int length, int yCoord, Dimension range) {
        this.length = length;
        this.y = yCoord;
        this.range = range;
    }

    public int getLength() {
        return this.length;
    }

    public int getY() {
        return this.y;
    }

    public Dimension getRange() {
        return this.range;
    }

    public PetState[] getEnumValues() {
        PetState[] enums = PetState.values();
        return enums;
    }

    public PetState getEnumByValue(int value) {
        PetState[] enums = getEnumValues();
        for(int i = 0; i < enums.length; i++) {
            if(enums[i].getRange().width <= value && enums[i].getRange().height >= value) {
                return enums[i];
            }
        }

        return null;
    }
}
