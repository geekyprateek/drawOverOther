package com.prateektask2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.prateektask2.R;

/**
 * Created by prateekgupta on 10/10/16.
 */

public class ParentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        findViewById(R.id.tinderActivity).setOnClickListener(this);
        findViewById(R.id.accessActivity).setOnClickListener(this);
        findViewById(R.id.callActivity).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.tinderActivity){
            startActivity(new Intent(ParentActivity.this,TinderCardsActivity.class));
        }
        else if(view.getId() == R.id.accessActivity){
            startActivity(new Intent(ParentActivity.this,MainActivity.class));
        }else if(view.getId() == R.id.callActivity){
            startActivity(new Intent(ParentActivity.this,LogsActivity.class));
        }
    }
}
