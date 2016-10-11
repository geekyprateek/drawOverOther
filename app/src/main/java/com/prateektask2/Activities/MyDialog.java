package com.prateektask2.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.prateektask2.Adapter.CouponsAdapter;
import com.prateektask2.Models.Coupons;
import com.prateektask2.R;

import java.util.ArrayList;


public class MyDialog extends Activity {
    public static boolean active = false;
    public static Activity myDialog;

    EditText edt;
    Button btn;
    View top;

    RecyclerView recyclerView;
    CouponsAdapter couponAdapter;

    ArrayList<Coupons> coupons =  new ArrayList<>();

    ArrayList<Coupons> targetCoupons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.dialog);
        recyclerView = (RecyclerView) findViewById(R.id.rv_chat);

        couponAdapter = new CouponsAdapter(getBaseContext());
        createCoupons();

        String appname = getIntent().getStringExtra("appname");


            for (Coupons c: coupons) {
            if(c.getTag().contains(appname)){
                targetCoupons.add(c);
            }
        }

        couponAdapter.setCoupon(targetCoupons);

        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(couponAdapter);


       /* edt = (EditText) findViewById(R.id.dialog_edt);
        btn = (Button) findViewById(R.id.dialog_btn);
        top = (View)findViewById(R.id.dialog_top);*/

        myDialog = MyDialog.this;

        /*btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String str = edt.getText().toString();
                if(str.length() > 0){
//					ChatHeadService.showMsg(MyDialog.this, str);
                    Intent it = new Intent(MyDialog.this, ChatHeadService.class);
                    it.putExtra(Utils.EXTRA_MSG, str);
                    startService(it);
                }
            }
        });


        top.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });*/

    }


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        active = true;
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        active = false;
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        active = false;
    }


    private void createCoupons(){

        Coupons coupon = new Coupons();
        coupon.setMainString("flipkart Cashback");
        coupon.setDescription("Get 500 off");
        coupon.setTag("Transport,Ticket,Bus,coupon,flipkart,myntra");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("Amazon Offer");
        coupon.setDescription("Get 75 off");
        coupon.setTag("food,biryani,Thai,continental,indian,amazon");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("Myntra offer");
        coupon.setDescription("Get 20% off");
        coupon.setTag("movie,fun,entertainment,myntra");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("FK Live");
        coupon.setDescription("FK 2000 cashback");
        coupon.setTag("fun,entertainment,flipkart");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("50% off on lab books");
        coupon.setDescription("1mg offer");
        coupon.setTag("Test,medical,health,amazon");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("Flipkart Ticket");
        coupon.setDescription("Ticket New 75 off");
        coupon.setTag("movie,fun,entertainment,flipkart");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("Myntra");
        coupon.setDescription("Myntra Sale");
        coupon.setTag("Transport,Ticket,Bus,myntra");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("jabong Offer");
        coupon.setDescription("Get 75 off all orders");
        coupon.setTag("food,biryani,Thai,continental,indian,jabong");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("paytm Jet Airways");
        coupon.setDescription("starting @ 299 ticketing");
        coupon.setTag("Transport,Ticket,Bus,paytm");

        coupons.add(coupon);


        coupon = new Coupons();
        coupon.setMainString("Bookmyshow tickets");
        coupon.setDescription("Cricket ticket 200 off");
        coupon.setTag("movie,fun,entertainment,cricket,paytm");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("Bookmyshow ");
        coupon.setDescription("PVR special 500 off");
        coupon.setTag("movie,fun,entertainment,freecharge");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("deals hi deals");
        coupon.setDescription("Hot deal fares dropped");
        coupon.setTag("Transport,cab,ola,myntra");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("Deals diwali");
        coupon.setDescription("Hot deal 55% off");
        coupon.setTag("Transport,cab,Zoomcmar,myntra,flipkart");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("Myntttt");
        coupon.setDescription("15% cahback");
        coupon.setTag("Wallet,deal,zomato,food,myntra");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("Amazon");
        coupon.setDescription("Amazon exclusive : best price");
        coupon.setTag("stay,room,hotel,amazon");

        coupons.add(coupon);


        coupon = new Coupons();
        coupon.setMainString("HYD");
        coupon.setDescription("50% off");
        coupon.setTag("food,online delivery,eat,biryani,thai,indian,flipkart,amazon,myntra,jabong");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("gifts");
        coupon.setDescription("20% off ICICI card");
        coupon.setTag("love,flowers,cake,gifts,amazon,flipkart");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("JC");
        coupon.setDescription("10% off ");
        coupon.setTag("Entertainment ,food,jabong");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("MMT Hotel");
        coupon.setDescription("hotels exclusive : 3190 off");
        coupon.setTag("Travel,hotel,paytm");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("Cash ki deal");
        coupon.setDescription("10% off ");
        coupon.setTag("food ,cake,flipkart,amazon,jabong,myntra");

        coupons.add(coupon);

        coupon = new Coupons();
        coupon.setMainString("BookMeds");
        coupon.setDescription("1mg offer");
        coupon.setTag("medical,health,Medicines,amazon,flipkart");

        coupons.add(coupon);

    }



}