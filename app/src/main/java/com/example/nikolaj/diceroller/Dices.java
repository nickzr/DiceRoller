package com.example.nikolaj.diceroller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Nikolaj on 04/03/2016.
 */
public class Dices implements Serializable {
    ArrayList<Dice> diceList;

    public Dices(ArrayList<Dice> dices){
        diceList = dices;
    }

    public ArrayList<Dice> getDiceList(){
        return diceList;
    }

    @Override
    public String toString() {
        String text = "";
        for(Dice dice:diceList)
        {
            text = text + dice.eyes;
        }
        return text;
    }

    public void clearList(){
        diceList.clear();
    }
}
