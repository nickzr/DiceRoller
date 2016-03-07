package com.example.nikolaj.diceroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRoll;
    Button btnHistory;
    NumberPicker npDices;
    TextView txtEyes;
    ArrayList<Dice> diceList;
    ArrayList<Dices> dicesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRoll = (Button) findViewById(R.id.btnRoll);
        btnHistory = (Button) findViewById(R.id.btnHistory);
        npDices = (NumberPicker) findViewById(R.id.npDices);
        txtEyes = (TextView) findViewById(R.id.txtEyes);
        txtEyes.setText("");

        dicesList = new ArrayList<Dices>();

        npDices.setMinValue(1);
        npDices.setMaxValue(6);
        npDices.setValue(1);

        setListeners();
    }

    private void setListeners() {
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDices(npDices.getValue());
            }
        });
//
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), HistoryClass.class);
                intent.putExtra("dicesList", dicesList);
                startActivity(intent);
            }
        });
    }

    public void rollDices(int dices){
        txtEyes.setText("");
        Random rand = new Random();
        diceList = new ArrayList<Dice>();

        for(int i = 1; i <= dices; i++){
            Dice dice = new Dice(rand.nextInt(6) +1);
            diceList.add(dice);
            txtEyes.setText(txtEyes.getText() + "Dice " + i + " = " + dice + "\n");
        }
        Dices dices1 = new Dices(diceList);
        dicesList.add(dices1);
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedText", txtEyes.getText().toString());
        outState.putInt("savedPicker", npDices.getValue());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        txtEyes.setText(savedInstanceState.getString("savedText"));
        npDices.setValue(savedInstanceState.getInt("savedPicker"));
    }

}
