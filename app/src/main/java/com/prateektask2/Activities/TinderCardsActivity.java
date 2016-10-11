package com.prateektask2.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.prateektask2.Adapter.CardsDataAdapter;
import com.prateektask2.R;
import com.wenchao.cardstack.CardStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by prateekgupta on 10/10/16.
 */

public class TinderCardsActivity extends AppCompatActivity implements CardStack.CardEventListener {


    CardStack mCardStack;
    CardsDataAdapter mCardAdapter;
    SharedPreferences preferences;
    HashSet<String> dealSet = new HashSet<>();
    ArrayList<String> dealList = new ArrayList<>();

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Deal = "deal";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder);


        mCardStack = (CardStack)findViewById(R.id.container);
        preferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        mCardStack.setContentResource(R.layout.card_layout);
        mCardStack.setStackMargin(20);

        HashSet<String> set = (HashSet<String>) preferences.getStringSet(Deal,null);
        mCardAdapter = new CardsDataAdapter(getApplicationContext(), 0);
        if(set == null) {
            mCardAdapter.add("Flipkart 20 % off");
            mCardAdapter.add("OLA 200 Off");
            mCardAdapter.add("Myntra 1500 off on first purchase");
            mCardAdapter.add("jabong deal hi deal");
            mCardAdapter.add("Zomato Din ka offer");
            mCardAdapter.add("Zoomcar free day");
            mCardAdapter.add("PVR Loot");
            mCardAdapter.add("Special GrabOn Deals");
            mCardAdapter.add("Paytm free ka Money");
            mCardAdapter.add("Free Biryani..");
            mCardAdapter.add("Din ka Din offer");


        }else{

            createDeals();

            if(set.size() == 0){
                mCardAdapter.add("Flipkart 20 % off");
                mCardAdapter.add("OLA 200 Off");
                mCardAdapter.add("Myntra 1500 off on first purchase");
                mCardAdapter.add("jabong deal hi deal");
                mCardAdapter.add("Zomato Din ka offer");
                mCardAdapter.add("Zoomcar free day");
                mCardAdapter.add("PVR Loot");
                mCardAdapter.add("Special GrabOn Deals");
                mCardAdapter.add("Paytm free ka Money");
                mCardAdapter.add("Free Biryani..");
                mCardAdapter.add("Din ka Din offer");
            }
            else {
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    String s = (String) iterator.next();
                    mCardAdapter.add(dealList.get(Integer.parseInt(s)));
                    dealSet.add(s);
                }
            }
        }

        mCardStack.setAdapter(mCardAdapter);
        mCardStack.setListener(this);

    }


    public void createDeals(){
        dealList.add("Flipkart 20 % off");
        dealList.add("OLA 200 Off");
        dealList.add("Myntra 1500 off on first purchase");
        dealList.add("jabong deal hi deal");
        dealList.add("Zomato Din ka offer");
        dealList.add("Zoomcar free day");
        dealList.add("PVR Loot");
        dealList.add("Special GrabOn Deals");
        dealList.add("Paytm free ka Money");
        dealList.add("Free Biryani..");
        dealList.add("Din ka Din offer");

    }

    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet(Deal,dealSet);
        editor.apply();
        super.onPause();
    }

    @Override
    public boolean swipeEnd(int section, float distance) {
        return true;
    }

    @Override
    public boolean swipeStart(int section, float distance) {
        return true;
    }

    @Override
    public boolean swipeContinue(int section, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void discarded(int mIndex, int direction) {
        if(direction == 1  || direction == 3 ){
            if(mIndex != 0)
             dealSet.add(Integer.toString(mIndex - 1 ));
        }else{
            if(dealSet.contains(Integer.toString(mIndex - 1 ))){
                dealSet.remove(Integer.toString(mIndex - 1 ));
            }
        }

    }

    @Override
    public void topCardTapped() {

        mCardStack.discardTop(3);
        dealSet.add(Integer.toString(mCardStack.getCurrIndex()));
        Toast.makeText(getBaseContext(),"Your Deal is Saved :)",Toast.LENGTH_SHORT).show();

    }
}
