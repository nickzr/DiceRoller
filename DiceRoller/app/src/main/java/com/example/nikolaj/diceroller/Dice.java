package com.example.nikolaj.diceroller;

import java.io.Serializable;

/**
 * Created by Nikolaj on 04/03/2016.
 */
public class Dice implements Serializable{
    public int eyes;

    public Dice(int eyes){
        this.eyes = eyes;
    }

    public int getEyes(){
        return eyes;
    }

    @Override
    public String toString() {
        return "" + eyes;
    }
}
