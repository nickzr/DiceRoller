package com.example.nikolaj.diceroller;

import java.util.ArrayList;

/**
 * Created by Nikolaj on 04/03/2016.
 */
public class Dices {
    ArrayList<Dice> diceList;

    public Dices(){

    }

    public ArrayList<Dice> getDiceList(){
        return getDiceList();
    }

    public void setDiceList(ArrayList<Dice> dices){
        for (Dice dice : dices) {
            diceList.add(dice);
        }
    }
}
