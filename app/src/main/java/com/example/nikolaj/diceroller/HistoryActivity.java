package com.example.nikolaj.diceroller;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nikolaj on 04/03/2016.
 */
public class HistoryActivity extends ListActivity{
    ArrayList<Dices> dices;
    DiceAdapter myAdapter;
    Button btnClear;
    TextView txtDices;
    String yolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dices = new ArrayList<Dices>();
        Intent intent = getIntent();
        dices = (ArrayList<Dices>) intent.getSerializableExtra("dicesList");
        btnClear = (Button) findViewById(R.id.btnClear);
        myAdapter = new DiceAdapter(dices);


        setListAdapter(myAdapter);
    }

    public void setListeners(){
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dices.clear();
                txtDices.setText("");

            }
        });
    }

    private class DiceAdapter extends BaseAdapter{
        private LayoutInflater inflater;
        private ArrayList<Dices> dicesList;

        public DiceAdapter(ArrayList<Dices> dices){
            dicesList = dices;
            inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE); // takes the XML-files and creates different View-objects from its contents.
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if(view == null){
                view = inflater.inflate(R.layout.activity_history, parent, false);
            }

            txtDices = (TextView) view.findViewById(R.id.txtDice);

            String text = "";


            txtDices.setText("Roll: " + (position + 1) + " = " + dices.get(position).getDiceList());



            return view;
        }

        @Override
        public int getCount() {
            return dicesList.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Dices getItem(int position) {
            return dicesList.get(position);
        }
    }
}
