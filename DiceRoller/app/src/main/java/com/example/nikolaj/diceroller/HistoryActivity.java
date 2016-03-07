package com.example.nikolaj.diceroller;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nikolaj on 04/03/2016.
 */
public class HistoryActivity extends ListActivity{
    ArrayList<Dice> dices;
    DiceAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dices = new ArrayList<Dice>();
        Intent intent = getIntent();
        dices = (ArrayList<Dice>) intent.getSerializableExtra("diceList");
        myAdapter = new DiceAdapter(dices);

        setListAdapter(myAdapter);
    }

    private class DiceAdapter extends BaseAdapter{
        private LayoutInflater inflater;
        private ArrayList<Dice> diceList;

        public DiceAdapter(ArrayList<Dice> dices){
            diceList = dices;
            inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE); // takes the XML-files and creates different View-objects from its contents.
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if(view == null){
                view = inflater.inflate(R.layout.activity_history, parent, false);
            }

            TextView txtDices = (TextView) view.findViewById(R.id.txtDice);

            Dice temp = diceList.get(position);

            txtDices.setText("Dice: " + position + 1 + " = " + temp.getEyes());

            return view;
        }

        @Override
        public int getCount() {
            return diceList.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Dice getItem(int position) {
            return diceList.get(position);
        }
    }
}
